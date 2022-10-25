package com.example.notes.NotesFeatures.DOMAIN.USES_CASES.GLOBAL_USECASES

import com.example.notes.NotesFeatures.DOMAIN.REPOSITORY.NotesRepository
import com.example.notes.NotesFeatures.DOMAIN.USES_CASES.DeleteNoteUseCase
import com.example.notes.NotesFeatures.DOMAIN.USES_CASES.GetNotesUseCase

data class NotesUseCases(
    val GetAllNotes:GetNotesUseCase,
    val DeleteNotes:DeleteNoteUseCase
)