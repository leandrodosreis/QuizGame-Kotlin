package com.example.quix_kotlin.resultado

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController

@Composable
fun ResultadoScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    pontuacao: Int
) {
    Column (
        modifier = modifier.fillMaxSize().background((Color(10, 200, 200))),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Você fez $pontuacao pontos!")

        Button(
            onClick = {navController.navigate("home")}
        ){
            Text(
                text = "Jogar novamente"
            )
        }
    }
}
