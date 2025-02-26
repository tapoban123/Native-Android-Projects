package com.example.simpletravelapp.screens

import android.graphics.Paint.Align
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simpletravelapp.R
import com.example.simpletravelapp.RobotoFont
import com.example.simpletravelapp.data.mountainsData
import com.example.simpletravelapp.models.MountainDataModel
import com.example.simpletravelapp.ui.theme.BackgroundColor

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = BackgroundColor)
            .padding(horizontal = 30.dp)
            .padding(top = 30.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth(),
        ) {
            Column {
                Text(
                    text = "Good Morning",
                    fontSize = 25.sp,
                    fontFamily = RobotoFont,
                    fontWeight = FontWeight.Light,
                )
                Text(
                    text = "Pales",
                    fontSize = 25.sp,
                    fontFamily = RobotoFont,
                    fontWeight = FontWeight.Medium
                )
            }
            AvatarImage()
        }
        Spacer(modifier = Modifier.height(20.dp))
        SearchTextField()
        Spacer(modifier = Modifier.height(24.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = "Popular Mountain",
                fontSize = 20.sp,
                fontWeight = FontWeight.Light,
                fontFamily = RobotoFont,
            )
            Text(
                text = "See More",
                fontSize = 15.sp,
                fontWeight = FontWeight.Light,
                fontFamily = RobotoFont,
                color = Color.Black.copy(alpha = 0.4F)
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        PopularMountainsRow()
        Spacer(modifier = Modifier.height(20.dp))
        DiscoverCard()
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = "Buy Tools For Climbing/Hiking",
                fontSize = 20.sp,
                fontWeight = FontWeight.Light,
                fontFamily = RobotoFont,
            )
            Icon(
                Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = null,
            )
        }

    }

}

@Composable
fun AvatarImage() {
    val image = painterResource(R.drawable.man)
    Image(
        image,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .clip(CircleShape)
            .size(40.dp)
            .background(
                color = Color.Gray.copy(
                    alpha = 0.5F,
                )
            )
    )
}

@Composable
fun SearchTextField() {
    val searchValue = remember { mutableStateOf("") }

    Row(verticalAlignment = Alignment.CenterVertically) {
        OutlinedTextField(
            onValueChange = {
                searchValue.value = it
            },
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = Color.Black.copy(alpha = 0.03F),
                unfocusedBorderColor = Color.Black.copy(alpha = 0.03F),
            ),
            shape = RoundedCornerShape(50.dp),
            value = searchValue.value,
            label = {
                Text(
                    text = "Search Mountain/Place",
                    color = Color.Black.copy(alpha = 0.35F),
                )
            }
        )
        Spacer(modifier = Modifier.width(14.dp))
        CustomImage(
            imageId = R.drawable.search_logo,
        )
    }

}

@Composable
fun CustomImage(
    imageId: Int,
    contentScale: ContentScale? = null,
    width: Dp? = null,
    height: Dp? = null,
) {
    val image = painterResource(imageId)
    Image(
        painter = image,
        contentDescription = null,
        contentScale = contentScale ?: ContentScale.Crop,
        modifier = Modifier.size(
            width = width ?: 24.dp,
            height = height ?: 24.dp,
        ),
    )
}

@Composable
fun PopularMountainsRow() {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        itemsIndexed(
            items = mountainsData,
            itemContent = { index: Int,
                            item: MountainDataModel ->
                Card(modifier = Modifier.padding(end = 10.dp)) {
                    Box {
                        CustomImage(
                            item.imageId,
                            contentScale = ContentScale.FillBounds,
                            width = 123.dp,
                            height = 155.dp
                        )
                        Column(
                            modifier = Modifier
                                .align(Alignment.BottomStart)
                                .padding(start = 10.dp, bottom = 10.dp),
                            verticalArrangement = Arrangement.Top,
                        ) {
                            val difficultyText: String = item.difficulty

                            val difficultyColor: Color = when (difficultyText) {
                                ("Hard") -> Color.Red
                                ("Medium") -> Color.Yellow
                                else -> Color.Blue
                            }

                            Text(
                                text = item.place,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Normal,
                                fontFamily = RobotoFont,
                                color = Color.White,
                            )
                            Text(
                                text = item.country,
                                fontSize = 10.sp,
                                fontFamily = RobotoFont,
                                color = Color.White.copy(alpha = 0.66F),
                            )
                            Row {
                                Text(
                                    text = "Difficulty ",
                                    fontSize = 9.sp,
                                    color = Color.White,
                                    fontWeight = FontWeight.SemiBold,
                                    fontFamily = RobotoFont,
                                )
                                Text(
                                    text = difficultyText,
                                    color = difficultyColor,
                                    fontSize = 9.sp,
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = RobotoFont,
                                )
                            }
                        }
                    }
                }
            }
        )
    }
}

@Composable
fun DiscoverCard() {
    Card {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(117.dp),

            ) {
            Image(
                painter = painterResource(R.drawable.galaxy),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillBounds,
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(all = 20.dp)
            ) {
                Text(
                    text = "Best Places to see\nGalaxy",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium,
                    fontFamily = RobotoFont,
                )
                ElevatedButton(
                    onClick = {},
                    shape = RoundedCornerShape(9.dp),
                    modifier = Modifier.align(Alignment.BottomEnd)
                ) {
                    Text(
                        text = "Discover",
                        color = Color.Black,
                        fontSize = 15.sp,
                        fontFamily = RobotoFont,
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    HomeScreen()
}