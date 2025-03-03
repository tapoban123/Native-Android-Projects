package com.example.simpletravelapp.models

data class MountainDataModel(
    val imageId: Int,
    val place: String,
    val country: String,
    val difficulty: String,
)

data class ClimbingToolDataModel(
    val imgId: Int,
    val toolName: String,
)