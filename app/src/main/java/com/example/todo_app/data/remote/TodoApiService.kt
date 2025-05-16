package com.example.todo_app.data.remote

import retrofit2.http.GET

data class TodoDto(
    val userId: Int,
    val id: Int,
    val title: String,
    val completed: Boolean
)

interface TodoApiService {
    @GET("todos")
    suspend fun getTodos(): List<TodoDto>
}
