package com.example.notes.NotesFeatures.DOMAIN.USES_CASES

import com.example.notes.NotesFeatures.DOMAIN.MODEL.Notes
import com.example.notes.NotesFeatures.DOMAIN.REPOSITORY.NotesRepository

class DeleteNoteUseCase(private val repository: NotesRepository) {

    suspend operator fun invoke(notes: Notes){
        repository.DeleteNotes(notes)
    }

}