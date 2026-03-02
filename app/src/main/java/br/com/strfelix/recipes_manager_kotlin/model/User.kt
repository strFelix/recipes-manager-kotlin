package br.com.strfelix.recipes_manager_kotlin.model

data class User(
    val id: Int = 0,
    val name: String = "",
    val email: String = "",
    val password: String = ""
)