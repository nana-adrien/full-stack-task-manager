package org.example.project.ui.page

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import org.example.project.enums.PagesEnum

@Composable
fun Acceuils(navController: NavHostController) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text("Gestionnaire de tâches") },
            )
        },
    ) {
        Column(
            modifier = Modifier.padding(it).fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Text("Bienvenue sur l'application de gestion de tâches")

            Text("Cette application vous permet de gérer vos tâches de manière simple et efficace")

            Spacer(Modifier.padding(vertical = 30.dp))

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center,verticalAlignment = Alignment.CenterVertically){
                OutlinedButton(onClick = {
                    navController.navigate(PagesEnum.CREATION_DES_TACHES.toString())
                }) {
                    Text("Ajouter une tâche")
                }
                Spacer(modifier = Modifier.padding(vertical = 10.dp))
                OutlinedButton(onClick = {
                    navController.navigate(PagesEnum.LIST_DES_TACHES.toString())
                }) {

                    Text("Consulter la liste des tâches")
                }
            }
        }
    }
}