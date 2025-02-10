package org.example.project.domain.ajouter_une_tache

import org.example.project.enums.TaskPriorityEnum
import org.example.project.modele.Task

data class AjoutDUneTacheState(
    val task: Task=Task("","", TaskPriorityEnum.LOW)
)