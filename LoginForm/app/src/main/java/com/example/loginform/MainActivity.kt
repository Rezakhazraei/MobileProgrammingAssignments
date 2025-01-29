package com.example.loginform

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginform.ui.theme.LoginFormTheme
import com.example.loginform.ui.theme.composable.OutlineTextFieldWithIcon

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginFormTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LoginForm (
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun LoginForm(modifier: Modifier = Modifier) {
    val username = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    Column (modifier = Modifier.fillMaxWidth().padding(16.dp)) {
        Text(
            text = "Login",
            modifier = Modifier.fillMaxWidth(),
            style = TextStyle(
                color = Color.Blue,
                fontSize = 24.sp,
                textAlign = TextAlign.Center
            )
        )
        OutlineTextFieldWithIcon(
            "Username",
            Icons.Filled.Person,
            "Username",
            value = username,
            onValueChange = { username.value = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )
        OutlineTextFieldWithIcon(
            "Password",
            Icons.Filled.Lock,
            "Password",
            value = password,
            onValueChange = { password.value = it },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp)
        ) { Text("Submit") }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LoginFormTheme {
        LoginForm()
    }
}