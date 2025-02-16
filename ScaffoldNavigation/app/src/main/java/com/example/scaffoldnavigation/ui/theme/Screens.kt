package com.example.scaffoldnavigation.ui.theme

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun MainScreen(navController: NavController) {
    Scaffold(
        topBar = { MainTopAppBar("My app", navController)}
    ) { innerPadding ->
        Text(text = "Home Screen", modifier = Modifier.padding(innerPadding))
    }
}

@Composable
fun InfoScreen(navController: NavController) {
    Scaffold(
        topBar = { ScreenTopBar("Info", navController) },
    ) { innerPadding ->
        Text(text = "Info Screen", modifier = Modifier.padding(innerPadding))
    }
}

@Composable
fun SettingsScreen(navController: NavController) {
    Scaffold(
        topBar = { ScreenTopBar("Settings", navController) },
    ) { innerPadding ->
        Text(text = "Settings Screen", modifier = Modifier.padding(innerPadding))
    }
}