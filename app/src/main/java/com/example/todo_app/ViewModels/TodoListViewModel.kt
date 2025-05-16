package com.example.todo_app.ViewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo_app.data.local.TodoEntity
import com.example.todo_app.data.repository.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoListViewModel @Inject constructor(
    private val repository: TodoRepository
) : ViewModel() {

    var todos by mutableStateOf<List<TodoEntity>>(emptyList())
        private set

    var isLoading by mutableStateOf(true)
        private set

    var errorMessage by mutableStateOf<String?>(null)
        private set

    init {
        fetchTodos()
    }

    private fun fetchTodos() {
        viewModelScope.launch {
            try {
                todos = repository.getTodos()
            } catch (e: Exception) {
                errorMessage = "Failed to load todos"
            } finally {
                isLoading = false
            }
        }
    }
}
