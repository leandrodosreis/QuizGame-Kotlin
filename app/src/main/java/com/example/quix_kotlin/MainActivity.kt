package com.example.quix_kotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.quix_kotlin.home.HomeScreen
import com.example.quix_kotlin.quiz.QuizScreen
import com.example.quix_kotlin.resultado.ResultadoScreen
import com.example.quix_kotlin.ui.theme.QuixKotlinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuixKotlinTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = "home" // <--- O NavHost procura essa rota ao abrir o app
                    ) {
                        // 1. Você DEVE registrar a rota "home" aqui dentro!
                        composable(route = "home") {
                            HomeScreen( // Substitua pelo nome correto da sua função de tela inicial
                                navController = navController,
                                modifier = Modifier.padding(innerPadding)
                            )
                        }

                        // 2. Rota do Quiz
                        composable(route = "quiz") {
                            QuizScreen(
                                navController = navController,
                                modifier = Modifier.padding(innerPadding)
                            )
                        }

                        // 3. Rota do Resultado (com os argumentos que corrigimos antes)
                        composable(route = "resultado?pontos={pontos}") { backStackEntry ->
                            val pontos = backStackEntry.arguments?.getString("pontos")?.toIntOrNull() ?: 0
                            ResultadoScreen(
                                navController = navController,
                                modifier = Modifier.padding(innerPadding),
                                pontuacao = pontos
                            )
                        }
                    }


                }
            }
        }
    }
}

