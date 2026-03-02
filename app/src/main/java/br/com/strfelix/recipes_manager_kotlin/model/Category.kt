package br.com.strfelix.recipes_manager_kotlin.model

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import br.com.strfelix.recipes_manager_kotlin.R

data class Category(
    val id: Int = 0,
    val name: String = "",
    @DrawableRes val image: Int? = R.drawable.no_photo,
    val background: Color = Color.Gray
)