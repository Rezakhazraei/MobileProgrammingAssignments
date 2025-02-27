package com.example.bmi_viewmodel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bmi_viewmodel.ui.theme.BMIViewModelTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BMIViewModelTheme {
                BodyMassCalculator()
            }
        }
    }
}

@Composable
fun BodyMassCalculator(modifier: Modifier = Modifier,  bmiViewModel: BmiViewModel = viewModel() ) {

    Column(
        modifier = modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "Body Mass Index",
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            modifier = modifier.fillMaxWidth().padding(vertical = 16.dp),
        )
        TextField(
            value = bmiViewModel.heightInput,
            onValueChange = { bmiViewModel.onHeightInputChange(it)},
            label = { Text(text = stringResource(R.string.Height)) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth().padding(start = 8.dp, end = 8.dp)

        )
        TextField(
            value = bmiViewModel.weightInput,
            onValueChange = { bmiViewModel.onWeightInputChange(it)},
            label = { Text(text = stringResource(R.string.Weight)) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth().padding(start = 8.dp, end = 8.dp)

        )

        Text(
            text = stringResource(R.string.BMI, bmiViewModel.bmivalue ),

            )
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BMIViewModelTheme {
        BodyMassCalculator()
    }
}