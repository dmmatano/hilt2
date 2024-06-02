package com.dmwaresolutions.wordhiltapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.input.input
import com.dmwaresolutions.wordhiltapp.databinding.ActivityMainBinding
import com.dmwaresolutions.wordhiltapp.ui.adapter.WordAdapter
import dagger.hilt.android.AndroidEntryPoint

/**
 * Video: https://www.youtube.com/watch?v=UlqTh795Jbg&list=PLrJS8IW7z9HFg1yAfjtMly5PIjlCDMoLe&index=8
 * Parei em: 35m
 *
 */

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: WordsViewModel by viewModels()
    private lateinit var wordAdapter: WordAdapter


    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        setupRecyclerview()
        viewModel.getAllWords().observe(this){
            wordAdapter.submitList(it)
        }

        binding.btnAddWord.setOnClickListener {
            showAddWordDialog()
        }
    }

    private fun setupRecyclerview() {
        binding.rvWords.apply {
            wordAdapter = WordAdapter()
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = wordAdapter
        }
    }

    private fun showAddWordDialog() {
        MaterialDialog(this).show{
            input { materialDialog, text ->
                viewModel.saveWord(text.toString()).observe(this@MainActivity){
                    if(it){
                        Toast.makeText(this@MainActivity,"SALVO COM SUCESSO",Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this@MainActivity,"ERRO!",Toast.LENGTH_SHORT).show()
                    }
                }
            }
            positiveButton(text = "Enviar")
        }
    }
}