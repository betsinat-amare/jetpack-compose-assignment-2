// File: DatabaseModule.kt
package com.example.todo_app.di

import android.content.Context
import androidx.room.Room
import com.example.todo_app.data.local.TodoDao
import com.example.todo_app.data.local.TodoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): TodoDatabase {
        return Room.databaseBuilder(
            context,
            TodoDatabase::class.java,
            "todo_database"
        ).build()
    }

    @Provides
    fun provideTodoDao(database: TodoDatabase): TodoDao {
        return database.todoDao()
    }
}
