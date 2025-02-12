package org.example.project.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.apache.coyote.BadRequestException
import org.example.project.enums.TaskPriorityEnum
import org.example.project.modele.InMemoryTaskRepository
import org.example.project.modele.Task
import org.springframework.http.HttpStatusCode
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/tasks")
@Tag(name = "UserController", description = "Endpoints d'exemple")
class UserController {

   val repository = InMemoryTaskRepository()

   @Operation(summary = "obtenir la liste des taches actuels", description = "renvoie la liste des taches")
   @GetMapping
   fun getTasks() : List<Task> {
      return repository.allTasks()
   }


   @GetMapping("/byName/{taskName}")
   fun getTaskByName(@RequestParam taskName : String) : Task? {
      if (taskName.isEmpty()) {
         BadRequestException()
         return null
      }
      val task = repository.taskByName(taskName)
      if (task == null) {
         BadRequestException()
         return null
      }
      return task
   }

   @GetMapping("/byPriority/{priority}")
   fun getTasksByPriority(@RequestParam priority : String) : List<Task> {
      if (priority.isEmpty()) {
         BadRequestException()
         return emptyList()
      }
      try {
         val tasks = repository.tasksByPriority(TaskPriorityEnum.valueOf(priority))
         return tasks
      } catch (e : Exception) {
         BadRequestException()
         return emptyList()
      }
   }
   @PostMapping
   fun addOrUpdateTask(@RequestBody task : Task) : Task? {
      try {
         repository.addOrUpdateTask(task)
         return task
      } catch (e : Exception) {
         BadRequestException()
         return null
      }
   }
   @DeleteMapping("/{taskName}")
   fun deleteTask(@RequestParam taskName : String) : Boolean {
      if (taskName.isEmpty()) {
         BadRequestException()
         return false
      }
      try {
         return repository.removeTask(taskName)
      } catch (ex : Exception) {
         return false
      }
   }
}