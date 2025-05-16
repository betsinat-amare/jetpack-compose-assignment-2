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
import androidx.lifecycle.SavedStateHandle

@HiltViewModel
class TodoDetailViewModel @Inject constructor(
    private val repository: TodoRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    var uiState by mutableStateOf<TodoUiState>(TodoUiState.Loading)
        private set

    init {
        val todoId: Int = savedStateHandle["id"] ?: 0
        viewModelScope.launch {
            try {
                val todo = repository.getTodoById(todoId)
                if (todo != null) {
                    uiState = TodoUiState.Success(todo)
                } else {
                    uiState = TodoUiState.Error("Todo not found")
                }
            } catch (e: Exception) {
                uiState = TodoUiState.Error("Failed to load")
            }
        }
    }
}

