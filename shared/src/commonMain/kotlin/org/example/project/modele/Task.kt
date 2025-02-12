package org.example.project.modele

import org.example.project.enums.TaskPriorityEnum
import kotlinx.serialization.Serializable

@Entity

@Serializable
data class Task(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id : Long = 0 ,
        val name : String ,
        val description : String ,
        val priority : TaskPriorityEnum ,
)