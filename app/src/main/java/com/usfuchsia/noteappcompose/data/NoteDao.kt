package com.usfuchsia.noteappcompose.data

import androidx.room.*
import com.usfuchsia.noteappcompose.data.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Query("SELECT * FROM note_table ORDER BY id ASC")
    fun getAllNote(): Flow<List<Note>>

    @Query("SELECT * FROM note_table WHERE id=:noteId")
    fun getNoteById(noteId: Int): Flow<Note>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Note)

    @Update
    suspend fun updateNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

    @Query("DELETE  FROM note_table")
    suspend fun deleteAllNote()

    @Query("SELECT * FROM note_table WHERE title LIKE :keyword OR content LIKE :keyword")
    fun searchNoteByKeyword(keyword: String): Flow<List<Note>>

    @Query("SELECT * FROM note_table ORDER BY CASE WHEN priority LIKE 'L%' THEN 1 WHEN priority" +
            " LIKE 'M%' THEN 2 When priority LIKE 'H%' THEN 3 END")
    fun sortByLowPriority(): Flow<List<Note>>

    @Query("SELECT * FROM note_table ORDER BY CASE WHEN priority LIKE 'H%' THEN 1 WHEN priority" +
            " LIKE 'M%' THEN 2 When priority LIKE 'L%' THEN 3 END")
    fun sortByHighPriority(): Flow<List<Note>>
}