package com.example.myapplication

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
        composable(route = Screen.MainScreen.route) {
//            MainScreen(navController = navController)
            HelloScreen(navController = navController)
        }
        composable(
            route = Screen.DetailScreen.route + "/{name}",
            arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType
                    defaultValue = "Milo"
                    nullable = true
                }
            )
        )
        {
            DetailScreen(it.arguments?.getString("name"))
        }
    }

}

class HelloViewModel : ViewModel() {
    private val _text = MutableLiveData("")
    val text: LiveData<String> = _text

    fun onValueChange(newName: String) {
        _text.value = newName
    }

}

@Composable
fun HelloScreen(
    helloViewModel: HelloViewModel = viewModel(),
    navController: NavController = rememberNavController(),
) {
    val text by helloViewModel.text.observeAsState("")
    MainScreen(
        navController = navController,
        text = text,
        onValueChange = { helloViewModel.onValueChange(it) })
}

@Composable
fun MainScreen(
    navController: NavController = rememberNavController(),
    text: String = "",
    onValueChange: (String) -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 50.dp),
        verticalArrangement = Arrangement.Center
    ) {
        if (text.isNotEmpty())
            Text(
                text = "Hello, $text!",
                modifier = Modifier.padding(bottom = 8.dp),
                style = MaterialTheme.typography.h5
            )
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = text,
            onValueChange = onValueChange,
            label = {
                Text("Name")
            })
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            modifier = Modifier.align(Alignment.End),
            onClick = {
                navController.navigate(Screen.DetailScreen.withArgs(text))
            }) {
            Text(text = "to DetailScreen")
        }
    }
}

@Composable
fun DetailScreen(name: String?) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    )
    {
        Text(text = "Hello, $name")
    }
}
//
//@Composable
//fun HelLoContent() {
//    Column(modifier = Modifier.padding(16.dp)) {
//        var name by remember { mutableStateOf("") }
//        Text(
//            text = "Hello, $name",
//            modifier = Modifier.padding(bottom = 8.dp),
//            style = MaterialTheme.typography.h5
//        )
//        OutlinedTextField(
//            value = name,
//            onValueChange = { name = it },
//            label = {
//                Text("Name")
//            })
//    }
//}

