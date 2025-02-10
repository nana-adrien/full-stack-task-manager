package org.example.project.ui.page

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import org.example.project.TaskCard
import org.example.project.UpdateTaskDialog
import org.example.project.modele.Task
import org.example.project.reseau.TaskApi
import org.example.project.reseau.createHttpClient


@Composable
fun ListDesTaches() {
    val httpClient = createHttpClient()
    val taskApi = remember { TaskApi(httpClient) }
    var tasks by remember { mutableStateOf(emptyList<Task>()) }
    val scope = rememberCoroutineScope()
    var currentTask by remember { mutableStateOf<Task?>(null) }
    LaunchedEffect(Unit) {
        tasks = taskApi.getAllTasks()
    }

    if (currentTask != null) {
        UpdateTaskDialog(
            currentTask!!,
            onConfirm = {
                scope.launch {
                    taskApi.updateTask(it)
                    tasks = taskApi.getAllTasks()
                }
                currentTask = null
            }
        )
    }

    LazyColumn(
        Modifier.fillMaxWidth()
            .background(TextFieldDefaults.textFieldColors().backgroundColor(true).value)
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        items(tasks) { task ->
            TaskCard(
                task = task,
                onDeleted = {
                    scope.launch {
                        taskApi.removeTask(it)
                        tasks = taskApi.getAllTasks()
                    }
                },
                onUpdated = {
                    scope.launch {
                        currentTask = task
                    }
                }
            )
        }
    }
}