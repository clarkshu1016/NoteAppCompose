package com.usfuchsia.noteappcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.usfuchsia.noteappcompose.ui.theme.NoteAppComposeTheme
import com.usfuchsia.noteappcompose.ui.theme.Purple500
import com.usfuchsia.noteappcompose.ui.theme.Purple700

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoteAppComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    Scaffold(topBar = {
                        TopAppBar(
                            elevation = 4.dp,
                            content = { Text(text = "Offline Note App") },
                            contentColor = Color.White,
                            contentPadding = PaddingValues(8.dp, 0.dp, 8.dp, 0.dp),
                            backgroundColor = Purple700
                        )
                    },floatingActionButtonPosition=FabPosition.End,floatingActionButton = {
                        FloatingActionButton(
                            onClick = { /*TODO*/ },

                        ) {}
                    }) {

                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NoteAppComposeTheme {
        Greeting("Android")
    }
}