package com.usfuchsia.noteappcompose.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.usfuchsia.noteappcompose.data.NoteRepository
import com.usfuchsia.noteappcompose.data.model.Note
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(
    private val repository: NoteRepository
) : ViewModel() {
    private val _allNote = MutableStateFlow<List<Note>>(emptyList())
    val allNote = _allNote

    fun getAllNote() {
        viewModelScope.launch {
            repository.getAllNote.collect {
                _allNote.value = it
            }
        }
    }
}