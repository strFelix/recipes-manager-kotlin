package br.com.strfelix.recipes_manager_kotlin.screens

import android.content.res.Configuration
import android.util.Patterns
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Error
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.RemoveRedEye
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.com.strfelix.recipes_manager_kotlin.R
import br.com.strfelix.recipes_manager_kotlin.model.User
import br.com.strfelix.recipes_manager_kotlin.repository.SharedPreferencesUserRepository
import br.com.strfelix.recipes_manager_kotlin.repository.UserRepository
import br.com.strfelix.recipes_manager_kotlin.routes.Destination
import br.com.strfelix.recipes_manager_kotlin.ui.theme.RecipesmanagerkotlinTheme


@Composable
fun SignupScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize().background(MaterialTheme.colorScheme.background)
    ){
        TopEndCard(modifier = Modifier.align(Alignment.TopEnd))
        BottomStartCard(modifier = Modifier.align(Alignment.BottomStart))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TitleComponent()
            Spacer(modifier = Modifier.height(48.dp))
            UserImage()
            SignupUserForm(navController)
        }

    }
}

@Composable
fun TitleComponent() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.sign_up),
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.titleLarge
        )
        Text(
            text = stringResource(R.string.create_account),
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.titleSmall
        )
    }
}

@Composable
fun UserImage(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .size(120.dp)
    ){
        Image(
            painter = painterResource(R.drawable.user),
            contentDescription = "",
            modifier = Modifier
                .size(110.dp)
                .align(Alignment.Center)
        )
        Icon(
            imageVector = Icons.Default.Edit,
            tint = MaterialTheme.colorScheme.primary,
            contentDescription = "",
            modifier = Modifier
                .align(Alignment.BottomEnd)
        )
    }
}

@Composable
fun SignupUserForm(navController: NavController) {

    var nameState = remember { mutableStateOf("") }
    var emailState = remember { mutableStateOf("") }
    var passwordState = remember { mutableStateOf("") }

    var isNameError = remember { mutableStateOf(false) }
    var isEmailError = remember { mutableStateOf(false) }
    var isPasswordError = remember { mutableStateOf(false) }

    var showDialogError = remember { mutableStateOf(false) }
    var showDialogSuccess = remember { mutableStateOf(false) }

    fun validate(): Boolean {
        isNameError.value = nameState.value.length < 3
        isEmailError.value = emailState.value.length < 3 || !Patterns.EMAIL_ADDRESS.matcher(emailState.value).matches()
        isPasswordError.value = passwordState.value.length < 3
        return !isNameError.value && !isEmailError.value && !isPasswordError.value
    }

    val userRepository: UserRepository =
        SharedPreferencesUserRepository(LocalContext.current)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(32.dp)
    ) {
        OutlinedTextField(
            value = nameState.value,
            onValueChange = {
                name -> nameState.value = name
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 4.dp),
            shape = RoundedCornerShape(16.dp),
            colors = OutlinedTextFieldDefaults
                .colors(
                    focusedBorderColor = MaterialTheme.colorScheme.primary,
                    unfocusedBorderColor = MaterialTheme.colorScheme.primary
                ),
            label = {
                Text(
                    text = stringResource(R.string.your_name),
                    style = MaterialTheme.typography.labelSmall
                )
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "",
                    tint = MaterialTheme.colorScheme.tertiary
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                capitalization = KeyboardCapitalization.Words,
                imeAction = ImeAction.Next
            ),
            isError = isNameError.value,
            trailingIcon = {
                if (isNameError.value){
                    Icon(imageVector = Icons.Default.Error, contentDescription = null)
                }
            },
            supportingText = {
                if (isNameError.value){
                    Text(
                        text = stringResource(R.string.username_is_required),
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.End,
                        color = MaterialTheme.colorScheme.error
                    )
                }
            }
        )
        OutlinedTextField(
            value = emailState.value,
            onValueChange = {
                email -> emailState.value = email
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 4.dp),
            shape = RoundedCornerShape(16.dp),
            colors = OutlinedTextFieldDefaults
                .colors(
                    focusedBorderColor = MaterialTheme.colorScheme.primary,
                    unfocusedBorderColor = MaterialTheme.colorScheme.primary
                ),
            label = {
                Text(
                    text = stringResource(R.string.your_e_mail),
                    style = MaterialTheme.typography.labelSmall
                )
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "",
                    tint = MaterialTheme.colorScheme.tertiary
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            isError = isEmailError.value,
            trailingIcon = {
                if (isEmailError.value){
                    Icon(imageVector = Icons.Default.Error, contentDescription = null)
                }
            },
            supportingText = {
                if (isEmailError.value){
                    Text(
                        text = stringResource(R.string.email_is_required),
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.End,
                        color = MaterialTheme.colorScheme.error
                    )
                }
            }
        )
        OutlinedTextField(
            value = passwordState.value,
            onValueChange = {
                password -> passwordState.value = password
            },
            modifier = Modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = OutlinedTextFieldDefaults
                .colors(
                    focusedBorderColor = MaterialTheme.colorScheme.primary,
                    unfocusedBorderColor = MaterialTheme.colorScheme.primary
                ),
            label = {
                Text(
                    text = stringResource(R.string.your_password),
                    style = MaterialTheme.typography.labelSmall
                )
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = "",
                    tint = MaterialTheme.colorScheme.tertiary
                )
            },
            isError = isEmailError.value,
            trailingIcon = {
                if(isPasswordError.value){
                    Icon(imageVector = Icons.Default.Error, contentDescription = "")
                } else {
                    Icon(
                        imageVector = Icons.Default.RemoveRedEye,
                        contentDescription = "",
                        tint = MaterialTheme.colorScheme.tertiary
                    )
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.NumberPassword,
                imeAction = ImeAction.Done
            ),
            supportingText = {
                if (isEmailError.value){
                    Text(
                        text = stringResource(R.string.password_is_required),
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.End,
                        color = MaterialTheme.colorScheme.error
                    )
                }
            }
        )
        Spacer(modifier = Modifier.height(32.dp))
        Button(
            onClick = {
                if(validate()){
                    userRepository
                        .saveUser(User(name = nameState.value, email = emailState.value, password = passwordState.value))
                    showDialogSuccess.value = true
                }
                else {
                    showDialogError.value = true
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                text = stringResource(R.string.create_account),
                style = MaterialTheme.typography.labelMedium
            )
        }
        if (showDialogSuccess.value){
            AlertDialog(
                onDismissRequest = { showDialogError.value = false },
                title = {
                    Text(text = "Sucess")
                },
                text = {
                    Text(text = "Account created sucessfully")
                },
                confirmButton = {
                    TextButton(onClick = {
                        showDialogSuccess.value = false
                        navController.navigate(Destination.LoginScreen.route) }
                    ) {
                        Text(text = "OK")
                    }
                }

            )
        }

        if (showDialogError.value){
            AlertDialog(
                onDismissRequest = { showDialogError.value = false },
                title = {
                    Text(text = "Error")
                },
                text = {
                    Text(text = "Please fill all fields correctly")
                },
                confirmButton = {
                    TextButton(onClick = { showDialogSuccess.value = false }) {
                        Text(text = "OK")
                    }
                }

            )
        }
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    locale = "en"
)
@Composable
private fun SignupUserFormPreview() {
    RecipesmanagerkotlinTheme {
        SignupUserForm(rememberNavController())
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    locale = "en"
)
@Composable
private fun UserImagePreview() {
    RecipesmanagerkotlinTheme {
        UserImage()
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    locale = "en"
)
@Preview
@Composable
private fun TitleComponentPreview() {
    RecipesmanagerkotlinTheme {
        TitleComponent()
    }

}
@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    locale = "en"
)
@Composable
private fun SignupScreenPreview() {
    RecipesmanagerkotlinTheme {
        SignupScreen(rememberNavController())
    }

}
