package com.example.notes.NotesFeatures.DATA.REPOSITORYIMPL

import com.example.notes.NotesFeatures.DATA.ROOM.NotesDAO
import com.example.notes.NotesFeatures.DOMAIN.MODEL.Notes
import com.example.notes.NotesFeatures.DOMAIN.REPOSITORY.NotesRepository
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl(private val dao: NotesDAO): NotesRepository {
    override fun getAllNotes(): Flow<List<Notes>> {
        return dao.getAllNotes()
    }

    override suspend fun getNotesById(id: Int): Notes? {
        return dao.getNotes(id)
    }

    override suspend fun InsertNotes(notes: Notes) {
        dao.InsertNotes(notes)
    }

    override suspend fun DeleteNotes(notes: Notes) {
        dao.deleteNotes(notes)
    }
}