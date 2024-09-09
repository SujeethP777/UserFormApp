package com.ekacare.userformapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ekacare.data.database.UserDatabase
import com.ekacare.data.repository.UserRepository
import com.ekacare.domain.usecase.AddUserUseCase
import com.ekacare.presentation.UserForm
import com.ekacare.presentation.UserViewModel
import com.ekacare.presentation.UserViewModelFactory
import com.ekacare.userformapp.ui.theme.UserFormAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val database = UserDatabase.getDatabase(applicationContext)
        val repository = UserRepository(database.userDao())
        val addUserUseCase = AddUserUseCase(repository)
        val viewModelFactory = UserViewModelFactory(addUserUseCase)

        setContent {
            UserFormAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val userViewModel: UserViewModel = viewModel(factory = viewModelFactory)
                    UserForm(userViewModel)
                }
            }
        }
    }
}