package com.example.todoapp.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapp.model.Todo
import com.example.todoapp.model.TodosApi
import kotlinx.coroutines.launch

class TodoViewModel: ViewModel() {
    val todos = mutableStateListOf<Todo>()

    init {
        getTodosList()
    }

    private fun getTodosList() {
        viewModelScope.launch {
            var todosApi: TodosApi? = null
            try {
                todosApi = TodosApi.getInstance()
                todos.clear()
                todos.addAll( todosApi.getTodos() )
            } catch (e: Exception) {
                Log.d("ERROR", e.message.toString())
            }
        }
    }
}