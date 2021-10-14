package eu.tutorials.dogprofilepage

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ProfilePage() {
    //Todo 2 : add a horizontal alignment with modifier to fill max size
Column(horizontalAlignment = Alignment.CenterHorizontally,
modifier = Modifier.fillMaxSize()) {
    /**
     *   Todo 1 Add a modifier to the Image element with a size,clip, border.
     *   Also add a contentScale to crop the image
     */
  Image(painter =painterResource(id = R.drawable.husky),
        contentDescription = "husky", modifier = Modifier
          .size(100.dp)
          .clip(CircleShape)
          .border(width = 2.dp, color = Color.Red, shape = CircleShape),
          contentScale = ContentScale.Crop)
   Text(text = "Siberian Husky")
    Text(text = "Germany")
    /**
     * Todo 4 add a Row Element with three Column containing 2 Text each,
     * Todo 7: then we extract one column
     * to create a reusable function ProfileStats, next we add horizontal arrangement  and modifier to fill maxWidth
     * since we are focused on the horizontal axiz
     */

    Row(horizontalArrangement = Arrangement.SpaceEvenly,modifier = Modifier.fillMaxWidth()
        .padding(16.dp)) {
        ProfileStats(count = "150", title = "Followers")
        ProfileStats(count = "100", title = "Following")
        ProfileStats(count = "30", title = "Posts")
    }

    //Todo 8: We add a Row for the buttons and space them evenly then add a modifer to fill max width
    // and a padding as well
    Row(horizontalArrangement = Arrangement.SpaceEvenly,modifier =
    Modifier.fillMaxWidth().padding(top=16.dp)){
        /** Todo 9:We Add a Button which automatically adds an onClick method because
        all Button requires it but we leave it empty and a Text element to set the titile
         */
        Button(onClick ={}){
            Text(text = "Follow User")
        }
        Button(onClick ={}){
            Text(text = "Direct Message")
        }
    }
}
}
/**
Todo 5: Create a function with name ProfileStats and create the count and title parameters of type String.
Todo 6: Copy one of the features and paste into the function block then change
the values of the two text properties to use the two parameters count and title
 */
@Composable
fun ProfileStats(count: String, title: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally){
        Text(text = count, fontWeight = FontWeight.Bold)
        Text(text = title)
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilePagePreview() {
    ProfilePage()
}