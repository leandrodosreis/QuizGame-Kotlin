package com.example.quix_kotlin.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.quix_kotlin.R

@Composable
fun HomeScreen(modifier: Modifier = Modifier, navController: NavHostController) {

    Box(
        modifier = modifier.fillMaxSize().background(Color(10, 200, 200))) {

        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painter = painterResource(R.drawable.quiz),
                contentDescription = "quiz",
                modifier = Modifier.size(80.dp))

            Text(
                text = "QUIZATRON 3000",
                fontSize = 32.sp)

            Button(onClick = {navController.navigate("quiz")},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(248, 222, 89)
                )) {
                Text(
                    text = "COMEÇAR!",
                    color = Color.Black
                )
            }
        }
    }
}