package com.example.cardsflash

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cardsflash.gameui.FlashCardViewModel
import com.example.cardsflash.ui.theme.brshapeFontFamily
import com.example.cardsflash.ui.theme.lexendFontFamily

@Composable
fun CallerFunction(
    flashCardViewModel: FlashCardViewModel = viewModel(),
) {
    val flashCardUiState by flashCardViewModel.uiState.collectAsState()
    HomeScreenLayout(
        currentQuestion = flashCardUiState.currentQuestion,
        userAnswer = flashCardViewModel.userAnswer,
        onClick1 = { flashCardViewModel.submit() },
        onClick2 = { flashCardViewModel.skip() },
        isAnswerWrong = flashCardUiState.isAnswerWrong,
        userScore = flashCardUiState.userScore,
        onUserAnswerChanged = { flashCardViewModel.updateUserAnswer(it) })

}

@Composable
fun hideKeyboard(){

}

@Composable
fun HomeScreenLayout(
    currentQuestion: String,
    userAnswer: String,
    onClick1: () -> Unit,
    onClick2: () -> Unit,
    isAnswerWrong: Boolean,
    onUserAnswerChanged: (String) -> Unit,
    userScore: Int,
    modifier: Modifier = Modifier
        .fillMaxSize()

) {

    val controller = LocalSoftwareKeyboardController.current
    
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .padding(20.dp)
    ) {

        Text(
            text = "Test your knowledge \nof Basic Arithmetic",
            fontSize = 24.sp,
            fontFamily = brshapeFontFamily,
            fontWeight = FontWeight.Medium,
            lineHeight = 1.3.em,
            color = Color.Black,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(30.dp))
        Card(
            shape = RoundedCornerShape(10.dp),
            elevation = CardDefaults.cardElevation(12.dp),
            colors = CardDefaults.cardColors(
                containerColor = colorResource(R.color.card_blue),
                contentColor = colorResource(R.color.white)
            ),
            modifier = Modifier
                .size(280.dp, 300.dp)

        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp)
            ) {
                Text(
                    text = currentQuestion,
                    fontSize = 42.sp,
                    fontFamily = brshapeFontFamily,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Center,
                )
            }
        }
        Spacer(
            modifier = Modifier
                .height(20.dp)
        )

        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 35.dp)
        ) {
            Text(
                text = stringResource(R.string.score, userScore),
                fontSize = 22.sp,
                fontFamily = brshapeFontFamily,
                fontWeight = FontWeight.Medium,
                )
        }

        Spacer(modifier = Modifier.height(50.dp))

        OutlinedTextField(
            value = userAnswer,
            onValueChange = onUserAnswerChanged,
            singleLine = true,
            isError = isAnswerWrong,
            placeholder = {
                Text(
                    text = "Input Your Answer",
                    fontFamily = brshapeFontFamily,
                    fontWeight = FontWeight.Normal
                )
            },
            textStyle = TextStyle(
                fontFamily = brshapeFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 20.sp
            ),
            keyboardActions = KeyboardActions(
                onSend = { controller?.hide() }
            ),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number
            )
        )

        Spacer(
            modifier = Modifier
                .height(60.dp)
        )

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ) {

            OutlinedButton(
                onClick = onClick2,
                shape = RoundedCornerShape(6.dp),
                border = BorderStroke(1.dp, colorResource(R.color.button_color)),
                modifier = Modifier

            ) {
                Text(
                    text = "Skip",
                    fontFamily = brshapeFontFamily,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(R.color.button_color),
                    fontSize = 16.sp,
                    modifier = Modifier
                        .padding(8.dp, 5.dp)
                )
            }

            Button(
                onClick = onClick1,
                shape = RoundedCornerShape(6.dp),
                colors = ButtonDefaults.buttonColors(colorResource(R.color.button_color)),
                modifier = Modifier
            ) {
                Text(
                    text = "Submit",
                    fontFamily = brshapeFontFamily,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(R.color.white),
                    fontSize = 16.sp,
                    modifier = Modifier
                        .padding(8.dp, 5.dp)

                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    CallerFunction()
}
