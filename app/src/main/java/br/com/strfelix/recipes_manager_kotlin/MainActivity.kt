package br.com.strfelix.recipes_manager_kotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import br.com.strfelix.recipes_manager_kotlin.screens.InitialScreen
import br.com.strfelix.recipes_manager_kotlin.screens.SignupScreen
import br.com.strfelix.recipes_manager_kotlin.ui.theme.RecipesmanagerkotlinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            RecipesmanagerkotlinTheme {
                SignupScreen()
            }
        }
    }
}


