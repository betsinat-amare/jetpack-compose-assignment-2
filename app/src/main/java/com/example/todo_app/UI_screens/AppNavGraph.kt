package com.example.todo_app.UI_screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.NavType
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.todo_app.ViewModels.TodoDetailViewModel
import com.example.todo_app.ViewModels.TodoListViewModel
@Composable
fun AppNavGraph(
    navController: NavHostController,
    isDarkTheme: Boolean,
    onToggleTheme: () -> Unit,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = "welcome",
        modifier = modifier
    ) {
        composable("welcome") {
            WelcomeScreen(
                onContinue = { navController.navigate("list") },
                isDarkTheme = isDarkTheme,
                onToggleTheme = onToggleTheme
            )
        }
        composable("list") {
            val viewModel: TodoListViewModel = hiltViewModel()
            TodoListScreen(navController = navController, viewModel = viewModel)
        }
        composable(
            route = "detail/{id}",
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) { backStackEntry ->
            val viewModel: TodoDetailViewModel = hiltViewModel()
            val todoId = backStackEntry.arguments?.getInt("id") ?: -1
            TodoDetailScreen(viewModel = viewModel, navController = navController, todoId = todoId)
        }
    }
}
