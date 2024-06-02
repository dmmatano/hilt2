package com.dmwaresolutions.wordhiltapp.di

import androidx.lifecycle.ViewModel
import com.dmwaresolutions.wordhiltapp.database.WordDao
import com.dmwaresolutions.wordhiltapp.repository.WordRepository
import com.dmwaresolutions.wordhiltapp.repository.WordRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object WordsModule {
    @Provides
    fun provideWprdRepository(wordDao: WordDao): WordRepository{
        return WordRepositoryImpl(wordDao)
    }
}