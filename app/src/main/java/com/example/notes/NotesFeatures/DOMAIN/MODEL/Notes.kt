package com.example.notes.NotesFeatures.DOMAIN.MODEL

import android.graphics.Color
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.notes.R

@Entity
data class Notes(
    @PrimaryKey val Id:Int?=null,
    val Title:String,
    val Content:String,
    val Color:Int,
    val timestamp:Long
)

