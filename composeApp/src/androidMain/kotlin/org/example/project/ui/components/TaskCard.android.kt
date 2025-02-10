package org.example.project.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.example.project.modele.Task

@Composable
actual fun TaskCard(
    task: Task,
    onDeleted: (Task) -> Unit,
    onUpdated: (Task) -> Unit
){
    Card(
        modifier = Modifier.fillMaxWidth().padding(8.dp),
        shape = RoundedCornerShape(CornerSize(8.dp)),
    ){
        Column(modifier = Modifier.padding(10.dp)){
            Text(
                text ="${task.name} : ${task.description}" ,
                fontSize = 20.sp,
                fontWeight = pickWeight(task.priority)
            )
            Row {
                OutlinedButton(onClick = {
                    onDeleted(task)
                }) {
                    Text("Delete")
                }
                Spacer(Modifier.width(8.dp))
                OutlinedButton(onClick = {
                    onUpdated(task)
                }){
                    Text("Update")
                }
            }
        }
    }
}