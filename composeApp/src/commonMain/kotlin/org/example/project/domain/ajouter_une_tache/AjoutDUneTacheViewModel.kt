package org.example.project.domain.ajouter_une_tache

import kotlinx.coroutines.flow.update
import kotlinx.coroutines.runBlocking
import org.example.project.domain.base.BaseViewModel
import org.example.project.reseau.TaskApi
import org.example.project.reseau.createHttpClient

class AjoutDUneTacheViewModel(
) :
    BaseViewModel<AjoutDUneTacheState, AjoutDUneTacheEvent>(AjoutDUneTacheState()) {
    private val httpClient = createHttpClient()
    private val taskApi = TaskApi(httpClient)
    override fun onEventHandler(event: AjoutDUneTacheEvent) {
        when (event) {
            is AjoutDUneTacheEvent.OnDescriptionChange -> {
                stateData.update {
                    it.copy(task = it.task.copy(description = event.description))
                }
            }

            is AjoutDUneTacheEvent.OnNameChange -> {
                stateData.update {
                    it.copy(task = it.task.copy(name = event.name))
                }
            }

            is AjoutDUneTacheEvent.OnPriorityChange -> {
                stateData.update {
                    it.copy(task = it.task.copy(priority = event.priority))
                }
            }

            AjoutDUneTacheEvent.OnSave -> {
                runBlocking {
                    taskApi.updateTask(stateData.value.task)
                }
            }
        }

    }
}