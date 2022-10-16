package com.example.myappcalsi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalculatorViewModel: ViewModel() {

    var state by mutableStateOf(CalculatorState())
private set
    fun onAction(action: Calculator) {
        when(action) {
            is Calculator.Number -> enterNumber(action.number)
            is Calculator.Delete -> delete()
            is Calculator.Clear -> state = CalculatorState()
            is Calculator.Operation -> enterOperation(action.operation)
            is Calculator.Decimal -> enterDecimal()
            is Calculator.Calcu -> performCalculation()
        }
    }

    private fun enterOperation(operation: CalculatorOperation) {
        if(state.number1.isNotBlank()) {
            state = state.copy(operation = operation)
        }
    }

    private fun performCalculation() {
        val n1 = state.number1.toDoubleOrNull()
        val n2 = state.number2.toDoubleOrNull()
        if(n1 != null && n2 != null) {
            val result = when(state.operation) {
                is CalculatorOperation.Add -> n1 + n2
                is CalculatorOperation.Subtract -> n1 - n2
                is CalculatorOperation.Multiply -> n1 * n2
                is CalculatorOperation.Divide -> n1 / n2
                null -> return
            }
            state = state.copy(
                number1 = result.toString().take(15),
                number2 = "",
                operation = null
            )
        }
    }

    private fun delete() {
        when {
            state.number2.isNotBlank() -> state = state.copy(
                number2 = state.number2.dropLast(1)
            )
            state.operation != null -> state = state.copy(
                operation = null
            )
            state.number1.isNotBlank() -> state = state.copy(
                number1 = state.number1.dropLast(1)
            )
        }
    }

    private fun enterDecimal() {
        if(state.operation == null && !state.number1.contains(".") && state.number1.isNotBlank()) {
            state = state.copy(
                number1 = state.number1 + "."
            )
            return
        } else if(!state.number2.contains(".") && state.number2.isNotBlank()) {
            state = state.copy(
                number2 = state.number2 + "."
            )
        }
    }

    private fun enterNumber(number: Int) {
        if(state.operation == null) {
            if(state.number1.length >= MAX_NUM_LENGTH) {
                return
            }
            state = state.copy(
                number1 = state.number1 + number
            )
            return
        }
        if(state.number2.length >= MAX_NUM_LENGTH) {
            return
        }
        state = state.copy(
            number2 = state.number2 + number
        )
    }

    companion object {
        private const val MAX_NUM_LENGTH = 8
    }
}