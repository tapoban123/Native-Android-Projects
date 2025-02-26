package com.example.simpletravelapp.data

import com.example.simpletravelapp.R
import com.example.simpletravelapp.models.MountainDataModel

val mountainsData: List<MountainDataModel> = listOf(
    MountainDataModel(
        imageId = R.drawable.everest,
        place = "Everest",
        country = "Nepal",
        difficulty = "Hard"
    ),
    MountainDataModel(
        imageId = R.drawable.semeru,
        place = "Semeru",
        country = "Indonesia",
        difficulty = "Medium"
    ),
    MountainDataModel(
        imageId = R.drawable.fuji,
        place = "Fuji",
        country = "Japan",
        difficulty = "Medium"
    ),
)
