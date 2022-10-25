package com.example.notes.NotesFeatures.DATA.ROOM

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.notes.NotesFeatures.DOMAIN.MODEL.Notes

@Database(entities = [Notes::class], version = 1)
abstract class NotesDatabase: RoomDatabase() {

    abstract val notesDAO:NotesDAO

    companion object{
        const val DATABASE_NAME= "notes_db"
    }
}