package br.com.strfelix.recipes_manager_kotlin.repository

import android.content.Context
import br.com.strfelix.recipes_manager_kotlin.model.User

class SharedPreferencesUserRepository(context: Context) : UserRepository {

    private val userPrefs = context
        .getSharedPreferences(
            "userPreferences",
            Context.MODE_PRIVATE
        )

    override fun saveUser(user: User) {
        userPrefs.edit()
            .putString("name", user.name)
            .putString("email", user.email)
            .putString("password", user.password)
            .apply()
    }

    override fun getUser(): User {
        val namePrefs = userPrefs.getString("name", "")
        val emailPrefs = userPrefs.getString("email", "")
        val passwordPrefs = userPrefs.getString("password", "")
        return User(
            name = namePrefs!!,
            email = emailPrefs!!,
            password = passwordPrefs!!
        )
    }

    override fun login(
        email: String,
        password: String
    ): Boolean {
        val namePrefs = userPrefs.getString("name", "")
        val emailPrefs = userPrefs.getString("email", "")
        val passwordPrefs = userPrefs.getString("password", "")
        return email == emailPrefs && password == passwordPrefs
    }

    override fun getUserByEmail(email: String): User {
        TODO("Not yet implemented")
    }
}