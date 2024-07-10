package com.example.cardsflash.model

import androidx.collection.arraySetOf


val a = arraySetOf<Int>(1, 2, 3, 4)
val b = arraySetOf<Int>(3, 5, 7, 9)
val c = arraySetOf<Int>(2, 4, 6, 8)

val a1 = a.random()
val a2 = b.random()
val a3 = c.random()

val allQuestions = setOf<String>("$a1 + $a2 + $a3", "$a1 + $a2 + $a3", "$a1 + $a2 + $a3")

val sum = a1 + a2 + a3



