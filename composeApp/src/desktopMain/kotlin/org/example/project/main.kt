package org.example.project

import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application


val state= WindowState(
   size = DpSize(350.dp, 600.dp),
   position = WindowPosition(Alignment.Center)
)

fun main() = application {
   Window(
      state = state,
      onCloseRequest = ::exitApplication ,
      title = "Tasks",
   ) {
      App()
   }
}

