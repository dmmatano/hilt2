package com.dmwaresolutions.wordhiltapp.repository

import androidx.lifecycle.LiveData
import com.dmwaresolutions.wordhiltapp.database.WordDao
import com.dmwaresolutions.wordhiltapp.model.Word
import javax.inject.Inject

class WordRepositoryImpl(private val wordDao: WordDao): WordRepository {
    override suspend fun insertWords(word: Word) {
        wordDao.insert(word)
    }

    override fun getAllWords(): LiveData<List<Word>> {
        return wordDao.getAllWords()
    }
}