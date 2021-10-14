package eu.tutorials.dogprofilepage

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
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
}
}

@Preview(showBackground = true)
@Composable
fun ProfilePagePreview() {
    ProfilePage()
}