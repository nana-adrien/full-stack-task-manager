package org.example.project.ui.page.base

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.example.project.enums.PagesEnum
import org.example.project.ui.page.Acceuils
import org.example.project.ui.page.AjoutDUneTache
import org.example.project.ui.page.ListDesTaches

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = PagesEnum.ACCEUILS.toString()
    ) {
        composable(
            route = PagesEnum.ACCEUILS.toString(),
        ) {
            Acceuils(
                navController=navController
            )
        }
        composable(
            route = PagesEnum.LIST_DES_TACHES.toString(),
        ) {
            ListDesTaches(
                navController=navController
            )
        }
        composable(
            route = PagesEnum.CREATION_DES_TACHES.toString(),
        ) {
            AjoutDUneTache(
                navController=navController
            )
        }
    }
}