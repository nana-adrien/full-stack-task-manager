package org.example.project.modele

import org.example.project.enums.TaskPriorityEnum

class InMemoryTaskRepository:TaskRepository {

    private var tasks = listOf(
        Task("Cleaning", "Clean the house", TaskPriorityEnum.LOW) ,
        Task("Gardening", "Mow the lawn", TaskPriorityEnum.MEDIUM),
        Task("Shopping", "Buy the groceries", TaskPriorityEnum.HIGH),
        Task("Painting", "Paint the fence", TaskPriorityEnum.LOW),
        Task("Cooking", "Cook the dinner", TaskPriorityEnum.MEDIUM),
        Task("Relaxing", "Take a walk", TaskPriorityEnum.HIGH),
        Task("Exercising", "Go to the gym", TaskPriorityEnum.LOW),
        Task("Learning", "Read a book", TaskPriorityEnum.MEDIUM),
        Task("Snoozing", "Go for a nap", TaskPriorityEnum.HIGH),
        Task("Socializing", "Go to a party",TaskPriorityEnum.HIGH)
    )



    override fun allTasks(): List<Task> =tasks
    override fun tasksByPriority(priority: TaskPriorityEnum): List<Task> = tasks.filter { it.priority == priority }

    override fun taskByName(name: String): Task? =tasks.find { it.name.equals(name,ignoreCase = true) }

    override fun addOrUpdateTask(task: Task) {
        var notFound = true

        tasks=tasks.map {
            if(it.name.equals(task.name,ignoreCase = true)){
                notFound = false
                task
            }else{
                it}

        }
        if (notFound){
            tasks=tasks.plus(task)
        }
    }
    override fun removeTask(name: String):Boolean {
        val oldTasks = tasks
        tasks=tasks.filterNot { it.name ==name }
        return oldTasks.size >tasks.size
    }

}