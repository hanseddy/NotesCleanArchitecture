package com.example.notes.NotesFeatures.DOMAIN.UTILS

sealed class OrderType{
    object Ascending:OrderType()
    object Descending:OrderType()
}
