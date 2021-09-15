package com.usfuchsia.noteappcompose.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.usfuchsia.noteappcompose.data.model.Note

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}