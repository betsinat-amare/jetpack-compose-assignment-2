package com.example.todo_app.data.repository

import com.example.todo_app.data.local.TodoDao
import com.example.todo_app.data.local.TodoEntity
import com.example.todo_app.data.remote.TodoApiService
import javax.inject.Inject

class TodoRepository @Inject constructor(
    private val api: TodoApiService,
    private val dao: TodoDao
) {
    suspend fun getTodos(): List<TodoEntity> {
        return try {
            val todosFromApi = api.getTodos()
            val entities = todosFromApi.map {
                TodoEntity(it.id, it.userId, it.title, it.completed)
            }
            dao.insertTodos(entities)
            entities
        } catch (e: Exception) {
            dao.getAllTodos()
        }
    }

    suspend fun getTodoById(id: Int): TodoEntity? {
        return dao.getAllTodos().find { it.id == id }
    }
}
