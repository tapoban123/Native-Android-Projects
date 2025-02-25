package com.example.simpletravelapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.example.simpletravelapp.screens.SplashScreen
import com.example.simpletravelapp.ui.theme.SimpleTravelAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SimpleTravelAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SplashScreen(navigateScreen =  {})
                }
            }
        }
    }
}


val RobotoFont = FontFamily(
    Font(R.font.roboto_mediumitalic, style = FontStyle.Italic),
    Font(R.font.roboto_semibold, FontWeight.Bold, style = FontStyle.Normal),
    Font(R.font.roboto_medium, style = FontStyle.Normal),
    Font(R.font.roboto_semibolditalic, FontWeight.Bold, style = FontStyle.Italic),
    Font(R.font.roboto_bolditalic, FontWeight.Bold, style = FontStyle.Italic),
    Font(R.font.roboto_light, style = FontStyle.Normal),
    Font(R.font.roboto_thinitalic, FontWeight.Thin, style = FontStyle.Italic),
    Font(R.font.roboto_lightitalic, style = FontStyle.Italic),
    Font(R.font.roboto_extralight, FontWeight.ExtraLight, style = FontStyle.Normal),
    Font(R.font.roboto_bold, FontWeight.Bold, style = FontStyle.Normal),
    Font(R.font.roboto_blackitalic, style = FontStyle.Italic),
    Font(R.font.roboto_thin, FontWeight.Thin, style = FontStyle.Normal),
    Font(R.font.roboto_extrabold, FontWeight.ExtraBold, style = FontStyle.Normal),
    Font(R.font.roboto_extrabolditalic, FontWeight.ExtraBold, style = FontStyle.Italic),
    Font(R.font.roboto_black, style = FontStyle.Normal),
    Font(R.font.roboto_regular, style = FontStyle.Normal),
    Font(R.font.roboto_italic, style = FontStyle.Italic),
    Font(R.font.roboto_extralightitalic, FontWeight.ExtraLight, style = FontStyle.Italic),
)


