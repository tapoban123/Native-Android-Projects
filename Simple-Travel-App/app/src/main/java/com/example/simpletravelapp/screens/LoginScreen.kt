package com.example.simpletravelapp.screens

import android.graphics.Paint.Align
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simpletravelapp.RobotoFont
import com.example.simpletravelapp.ui.theme.BackgroundColor
import com.example.simpletravelapp.ui.theme.BrownColor
import com.example.simpletravelapp.ui.theme.GreyColor
import com.example.simpletravelapp.ui.theme.LightBrownColor
import com.example.simpletravelapp.ui.theme.MediumBrownColor

@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = BackgroundColor)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 30.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "Login",
                fontSize = 40.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = RobotoFont,
                color = MediumBrownColor,
                textAlign = TextAlign.Start,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(20.dp))
            AuthTextField(
                hintText = "Username or Email"
            )
            Spacer(modifier = Modifier.height(12.dp))
            AuthTextField(
                hintText = "Password"
            )
            Spacer(modifier = Modifier.height(18.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                TextButton(
                    onClick = {},
                    modifier = Modifier.weight(1F)
                ) {
                    Text(
                        text = "Register",
                        fontSize = 20.sp,
                        fontFamily = RobotoFont,
                        fontWeight = FontWeight.Medium,
                        color = LightBrownColor.copy(alpha = 0.7F),
                    )
                }
                Column(
                    horizontalAlignment = Alignment.End
                ) {
                    ElevatedButton(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(
                            containerColor = LightBrownColor,
                        ),
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier.size(width = 169.dp, height = 41.dp),
                    ) {
                        Text(
                            text = "Login",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Normal,
                            color = Color.White,
                        )
                    }

                    TextButton(
                        onClick = {},
                        contentPadding = PaddingValues(0.dp),
                    ) {
                        Text(
                            text = "Forgot Password or Email?",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Normal,
                            fontFamily = RobotoFont,
                            color = MediumBrownColor,
                            textAlign = TextAlign.End,
                        )
                    }

                }
            }
        }
        Text(
            text = "Privacy Policy - Terms of Use \n",
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            color = MediumBrownColor,
            modifier = modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 40.dp),
        )

    }

}

@Composable
fun AuthTextField(
    hintText: String,
) {
    var textFieldValue by remember { mutableStateOf("") }

    OutlinedTextField(
        onValueChange = {
            textFieldValue = it
        },
        textStyle = TextStyle(
            fontFamily = RobotoFont,
        ),
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedContainerColor = GreyColor,
            focusedContainerColor = GreyColor,
            unfocusedBorderColor = GreyColor,
            focusedBorderColor = GreyColor,
            unfocusedLabelColor = Color.Black.copy(alpha = 0.25F),
        ),
        shape = RoundedCornerShape(14.dp),
        modifier = Modifier.fillMaxWidth(),
        value = textFieldValue,
        label = {
            Text(
                text = hintText,
                fontFamily = RobotoFont,
            )
        },
    )
}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    LoginScreen()
}