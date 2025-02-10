package org.example.project.domain.ajouter_une_tache

import org.example.project.enums.TaskPriorityEnum

sealed class AjoutDUneTacheEvent {
    data class OnNameChange(val name: String) : AjoutDUneTacheEvent()
    data class OnDescriptionChange(val description: String) : AjoutDUneTacheEvent()
    data class OnPriorityChange(val priority: TaskPriorityEnum) : AjoutDUneTacheEvent()
    object OnSave : AjoutDUneTacheEvent()
}