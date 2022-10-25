package com.example.notes.NotesFeatures.DATA.ROOM

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.notes.NotesFeatures.DOMAIN.MODEL.Notes
import kotlinx.coroutines.flow.Flow

@Dao
interface NotesDAO {
     // retrieve all the Notes list
     @Query("SELECT * FROM Notes")
     fun getAllNotes(): Flow<List<Notes>>

 // retrieve only one Notes of the database
     @Query("SELECT * FROM Notes WHERE Id = (:Notesid)")
     suspend fun getNotes(Notesid:Int):Notes?

     // insert Notes in database
     @Insert(onConflict = OnConflictStrategy.REPLACE)
     suspend fun InsertNotes(notes: Notes)

     //delete a Notes
     @Delete
     suspend fun deleteNotes(notes: Notes)
}