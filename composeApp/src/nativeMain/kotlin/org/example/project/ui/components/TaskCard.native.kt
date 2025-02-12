package org.example.project.ui.components

import androidx.compose.runtime.Composable
import org.example.project.modele.Task

@Composable
actual fun TaskCard(
    task: Task,
    onDeleted: (Task) -> Unit,
    onUpdated: (Task) -> Unit
) {



}