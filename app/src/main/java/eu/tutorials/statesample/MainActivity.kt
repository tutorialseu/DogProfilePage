package eu.tutorials.statesample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import eu.tutorials.statesample.ui.theme.StateSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StateSampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
//Todo 1: Create a new compose Activity and change the content of Greeting method
fun Greeting() {
    //Todo 8: create a variable to be stored in memory with remember
    var nameState by remember{
        mutableStateOf("")
    }
    //Todo 11: create a remember variable to hold data for when button is clicked
//Todo 14:change to remember saveable so the data can survive configuration changes
    var name by rememberSaveable{
        mutableStateOf("")
    }
    //Todo 2: Add a column composable to arrange the composables vertically
    //Todo 3: Add horizontal alignment to center the elements horizontally
    //Todo 4: Add modifier and set to fill max width
    //Todo 5: Add vertical arrangement to center element vertically
    //Todo 6: change fill max width to fill max size to cover for height and width
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center){
        //Todo 10: set nameState to Text element
        //Todo 13: set name to Text element
        Text(text = "Hello $name" )
        //Todo 7:Add spacer with height for spaces between elements
        Spacer(modifier = Modifier.height(20.dp))
        //Todo 9: pass in collect changed value with namestate
        TextField(value =nameState, onValueChange = {
            nameState = it
        } )
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
            //Todo 12: reassign the value from TextField to it when the button is clicked
            name = nameState
        }) {
            Text(text = "Display")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    StateSampleTheme {
        Greeting()
    }
}