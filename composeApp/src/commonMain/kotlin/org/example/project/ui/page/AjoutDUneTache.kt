package org.example.project.ui.page

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import org.example.project.domain.ajouter_une_tache.AjoutDUneTacheEvent
import org.example.project.domain.ajouter_une_tache.AjoutDUneTacheViewModel
import org.example.project.enums.TaskPriorityEnum

@Composable
fun AjoutDUneTache(navController: NavHostController) {
    val viewModel: AjoutDUneTacheViewModel = viewModel { AjoutDUneTacheViewModel() }
    val state by viewModel.state.collectAsState()

    Scaffold(
        modifier = Modifier.fillMaxSize().padding(10.dp),
        topBar = {
            TopAppBar(
                title = { Text("Ajouter une tâche") },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigateUp()
                    }){
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        },
        bottomBar = {
            OutlinedButton(onClick = {
                viewModel.onEventHandler(AjoutDUneTacheEvent.OnSave)
            }) {
                Text("ajouter")
            }
        }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(it).fillMaxSize()
        ) {
            OutlinedTextField(
                value = state.task.name,
                onValueChange = { viewModel.onEventHandler(AjoutDUneTacheEvent.OnNameChange(it)) },
                label = { Text("Name") },
                // colors = colors
            )
            OutlinedTextField(
                value = state.task.description,
                onValueChange = {
                    viewModel.onEventHandler(
                        AjoutDUneTacheEvent.OnDescriptionChange(
                            it
                        )
                    )
                },
                label = { Text("Description") },
                // colors = colors
            )
            OutlinedTextField(
                value = state.task.priority.toString(),
                onValueChange = {
                    viewModel.onEventHandler(
                        AjoutDUneTacheEvent.OnPriorityChange(
                            TaskPriorityEnum.valueOf(it)
                        )
                    )
                },
                label = { Text("Priority") },
                //  colors = colors
            )

        }
    }
}