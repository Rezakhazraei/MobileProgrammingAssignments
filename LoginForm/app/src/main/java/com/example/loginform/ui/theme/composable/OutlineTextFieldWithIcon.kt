package com.example.loginform.ui.theme.composable

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun OutlineTextFieldWithIcon(
    label: String,
    icon: ImageVector,
    contentDescription: String ?= null,
    value: MutableState<String>,
    onValueChange: (String) -> Unit,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default
) {
    OutlinedTextField(
        value = value.value,
        onValueChange = onValueChange,
        modifier = Modifier.padding(all = 8.dp).fillMaxWidth(),
        label = { Text(label) },
        trailingIcon = {
            Icon(icon, contentDescription = contentDescription)
        },
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions
    )
}