package br.com.strfelix.recipes_manager_kotlin.repository

import br.com.strfelix.recipes_manager_kotlin.model.User

interface UserRepository {
    fun saveUser(user: User)
    fun getUser(): User
    fun getUserByEmail(email: String): User?
    fun login(email: String, password: String): Boolean
}