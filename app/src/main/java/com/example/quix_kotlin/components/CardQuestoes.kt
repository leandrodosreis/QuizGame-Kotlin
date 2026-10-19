package com.example.quix_kotlin.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun CardQuestoes(modifier: Modifier = Modifier) {
    Card(
        modifier = Modifier
            .height(50.dp)
            .width(300.dp)
            .background(Color.Gray)) {

        Column(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {

            Text(
                text = "Pergunta 1 de 3",
                textAlign = TextAlign.Center
            )

        }

    }

    Card(
        modifier = Modifier.padding(35.dp)
            .height(250.dp)
            .width(300.dp)
            .background(Color.White)
    ) {

        Column(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Qual o time mais absurdo do mundo"
            )

            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(248, 222, 89)
                )
            ) {
                Text(
                    text = "CORINTHIANS!",
                    color = Color.Black
                )
            }

            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(248, 222, 89)
                )
            ) {
                Text(
                    text = "Palmeirinhas",
                    color = Color.Black
                )
            }

            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(248, 222, 89)
                )
            ) {
                Text(
                    text = "São Paulininhos",
                    color = Color.Black
                )
            }

            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(248, 222, 89)
                )
            ) {
                Text(
                    text = "Santinhos",
                    color = Color.Black
                )
            }
        }
    }
}