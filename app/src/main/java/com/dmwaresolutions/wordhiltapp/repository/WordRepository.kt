package com.dmwaresolutions.wordhiltapp.repository

import androidx.lifecycle.LiveData
import com.dmwaresolutions.wordhiltapp.model.Word

interface WordRepository {
    suspend fun insertWords(word: Word)

    fun getAllWords(): LiveData<List<Word>>
}