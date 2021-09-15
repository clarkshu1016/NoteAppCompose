package com.usfuchsia.noteappcompose.data

import com.usfuchsia.noteappcompose.data.model.Note
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ViewModelScoped
class NoteRepository @Inject constructor(
    private val noteDao: NoteDao
) {
    val getAllNote: Flow<List<Note>> = noteDao.getAllNote()

    val sortByHighPriority: Flow<List<Note>> = noteDao.sortByHighPriority()

    val sortByLowPriority: Flow<List<Note>> = noteDao.sortByLowPriority()

    fun getNoteById(note: Note): Flow<Note> {
        return noteDao.getNoteById(note.id)
    }

    suspend fun insertNote(note: Note) {
        return noteDao.insertNote(note)
    }

    suspend fun updateNote(note: Note) {
        return noteDao.updateNote(note)
    }

    suspend fun deleteNote(note: Note) {
        return noteDao.deleteNote(note)
    }

    suspend fun deleteAllNote() {
        return noteDao.deleteAllNote()
    }
}