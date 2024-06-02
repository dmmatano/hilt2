package com.dmwaresolutions.wordhiltapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dmwaresolutions.wordhiltapp.R
import com.dmwaresolutions.wordhiltapp.databinding.ItemWordBinding
import com.dmwaresolutions.wordhiltapp.model.Word

class WordAdapter(private val interaction: Interaction? = null ): ListAdapter<Word, WordAdapter.WordViewHolder>(WordDC()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = WordViewHolder(
        ItemWordBinding.inflate(LayoutInflater.from(parent.context),parent,false)
    )

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) = holder.bind(getItem(position))

    interface Interaction{ }

    inner class WordViewHolder(private val binding: ItemWordBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(item: Word){
            binding.word = item
        }
    }

    private class WordDC: DiffUtil.ItemCallback<Word>(){
        override fun areItemsTheSame(oldItem: Word, newItem: Word): Boolean {
            return oldItem.id == newItem.id

        }

        override fun areContentsTheSame(oldItem: Word, newItem: Word): Boolean {
            return oldItem == newItem
        }

    }

}