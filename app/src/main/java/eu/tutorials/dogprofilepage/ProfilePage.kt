package eu.tutorials.dogprofilepage

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview

 //Todo 1: Create a file called ProfilePage.kt and create a compose function called ProfilePage
@Composable
fun ProfilePage() {
    //Todo 2: Add a Column element
Column {
    //Todo 3: Add an image drawable and then use an Image element to show it on the screen
    Image(painter =painterResource(id = R.drawable.husky),
        contentDescription = "husky")
    //Todo 5: Add 2 Text element to display name and country
    Text(text = "Siberian Husky")
    Text(text = "Germany")
}
}

//Todo 4: Add a preview function
@Preview(showBackground = true)
@Composable
fun ProfilePagePreview() {
    ProfilePage()
}