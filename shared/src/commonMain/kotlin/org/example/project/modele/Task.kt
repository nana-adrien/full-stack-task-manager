package org.example.project.modele

import org.example.project.enums.TaskPriorityEnum
import kotlinx.serialization.Serializable

@Serializable
data class Task(
    val name:String,
    val description:String,
    val priority: TaskPriorityEnum,
)