package com.example.simpletravelapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.example.simpletravelapp.screens.HomeScreen
import com.example.simpletravelapp.screens.LoginScreen
import com.example.simpletravelapp.screens.SplashScreen
import com.example.simpletravelapp.ui.theme.SimpleTravelAppTheme
import kotlinx.serialization.Serializable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SimpleTravelAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,

                ) {
                    // Declared NavigationController
                    val navController = rememberNavController()

                    // Declared NavHost
                    NavHost(navController = navController, startDestination = SplashScreen) {
                        // Composable for SplashScreen
                        composable<SplashScreen> {
                            SplashScreen(navigateScreen = {
                                navController.navigate(LoginScreen)
                            })
                        }

                        // Composable for LoginScreen
                        composable<LoginScreen> {
                            LoginScreen(
                                navigateToHome = {
                                    navController.navigate(HomeScreen,
                                        // Pops all other routes that does not match
                                        // with the specified route, i.e, HomeScreen.
                                        navOptions = navOptions {
                                            popUpTo<HomeScreen>()
                                        })
                                }
                            )
                        }

                        // Composable for HomeScreen
                        composable<HomeScreen> {
                            HomeScreen()
                        }

                    }
                }
            }
        }
    }
}

// Serializable Routes
@Serializable
object SplashScreen

@Serializable
object LoginScreen

@Serializable
object HomeScreen

// My Custom Font
val RobotoFont = FontFamily(
    Font(R.font.roboto_mediumitalic, FontWeight.Medium, style = FontStyle.Italic),
    Font(R.font.roboto_semibold, FontWeight.SemiBold, style = FontStyle.Normal),
    Font(R.font.roboto_medium, FontWeight.Medium, style = FontStyle.Normal),
    Font(R.font.roboto_semibolditalic, FontWeight.SemiBold, style = FontStyle.Italic),
    Font(R.font.roboto_bolditalic, FontWeight.Bold, style = FontStyle.Italic),
    Font(R.font.roboto_light, FontWeight.Light, style = FontStyle.Normal),
    Font(R.font.roboto_thinitalic, FontWeight.Thin, style = FontStyle.Italic),
    Font(R.font.roboto_lightitalic, FontWeight.Light, style = FontStyle.Italic),
    Font(R.font.roboto_extralight, FontWeight.ExtraLight, style = FontStyle.Normal),
    Font(R.font.roboto_bold, FontWeight.Bold, style = FontStyle.Normal),
    Font(R.font.roboto_blackitalic, FontWeight.Normal, style = FontStyle.Italic),
    Font(R.font.roboto_thin, FontWeight.Thin, style = FontStyle.Normal),
    Font(R.font.roboto_extrabold, FontWeight.ExtraBold, style = FontStyle.Normal),
    Font(R.font.roboto_extrabolditalic, FontWeight.ExtraBold, style = FontStyle.Italic),
    Font(R.font.roboto_black, FontWeight.Normal, style = FontStyle.Normal),
    Font(R.font.roboto_regular, FontWeight.Normal, style = FontStyle.Normal),
    Font(R.font.roboto_italic, FontWeight.Normal, style = FontStyle.Italic),
    Font(R.font.roboto_extralightitalic, FontWeight.ExtraLight, style = FontStyle.Italic),
)


