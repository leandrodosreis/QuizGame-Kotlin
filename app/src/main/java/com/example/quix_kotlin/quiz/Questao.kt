package com.example.quix_kotlin.quiz

data class Questao(
    val texto: String,
    val opcoes: List<String>,
    val respostaCorreta: String
)