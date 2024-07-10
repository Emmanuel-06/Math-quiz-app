package com.example.cardsflash.model

data class FlashCardUiState(
    val currentQuestion: String = "",
    val isAnswerWrong: Boolean = false,
    val userScore: Int = 1,
)
