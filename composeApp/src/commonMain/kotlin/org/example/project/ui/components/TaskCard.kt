package org.example.project.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import org.example.project.enums.TaskPriorityEnum
import org.example.project.modele.Task

@Composable
 expect fun TaskCard(
    task: Task,
    onDeleted: (Task) -> Unit,
    onUpdated: (Task) -> Unit,
)


fun pickWeight(priority: TaskPriorityEnum)=when(priority){
    TaskPriorityEnum.LOW->FontWeight.SemiBold
    TaskPriorityEnum.MEDIUM->FontWeight.Bold
    TaskPriorityEnum.HIGH,TaskPriorityEnum.VITAL->FontWeight.ExtraBold
}