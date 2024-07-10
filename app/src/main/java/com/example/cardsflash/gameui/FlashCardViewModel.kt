package com.example.cardsflash.gameui

import android.content.Context
import android.content.Context.INPUT_METHOD_SERVICE
import android.content.Context.INPUT_SERVICE
import android.renderscript.ScriptGroup.Input
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.core.content.ContextCompat.getSystemService
import androidx.lifecycle.ViewModel
import com.example.cardsflash.model.FlashCardUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlin.coroutines.coroutineContext
import kotlin.random.Random

class FlashCardViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(FlashCardUiState())
    val uiState = _uiState.asStateFlow()

    var userAnswer by  mutableStateOf("")
        private set

    private lateinit var currentQuestionDisplayed: String
    private var usedQuestions = mutableSetOf<String>()

    private var firstRandomNumber : Int = 0
    private var secondRandomNumber : Int = 0
    private var thirdRandomNumber : Int = 0

    private var summ: Int = 0

    var supportingText: String =  ""






//    private fun pickRandomQuestionAndDisplay(): String {
//        currentQuestionDisplayed = allQuestions
//
//        return if (usedQuestions.contains(currentQuestionDisplayed)) {
//           pickRandomQuestionAndDisplay()
//        } else {
//            usedQuestions.add(currentQuestionDisplayed)
//            currentQuestionDisplayed
//        }
//    }


    private fun generateRandomQuestion() :String{

        firstRandomNumber = Random.nextInt(3, 7)
        secondRandomNumber = Random.nextInt(1, 4)
        thirdRandomNumber = Random.nextInt(7,9 )

        summ = firstRandomNumber + secondRandomNumber + thirdRandomNumber

        currentQuestionDisplayed = "$firstRandomNumber + $secondRandomNumber + $thirdRandomNumber"

        return currentQuestionDisplayed

    }

//    private fun pickRandomQuestionAndDisplay(): String {
//        currentQuestionDisplayed = allQuestions.random()
//
//        if (usedQuestions.contains(currentQuestionDisplayed)) {
//            usedQuestions.add(currentQuestionDisplayed)
//        }
//        return currentQuestionDisplayed
//    }


    private fun resetGame() {
        usedQuestions.clear()
        _uiState.value = FlashCardUiState(currentQuestion = generateRandomQuestion())
    }

    fun skip(){
        _uiState.update{ currentState ->
            currentState.copy(
                isAnswerWrong = false,
                currentQuestion = generateRandomQuestion())
        }
    }

    fun submit(){
        if(userAnswer.isEmpty()){
            _uiState.update { currentState ->
                currentState.copy(isAnswerWrong = true)

            }
        } else {
            checkUserAnswer()
        }
    }

    private fun checkUserAnswer() {
        if(userAnswer.toInt() == summ) {
            updateUserAnswer("")
            _uiState.update { displayState ->
                displayState.copy(isAnswerWrong = false)
            }

            _uiState.update{ currentState ->
                currentState.copy(currentQuestion = generateRandomQuestion())
            }

        } else {
            _uiState.update { currentState ->
                currentState.copy(isAnswerWrong = true)

            }
        }

    }

    init {
        resetGame()
    }
    fun updateUserAnswer(userInput: String){
        userAnswer = userInput
    }


}