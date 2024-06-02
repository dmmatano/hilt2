package com.dmwaresolutions.wordhiltapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dmwaresolutions.wordhiltapp.model.Word

@Database(entities = [Word::class], exportSchema = false, version = 1)
abstract class WordsDatabase: RoomDatabase() {
    abstract fun wordDao(): WordDao

}
