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
import com.example.quix_kotlin.quiz.Questao

@Composable
fun CardQuestaoDinamico(
    modifier: Modifier = Modifier,
    pergunta: Questao,
    numeroAtual: Int,
    totalPerguntas: Int,
    onRespostaSelecionada: (String) -> Unit
) {
    Card(
        modifier = Modifier
            .height(50.dp)
            .width(300.dp)
            .background(Color.Gray)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Pergunta $numeroAtual de $totalPerguntas",
                textAlign = TextAlign.Center
            )
        }
    }

    Card(
        modifier = Modifier
            .padding(35.dp)
            .height(320.dp) // Aumentado um pouco para caber melhor os botões
            .width(300.dp)
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = pergunta.texto,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Cria um botão dinamicamente para cada opção da pergunta atual
            pergunta.opcoes.forEach { opcao ->
                Button(
                    onClick = { onRespostaSelecionada(opcao) },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(248, 222, 89)
                    ),
                    modifier = Modifier.width(200.dp)
                ) {
                    Text(
                        text = opcao,
                        color = Color.Black
                    )
                }
            }
        }
    }
}
