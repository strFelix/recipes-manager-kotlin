package br.com.strfelix.recipes_manager_kotlin.screens

import android.content.res.Configuration
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.strfelix.recipes_manager_kotlin.R
import br.com.strfelix.recipes_manager_kotlin.ui.theme.RecipesmanagerkotlinTheme

@Composable
fun InitialScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
    ) {
        Card(
            modifier = Modifier
                .size(width = 160.dp, height = 85.dp)
                .align(Alignment.TopEnd),
            colors = CardDefaults
                .cardColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
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
                    text = stringResource(R.string.unlimited_recipes),
                    color = MaterialTheme.colorScheme.secondary,
                    style = MaterialTheme.typography.titleSmall
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = stringResource(R.string.start_cooking),

                    style = MaterialTheme.typography.displayLarge,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row {
                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme
                                .colorScheme.primary
                        ),
                        border = BorderStroke(
                            width = 1.dp,
                            color = MaterialTheme
                                .colorScheme.tertiary
                        ),
                        modifier = Modifier
                            .size(128.dp, 48.dp)
                    ) {
                        Text(
                            text = stringResource(R.string.button_login),
                            color = MaterialTheme.colorScheme.onPrimary,
                            style = MaterialTheme.typography.labelMedium,
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme
                                .colorScheme.tertiary
                        ),
                        border = BorderStroke(
                            width = 1.dp,
                            color = MaterialTheme.colorScheme.primary
                        ),
                        modifier = Modifier
                            .size(width = 128.dp, height = 48.dp)
                    ) {
                        Text(
                            text = stringResource(R.string.button_signup),
                            color = MaterialTheme.colorScheme.onTertiary,
                            style = MaterialTheme.typography.labelMedium,
                        )
                    }
                }
            }
        }
        Card(
            modifier = Modifier
                .size(width = 160.dp, height = 85.dp)
                .align(Alignment.BottomStart),
            colors = CardDefaults
                .cardColors(containerColor = MaterialTheme
                    .colorScheme.primary),
            shape = RoundedCornerShape(topEnd = 85.dp)
        ) { }
    }
}

@Composable
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO, locale = "en")
fun InitialScreenPreview(){
    RecipesmanagerkotlinTheme() {
        InitialScreen()
    }
}