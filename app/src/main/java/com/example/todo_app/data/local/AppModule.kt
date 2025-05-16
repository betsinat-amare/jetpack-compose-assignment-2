package com.example.todo_app.data.local

import android.app.Application
import androidx.room.Room

fun provideDatabase(app: Application): TodoDatabase {
    return Room.databaseBuilder(app, TodoDatabase::class.java, "todo_db").build()
}
