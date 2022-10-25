package com.example.notes.NotesFeatures.DOMAIN.UTILS

sealed class NoteOrder(val orderType: OrderType){
    class Title(ordertype:OrderType):NoteOrder(ordertype)
    class Date(ordertype:OrderType):NoteOrder(ordertype)
    class Color(ordertype:OrderType):NoteOrder(ordertype)
}
