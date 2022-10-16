package com.example.myappcalsi

import android.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import com.example.myappcalsi.*
import androidx.compose.ui.Alignment

import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color.Companion.White
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myappcalsi.ui.theme.MyappCalsiTheme
import com.example.myappcalsi.Calculator as Calculator1

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyappCalsiTheme {
                val viewModel=viewModel<CalculatorViewModel>()
                val state=viewModel.state
                val buttonSpacing=8.dp
                Calculator1(state = state,buttonSpacing = buttonSpacing,onAction = viewModel::onAction)

            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyappCalsiTheme {
        val viewModel=viewModel<CalculatorViewModel>()
        val state=viewModel.state
        val buttonSpacing=8.dp
        Calculator1(state = state,buttonSpacing = buttonSpacing,onAction = viewModel::onAction)

    }
}
