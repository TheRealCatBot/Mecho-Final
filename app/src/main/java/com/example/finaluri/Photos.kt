package com.example.finaluri

import androidx.annotation.DrawableRes

data class Photos (
    val id: Int,
    val title: String,
    val description:String,
    @DrawableRes
    val image:Int

)
