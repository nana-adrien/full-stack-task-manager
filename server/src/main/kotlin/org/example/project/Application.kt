package org.example.project

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

/*
import io.ktor.http.HttpStatusCode
import io.ktor.serialization.JsonConvertException
import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation
import io.ktor.server.plugins.swagger.swaggerUI
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.response.respondText
import io.ktor.server.routing.delete
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.route
import io.ktor.server.routing.routing
import org.example.project.costant.shared.HttpConstant
import org.example.project.enums.TaskPriorityEnum
import org.example.project.modele.InMemoryTaskRepository
import org.example.project.modele.Task


fun main() {
   embeddedServer(
      Netty ,
      port = HttpConstant.basePort ,
      host = HttpConstant.baseUrl ,
      module = Application::module
   )
      .start(wait = true)
}


fun Application.module() {
   install(ContentNegotiation) {
      json()
   }

   val repository = InMemoryTaskRepository()
   routing {
      swaggerUI(path = "swagger", swaggerFile = "openapi/documentation.yaml")

      route("/tasks") {
         get {
            val tasks = repository.allTasks()
            call.respond(tasks)
         }
         get("/byName/{taskName}") {
            val name = call.pathParameters["taskName"]
            if (name == null) {
               call.respond(HttpStatusCode.BadRequest)
               return@get
            } else {
               val task = repository.taskByName(name)
               if (task == null) {
                  call.respond(HttpStatusCode.NotFound)
               } else {
                  call.respond(task)
               }
            }
         }
         get("/byPriority/{priority}") {
            val priority = call.pathParameters["priority"]
            if (priority == null) {
               call.respond(HttpStatusCode.BadRequest)
               return@get
            }
            try {
               val tasks = repository.tasksByPriority(TaskPriorityEnum.valueOf(priority))
               if (tasks.isEmpty()) {
                  call.respond(HttpStatusCode.NotFound)
                  return@get
               }
               call.respond(tasks)
            } catch (e : IllegalArgumentException) {
               call.respond(HttpStatusCode.BadRequest)
            }
         }

         post {
            try {
               val task = call.receive<Task>()
               repository.addOrUpdateTask(task)
               call.respond(HttpStatusCode.NoContent)
            } catch (ex : IllegalStateException) {
               call.respond(HttpStatusCode.BadRequest)
            } catch (ex : JsonConvertException) {
               call.respond(HttpStatusCode.BadRequest)
            }
         }

         delete("/{taskName}") {
            val name = call.pathParameters["taskName"]
            if (name == null) {
               call.respond(HttpStatusCode.BadRequest)
               return@delete
            }

            if (repository.removeTask(name)) {
               call.respond(HttpStatusCode.NoContent)
            } else {
               call.respond(HttpStatusCode.NotFound)
            }
         }
      }

      get("/") {
         call.respondText("Ktor: ${Greeting().greet()}")
      }
   }
}
*/


@SpringBootApplication
class DemoApplication

fun main(args: Array<String>) {
   runApplication<DemoApplication>(*args)
}
