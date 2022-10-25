package com.example.notes.NotesFeatures.DOMAIN.REPOSITORY

import com.example.notes.NotesFeatures.DOMAIN.MODEL.Notes
import kotlinx.coroutines.flow.Flow

interface NotesRepository {

  fun getAllNotes():Flow<List<Notes>>

  suspend fun getNotesById(id:Int):Notes?

  suspend fun InsertNotes(notes: Notes)

  suspend fun DeleteNotes(notes: Notes)
}