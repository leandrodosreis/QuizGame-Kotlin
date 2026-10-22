package com.example.quix_kotlin.quiz

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.quix_kotlin.R
import com.example.quix_kotlin.components.CardQuestaoDinamico
import com.example.quix_kotlin.quiz.Questao

@Composable
fun QuizScreen(modifier: Modifier = Modifier, navController: NavHostController) {
    // 1. Lista com as suas 3 perguntas
    val listaPerguntas = remember {
        listOf(
            Questao(
                texto = "Qual o time mais absurdo do mundo?",
                opcoes = listOf("CORINTHIANS!", "Palmeirinhas", "São Paulininhos", "Santinhos"),
                respostaCorreta = "CORINTHIANS!"
            ),
            Questao(
                texto = "Pergunta 2: Qual a capital do Brasil?",
                opcoes = listOf("São Paulo", "Rio de Janeiro", "Brasília", "Salvador"),
                respostaCorreta = "Brasília"
            ),
            Questao(
                texto = "Pergunta 3: Quanto é 2 + 2?",
                opcoes = listOf("3", "4", "5", "6"),
                respostaCorreta = "4"
            )
        )
    }

    // 2. Estados controlados pelo componente Pai
    var indiceAtual by remember { mutableStateOf(0) }
    var score by remember { mutableStateOf(0) }

    Box(modifier = modifier.fillMaxSize().background(Color(230,60,60))){
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.quiz),
                contentDescription = "quiz",
                modifier = Modifier.size(80.dp)
            )

            // Pega os dados da pergunta atual da lista
            val perguntaAtual = listaPerguntas[indiceAtual]

            // Chamamos o Card passando o estado atual e o que fazer ao clicar
            CardQuestaoDinamico(
                pergunta = perguntaAtual,
                numeroAtual = indiceAtual + 1,
                totalPerguntas = listaPerguntas.size,
                onRespostaSelecionada = { resposta ->
                    // Verifica se acertou e incrementa o score de forma reativa
                    if (resposta == perguntaAtual.respostaCorreta) {
                        score++
                    }

                    // Se ainda houverem perguntas, avança o índice. Se for a última, vai para o resultado.
                    if (indiceAtual < listaPerguntas.size - 1) {
                        indiceAtual++
                    } else {
                        // Passa o score como argumento na rota se quiser mostrar na tela final
                        navController.navigate("resultado?pontos=$score") {
                            // Limpa a tela de quiz do histórico para o usuário não voltar nas perguntas ao clicar em "voltar"
                            popUpTo("quiz") { inclusive = true }
                        }
                    }
                }
            )
        }
    }
}
