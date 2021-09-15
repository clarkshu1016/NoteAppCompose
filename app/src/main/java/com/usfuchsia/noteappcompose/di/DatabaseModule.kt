package com.usfuchsia.noteappcompose.di

import android.content.Context
import androidx.room.Room
import com.usfuchsia.noteappcompose.data.NoteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, NoteDatabase::class.java, "note_database").build()

    @Singleton
    @Provides
    fun provideNoteDao(database: NoteDatabase) = database.noteDao()
}