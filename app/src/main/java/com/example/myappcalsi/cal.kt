package com.example.myappcalsi
import android.graphics.Color
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text


import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.sp

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color.Companion.White

@Composable
fun Calculator(
    state:CalculatorState,
    buttonSpacing: Dp =8.dp,
    onAction:(Calculator)->Unit
   // modifier:Modifier =Modifier
) {
    var num = " "
    Box(modifier = Modifier)
    {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(buttonSpacing)
        )
        {
            Text(
                text = state.number1 + (state.operation?.symbol ?: "") + state.number2,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 31.dp),
                fontSize = 80.sp
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {

                CalculatorButton(
                    symbol = "AC",
                    modifier = Modifier.background(LightGray)
                        .aspectRatio(2f)
                        .weight(2f),
                    onClick = {
                        onAction(Calculator.Clear)
                    }
                )
                CalculatorButton(
                    symbol = "Del",
                    modifier = Modifier.background(LightGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(Calculator.Delete)
                    }
                )
                CalculatorButton(
                    symbol = "/",
                    modifier = Modifier.background(LightGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(Calculator.Operation(CalculatorOperation.Divide))
                    }
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    symbol = "7",
                    modifier = Modifier.background(LightGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(Calculator.Number(7))
                        num += "7";
                    }
                )
                CalculatorButton(
                    symbol = "8",
                    modifier = Modifier.background(LightGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(Calculator.Number(8))
                        num += "8"
                    }
                )
                CalculatorButton(
                    symbol = "9",
                    modifier = Modifier.background(LightGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(Calculator.Number(9))
                    }
                )
                CalculatorButton(
                    symbol = "*",
                    modifier = Modifier.background(LightGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(Calculator.Operation(CalculatorOperation.Multiply))
                    }
                )
            }

            /****
             *
             */
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {


                CalculatorButton(
                    symbol = "4",
                    modifier = Modifier.background(LightGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(Calculator.Number(4))
                        num += "4";
                    }
                )
                CalculatorButton(
                    symbol = "5",
                    modifier = Modifier.background(LightGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(Calculator.Number(5))
                        num += "5";
                    }
                )
                CalculatorButton(
                    symbol = "6",
                    modifier = Modifier.background(LightGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(Calculator.Number(6))
                        num += "6";
                    }
                )

                CalculatorButton(
                    symbol = "-",
                    modifier = Modifier.background(LightGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(Calculator.Operation(CalculatorOperation.Subtract))
                        //onAction(Calculator.Number(-)

                    }
                )
            }
            /****
             *
             */
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {

                CalculatorButton(
                    symbol = "1",
                    modifier = Modifier.background(LightGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(Calculator.Number(1))
                        num += "1";
                    }
                )
                CalculatorButton(
                    symbol = "2",
                    modifier = Modifier.background(LightGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(Calculator.Number(2))
                        num += "2";
                    }
                )
                CalculatorButton(
                    symbol = "3",
                    modifier = Modifier.background(LightGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(Calculator.Number(3))
                        num += "3";
                    }
                )

                CalculatorButton(
                    symbol = "+",
                    modifier = Modifier.background(LightGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(Calculator.Operation(CalculatorOperation.Add))

                    }
                )
            }
//.............
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {

                CalculatorButton(
                    symbol = "0",
                    modifier = Modifier.background(LightGray)
                        .aspectRatio(2f)
                        .weight(2f),
                    onClick = {
                        onAction(Calculator.Number(0))
                        num += "0";
                    }
                )
                CalculatorButton(
                    symbol = ".",
                    modifier = Modifier.background(LightGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(Calculator.Decimal)
                    }
                )
                CalculatorButton(
                    symbol = "=",
                    modifier = Modifier.background(LightGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(Calculator.Calcu)
                    }
                )
            }

        }

    }

}

