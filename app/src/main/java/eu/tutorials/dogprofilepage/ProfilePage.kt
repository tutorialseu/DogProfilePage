package eu.tutorials.dogprofilepage

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension

@Composable
fun ProfilePage() {
    Card(elevation = 6.dp,modifier = Modifier
        .fillMaxSize()
        .padding(top = 50.dp, bottom = 100.dp, start = 16.dp, end = 16.dp)
        .border(width = 2.dp, color = Color.White, shape = RoundedCornerShape(30.dp))){
        /**
         * Todo 2 We use a BoxConstraint Widget to access the minimum width
         * and check if its less than 600 then it should display the elements using
         * the constraint sets portraitConstraints method
         */
            BoxWithConstraints {
                val constraints =  if (minWidth < 600.dp){
                    portraitConstraints(margin = 16.dp)
                }else{
                    /**Todo 5: Use the landscape constraint sets if the minimum width is greater than 600
                     * and pass in 16dp as margin for the elements using it
                     */
                    landScapeConstraints(margin = 16.dp)
                }
                /**Todo 3 then we use the ConstraintLayout widget for creating the element
                 * and with the modifier we set the layout id for each element to match the reference
                 * created within the ContstraintSets
                 */
                ConstraintLayout(constraints) {
                    Image(
                        painter =painterResource(id = R.drawable.husky), contentDescription = "husky",
                        modifier = Modifier
                            .size(100.dp)
                            .clip(CircleShape)
                            .border(width = 2.dp, color = Color.Red, shape = CircleShape)
                            .layoutId("image"),
                        contentScale = ContentScale.Crop
                    )
                    Text(text = "Siberian Husky", fontWeight = FontWeight.Bold,
                    modifier = Modifier.layoutId("nameText"))
                    Text(text = "Germany",modifier = Modifier.layoutId("countryText"))
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp)
                            .layoutId("rowstats")
                    ){
                        ProfileStats(count = "150", title = "Followers")
                        ProfileStats(count = "100", title = "Following")
                        ProfileStats(count = "30", title = "Posts")
                    }

                        Button(onClick ={/*TODO*/},
                        modifier = Modifier.layoutId("buttonFollow")){
                            Text(text = "Follow User")
                        }

                        Button(onClick ={/*TODO*/},
                            modifier = Modifier.layoutId("buttonMessage")){
                            Text(text = "Direct Message")
                        }
                    }
                }

    }
}
/**
 * Todo 1 : We create a constraintSet for the portrait orientation
 * with a @param[margin] to add spacing between required elements
 * creating a reference id for each composable
 * Then we constrain each element to each other using the ids
 */

private fun portraitConstraints(margin: Dp): ConstraintSet {
    return ConstraintSet {
        val image = createRefFor("image")
        val nameText = createRefFor("nameText")
        val countryText = createRefFor("countryText")
        val rowStats = createRefFor("rowstats")
        val buttonFollow = createRefFor("buttonFollow")
        val buttonMessage = createRefFor("buttonMessage")
        val guideLine = createGuidelineFromTop(0.3f)
        constrain(image){
            top.linkTo(guideLine)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        constrain(nameText){
            top.linkTo(image.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        constrain(countryText){
            top.linkTo(nameText.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        constrain(rowStats){
            top.linkTo(countryText.bottom)
        }
        constrain(buttonFollow){
            top.linkTo(rowStats.bottom,margin = margin)
            start.linkTo(parent.start)
            end.linkTo(buttonMessage.start)
            width = Dimension.wrapContent
        }
        constrain(buttonMessage){
            top.linkTo(rowStats.bottom,margin = margin)
            start.linkTo(buttonFollow.end)
            end.linkTo(parent.end)
            width = Dimension.wrapContent
        }
    }
}

/**
 * Todo 4 : We create a constraintSet for the landscape orientation
 * with @param[margin] for adding equal spaces between required element
 * and creating a reference id for each composable
 * Then we constrain each element to each other using the ids
 */
private fun landScapeConstraints(margin: Dp): ConstraintSet {
    return ConstraintSet {
        val image = createRefFor("image")
        val nameText = createRefFor("nameText")
        val countryText = createRefFor("countryText")
        val rowStats = createRefFor("rowstats")
        val buttonFollow = createRefFor("buttonFollow")
        val buttonMessage = createRefFor("buttonMessage")
        constrain(image){
            top.linkTo(parent.top,margin = margin)
            start.linkTo(parent.start,margin = margin)
        }
        constrain(nameText){
            start.linkTo(image.start)
            top.linkTo(image.bottom)
        }
        constrain(countryText){
            top.linkTo(nameText.bottom)
            start.linkTo(nameText.start)
            end.linkTo(nameText.end)
        }
        constrain(rowStats){
            top.linkTo(image.top)
            start.linkTo(image.end,margin = margin)
            end.linkTo(parent.end)
        }

        constrain(buttonFollow){
            top.linkTo(rowStats.bottom,margin =16.dp)
            start.linkTo(rowStats.start)
            end.linkTo(buttonMessage.start)
            bottom.linkTo(countryText.bottom)
            width = Dimension.wrapContent
        }
        constrain(buttonMessage){
            top.linkTo(rowStats.bottom,margin =16.dp)
            start.linkTo(buttonFollow.end)
            end.linkTo(parent.end)
            bottom.linkTo(countryText.bottom)
            width = Dimension.wrapContent
        }
    }
}

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