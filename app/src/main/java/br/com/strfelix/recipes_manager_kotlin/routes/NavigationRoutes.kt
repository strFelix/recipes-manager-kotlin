package br.com.strfelix.recipes_manager_kotlin.routes


import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import br.com.strfelix.recipes_manager_kotlin.screens.CategoryRecipeScreen
import br.com.strfelix.recipes_manager_kotlin.screens.HomeScreen
import br.com.strfelix.recipes_manager_kotlin.screens.InitialScreen
import br.com.strfelix.recipes_manager_kotlin.screens.LoginScreen
import br.com.strfelix.recipes_manager_kotlin.screens.SignupScreen


@Composable
fun NavigationRoutes() {
    val navController = rememberNavController();
    NavHost(
        navController = navController,
        startDestination = Destination.InitialScreen.route
    ) {
        composable(Destination.InitialScreen.route){ InitialScreen(navController) }
        composable(
            route = Destination.HomeScreen.route,
            deepLinks = listOf(
                navDeepLink {
                    uriPattern = "https://recipesmanagerkotlin.strfelix.com.br/email/{email}"
                    action = Intent.ACTION_VIEW
                }
            ),
//            arguments = listOf(navArgument("email") { type = NavType.StringType })
        ){ backStackEntry ->
//            var email = backStackEntry.arguments?.getString("email")
            HomeScreen(navController)
        }
        composable(
            route = Destination.CategoryRecipeScreen.route,
            arguments = listOf(
                navArgument(name = "id") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->
            var categoryId = backStackEntry.arguments?.getInt("id")
            CategoryRecipeScreen(categoryId, navController)
        }
        composable(Destination.SignupScreen.route) { SignupScreen(navController) }
        composable(Destination.LoginScreen.route) { LoginScreen(navController) }
    }
}