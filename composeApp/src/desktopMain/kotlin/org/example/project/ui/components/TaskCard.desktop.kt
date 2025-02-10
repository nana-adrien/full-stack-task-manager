package org.example.project.ui.components


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.example.project.modele.Task

@Composable
actual fun TaskCard(
    task: Task,
    onDeleted: (Task) -> Unit,
    onUpdated: (Task) -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(8.dp),
        shape = RoundedCornerShape(CornerSize(8.dp)),
    ) {
        Row(modifier = Modifier.padding(10.dp)) {
            Text(
                modifier = Modifier.weight(1f),
                text = "${task.name} : ${task.description}",
                fontSize = 20.sp,
                fontWeight = pickWeight(task.priority)
            )
            Row(
                modifier = Modifier.weight(1f),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = {
                    onDeleted(task)
                }) {
                    Icon(Icons.Default.Delete, contentDescription = "Delete")
                }
                IconButton(onClick = {
                    onDeleted(task)
                }) {
                    Icon(Icons.Default.Add, contentDescription = "add")
                }
            }
        }
    }
}