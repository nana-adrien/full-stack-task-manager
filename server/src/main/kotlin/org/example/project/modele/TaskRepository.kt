package org.example.project.modele

import org.example.project.enums.TaskPriorityEnum

interface TaskRepository {
    fun allTasks():List<Task>
    fun tasksByPriority(priority: TaskPriorityEnum):List<Task>
    fun taskByName(name:String):Task?
    fun addOrUpdateTask(task:Task)
    fun removeTask(name: String):Boolean
}