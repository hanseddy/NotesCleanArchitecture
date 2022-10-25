package com.example.notes.NotesFeatures.DOMAIN.USES_CASES

import com.example.notes.NotesFeatures.DOMAIN.MODEL.Notes
import com.example.notes.NotesFeatures.DOMAIN.REPOSITORY.NotesRepository
import com.example.notes.NotesFeatures.DOMAIN.UTILS.NoteOrder
import com.example.notes.NotesFeatures.DOMAIN.UTILS.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetNotesUseCase(
    private val notesRepository: NotesRepository) {

    operator fun invoke(
        noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending)): Flow<List<Notes>>{
        return notesRepository.getAllNotes().map { notes ->
            when(noteOrder.orderType){
                is OrderType.Ascending ->{
                    when(noteOrder){
                        is NoteOrder.Title -> notes.sortedBy { it.Title.lowercase() }
                        is NoteOrder.Date -> notes.sortedBy { it.timestamp }
                        is NoteOrder.Color -> notes.sortedBy { it.Color }
                    }
                }
                is OrderType.Descending ->{
                    when(noteOrder){
                        is NoteOrder.Title -> notes.sortedByDescending { it.Title.lowercase() }
                        is NoteOrder.Date -> notes.sortedByDescending { it.timestamp }
                        is NoteOrder.Color -> notes.sortedByDescending { it.Color }
                    }
                }
            }
        }
    }
}