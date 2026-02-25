package br.com.strfelix.recipes_manager_kotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image

import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.strfelix.recipes_manager_kotlin.ui.theme.RecipesmanagerkotlinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RecipesmanagerkotlinTheme {
            }
        }
    }
}

@Composable
fun InitialScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Card(
            modifier = Modifier
                .size(width = 160.dp, height = 85.dp)
                .align(Alignment.TopEnd),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFED1459)),
            shape = RoundedCornerShape(bottomStart = 85.dp)
        ) { }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 48.dp, vertical = 16.dp)
                .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.image),
                contentDescription = "Image of someone cooking",
                modifier = Modifier.size(190.dp)
            )
            Spacer(modifier = Modifier.height(100.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {

                Text(
                    text = "UNLIMITED PREMIUM RECIPES",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF868080),
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Start Cooking",
                    fontSize = 64.sp,
                    lineHeight = 64.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFED1459),
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row(){
                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFED1459)),
                        border = BorderStroke(
                            width = 1.dp,
                            color = Color(0xFFFFC107)
                        ),
                        modifier = Modifier.size(width = 128.dp, height = 48.dp)
                    ) {
                        Text(
                            text = "Login",
                            fontSize = 16.sp,
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFC107)),
                        border = BorderStroke(
                            width = 1.dp,
                            color = Color(0xFFED1459)
                        ),
                        modifier = Modifier.size(width = 128.dp, height = 48.dp)
                    ) {
                        Text(
                            text = "Sign Up",
                            fontSize = 16.sp,
                            color = Color(0xFFED1459),
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
        Card(
            modifier = Modifier
                .size(width = 160.dp, height = 85.dp)
                .align(Alignment.BottomStart),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFED1459)),
            shape = RoundedCornerShape(topEnd = 85.dp)
        ) { }
    }
}

@Composable
@Preview(showBackground = true)
fun InitialScreenPreview(){
    RecipesmanagerkotlinTheme() {
        InitialScreen()
    }
}
