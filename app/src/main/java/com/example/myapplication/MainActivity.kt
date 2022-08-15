package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column() {
                        Navigation()
//                        HelLoContent()
                    }
//                    val dog = Dog()
//                    val cat = Cat()
//                    val myAnimals: MutableList<String> = mutableListOf()
//                    val myAnimalsObject: MutableList<Animal> = mutableListOf()
//                    myAnimals.add(dog.makeSound())
//                    myAnimals.add(cat.makeSound())
//                    myAnimalsObject.add(cat)
//                    myAnimalsObject.add(dog)
//                    LazyColumn {
//                        items(myAnimals) {
//                            Row(
//                                Modifier.padding(8.dp),
//                                verticalAlignment = Alignment.CenterVertically
//                            ) {
//                                Text(text = it, fontSize = 12.sp)
//                            }
//                        }
//                        item {
//                            Button(
//                                modifier = Modifier.padding(8.dp),
//                                onClick = {  }) {
//                                Text(text = "Send message")
//                            }
//                        }
//                    }
                }
            }
        }
    }
}
