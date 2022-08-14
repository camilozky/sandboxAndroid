package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
                    val dog = Dog()
                    val cat = Cat()
                    val myAnimals: MutableList<String> = mutableListOf()
                    val myAnimalsObject: MutableList<Animal> = mutableListOf()
                    myAnimals.add(dog.makeSound())
                    myAnimals.add(cat.makeSound())
                    myAnimalsObject.add(cat)
                    myAnimalsObject.add(dog)
                    LazyColumn {
                        items(myAnimals) {
                            Row(
                                Modifier.padding(8.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(text = it, fontSize = 12.sp)
                            }
                        }
                        item {
                            Button(
                                modifier = Modifier.padding(8.dp),
                                onClick = { /*TODO*/ }) {
                                Text(text = "Send message")
                            }
                        }
                    }
                }
            }
        }
    }
}
