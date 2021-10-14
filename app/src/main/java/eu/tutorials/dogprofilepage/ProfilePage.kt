package eu.tutorials.dogprofilepage

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
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
//Todo 4 add a Row Element with three Column containing 2 Text each
    Row {
        Column(horizontalAlignment = Alignment.CenterHorizontally){
            Text(text = "150", fontWeight = FontWeight.Bold)
            Text(text = "Followers")
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally){
            Text(text = "100", fontWeight = FontWeight.Bold)
            Text(text = "Following")
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally){
            Text(text = "30", fontWeight = FontWeight.Bold)
            Text(text = "Posts")
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