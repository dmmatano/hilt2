package com.dmwaresolutions.wordhiltapp.database

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomDatabaseModule {
    @Provides
    fun provideWordsDatabase(@ApplicationContext context: Context): WordsDatabase{
        return Room.databaseBuilder(context, WordsDatabase::class.java, "wordsdatabase").build()
    }

    @Provides
    fun provideWordDao(wordsDatabase: WordsDatabase) = wordsDatabase.wordDao()
}