package com.dmwaresolutions.wordhiltapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.dmwaresolutions.wordhiltapp.model.Word
import com.dmwaresolutions.wordhiltapp.repository.WordRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WordsViewModel @Inject constructor(private val wordRepo: WordRepository): ViewModel() {

    fun saveWord(wordTxt: String) = liveData<Boolean> {
        try {
            wordRepo.insertWords(Word(0, wordTxt))
            emit(true)
        }catch (e: Exception){
            emit(false)
        }
    }

    fun getAllWords() = wordRepo.getAllWords()

}