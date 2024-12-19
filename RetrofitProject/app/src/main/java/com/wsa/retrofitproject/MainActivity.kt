package com.wsa.retrofitproject

    import android.app.Application
    import android.os.Bundle
    import androidx.activity.ComponentActivity
    import androidx.activity.compose.setContent
    import androidx.activity.enableEdgeToEdge
    import androidx.activity.viewModels
    import androidx.compose.foundation.layout.Column
    import androidx.compose.foundation.layout.padding
    import androidx.compose.material3.Text
    import androidx.compose.runtime.Composable
    import androidx.compose.ui.unit.dp
    import com.wsa.retrofitproject.ui.theme.RetrofitProjectTheme

class MainActivity : ComponentActivity() {
    // Use ViewModel to manage data
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            RetrofitProjectTheme {
                UserDetailScreen(mainViewModel)
            }
        }
    }
}

@Composable
fun UserDetailScreen(viewModel: MainViewModel) {

    val userdetails = viewModel.userDetailsLiveData.collectAsState(initial = null()).value

    Column(modifier = androidx.compose.ui.Modifier.padding(16.dp)) {
        if (userdetails != null) {
            // Show user details here
            userdetails.forEach { user ->
                Text(text = "ID: ${user.id}")
                Text(text = "Name: ${user.name}")
                Text(text = "Username: ${user.username}")
                Text(text = "Email: ${user.email}")
                // You can add more user details here
                Text(text = "-------------------------")
            }
        } else {
            // Show loading or error message
            Text(text = "Loading...")
        }
    }
}

@Composable
fun DefaultPreview() {
    RetrofitProjectTheme {
        UserDetailScreen(viewModel = MainViewModel(Application()))
    }
}