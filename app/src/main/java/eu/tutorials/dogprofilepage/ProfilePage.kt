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
    Card(
        elevation = 6.dp, modifier = Modifier
            .fillMaxSize()
            .padding(top = 50.dp, bottom = 100.dp, start = 16.dp, end = 16.dp)
            .border(width = 2.dp, color = Color.White, shape = RoundedCornerShape(30.dp))
    ) {
        //Todo 1: Replace Column with ContsraintLayout
        ConstraintLayout {
            //Todo 2: create reference id for image composable
            //Todo 4: add the nameText id
            //Todo 8: add countryText id
            //Todo 10: add rowstats id
            //Todo 12:add buttonFollow and buttonMessage id
            val (image,nameText,countryText,rowstats,buttonFollow,buttonMessage
            ) = createRefs()

            //Todo 14: create an id and assign a guideline from top with 0.3f
            val guideLine = createGuidelineFromTop(0.3f)
            /**Todo 3: Add constrainAs attribute to image modifier with the image id
             * Add a constraintBlock and set image to to top of parent
             * start to start of parent and end to end of parent
             */
            //Todo 15: change top link from parent top to the modifier
            Image(
                painter = painterResource(id = R.drawable.husky), contentDescription = "husky",
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .border(width = 2.dp, color = Color.Red, shape = CircleShape)
                    .constrainAs(image){
                        top.linkTo(guideLine)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                contentScale = ContentScale.Crop
            )
            /** Todo 5: Add constrainAs to the Text Modifier with nameText id
             * Add a constraint block with its top to bottom of image
             * start to parent start, end to parent end
             */
            Text(
                text = "Siberian Husky", fontWeight = FontWeight.Bold,
                modifier = Modifier.constrainAs(nameText){
                        top.linkTo(image.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                }
            )
            /**Todo 9: Add constrainAs to the text Modifier with countryText id
             * Add a constraint block and link its top to top bottom of nameText
             * start to start of parent and end to end of parent
             */
            Text(text = "Germany", modifier = Modifier.constrainAs(countryText){
                    top.linkTo(nameText.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)

            })
            /**Todo 11: Add constrainAs to its modifier with rowStats id
             * Add a constraint block and link its top to bottom of countryText
             */
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
                    .constrainAs(rowstats){
                        top.linkTo(countryText.bottom)
                    }
            ) {
                ProfileStats(count = "150", title = "Followers")
                ProfileStats(count = "100", title = "Following")
                ProfileStats(count = "30", title = "Posts")
            }

            /**Todo 14: add constrainAs to its modifier with an id with a constrainBlock
             * link its top to bottom of rowstat and add a space margin of 16dp
             * link the start to parent start, its end to buttonMessage start
             * and a width of wrap content
             *
             */
            Button(
                onClick = {/*TODO*/ },
                modifier = Modifier.constrainAs(buttonFollow){
                    top.linkTo(rowstats.bottom,margin = 16.dp)
                    start.linkTo(parent.start)
                    end.linkTo(buttonMessage.start)
                    width = Dimension.wrapContent
                }
            ) {
                Text(text = "Follow User")
            }

            Button(
                onClick = {/*TODO*/ },
                modifier = Modifier.constrainAs(buttonMessage){
                        top.linkTo(rowstats.bottom,margin = 16.dp)
                        start.linkTo(buttonFollow.end)
                        end.linkTo(parent.end)
                        width = Dimension.wrapContent
                }
            ) {
                Text(text = "Direct Message")
            }
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