package com.example.simpletravelapp.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simpletravelapp.R
import com.example.simpletravelapp.RobotoFont
import com.example.simpletravelapp.ui.theme.BrownColor

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    navigateScreen: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Box(
            modifier = modifier.fillMaxSize()

        ) {
            BackgroundImage(modifier = modifier)
            PageContent(
                modifier = Modifier.align(Alignment.BottomStart),
                navigateScreen,
            )

        }
    }
}

@Composable
fun BackgroundImage(modifier: Modifier) {
    val image = painterResource(R.drawable.travel_photo)
    Image(
        painter = image,
        modifier = modifier.fillMaxSize(),
        contentDescription = null,
        contentScale = ContentScale.Crop,
    )
}

@Composable
fun PageContent(
    modifier: Modifier = Modifier,
    navigateScreen: () -> Unit
) {
    Column(
        modifier = modifier
            .padding(bottom = 100.dp, start = 30.dp)
            .width(250.dp),
        horizontalAlignment = Alignment.Start,
    ) {
        Row {
            Text(
                text = "TENDA",
                color = Color.White,
                fontSize = 20.sp,
                modifier = Modifier.padding(paddingValues = PaddingValues(end = 5.dp)),
                fontFamily = RobotoFont,
            )
            Image(
                painter = painterResource(id = R.drawable.tent),
                contentDescription = null,
                modifier = Modifier.size(24.dp),
                contentScale = ContentScale.Crop,
            )

        }
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = "Find Perfect Place for your Camping",
            fontWeight = FontWeight.Medium,
            fontSize = 30.sp,
            textAlign = TextAlign.Start,
            color = Color.White,
            fontFamily = RobotoFont,
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = "The Best App for Campers or Hiking",
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            color = Color.White,
            fontFamily = RobotoFont,
        )
        Spacer(modifier = Modifier.height(16.dp))
        ElevatedButton(
            onClick = navigateScreen,
            colors = ButtonDefaults.buttonColors(
                containerColor = BrownColor
            ),
            contentPadding = PaddingValues(horizontal = 10.dp),
            modifier = Modifier.size(width = 207.dp, height = 54.dp),
            shape = RoundedCornerShape(15.dp)
        ) {
            Row(modifier = modifier.fillMaxWidth()) {
                Text(
                    text = "Browse Mountain",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontFamily = RobotoFont,
                )
                Icon(
                    Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = null,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenPreview() {
    SplashScreen(navigateScreen = {})
}
