package com.example.todo_app.ViewModels


import com.example.todo_app.data.local.TodoEntity

sealed class TodoUiState {
    object Loading : TodoUiState()
    data class Success(val todo: TodoEntity) : TodoUiState()
    data class Error(val message: String) : TodoUiState()
}
