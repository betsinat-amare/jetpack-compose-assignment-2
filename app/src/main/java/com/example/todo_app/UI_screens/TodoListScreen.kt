package com.example.todo_app.UI_screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.todo_app.ViewModels.TodoListViewModel

@Composable
fun TodoListScreen(navController: NavController, viewModel: TodoListViewModel) {
    val todos = viewModel.todos
    val isLoading = viewModel.isLoading
    val error = viewModel.errorMessage

    when {
        isLoading -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = androidx.compose.ui.Alignment.Center) {
                CircularProgressIndicator()
            }
        }
        error != null -> {
            Box(modifier = Modifier.fillMaxSize().padding(16.dp)) {
                Text("Error: $error")
            }
        }
        else -> {
            LazyColumn {
                items(todos) { todo ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .clickable {
                                navController.navigate("detail/${todo.id}")
                            }
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(todo.title, fontWeight = FontWeight.Bold)
                            Text("Completed: ${if (todo.completed) "Yes" else "No"}")
                        }
                    }
                }
            }
        }
    }
}
