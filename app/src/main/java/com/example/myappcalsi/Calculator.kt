package com.example.myappcalsi

sealed class Calculator{
    data class Number(val number:Int): Calculator()
    object Clear:Calculator()
    object Delete:Calculator()
    object Decimal:Calculator()
    object Calcu:Calculator()
    data class Operation(val operation:CalculatorOperation ):Calculator()
}
