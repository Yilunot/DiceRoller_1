package com.example.diceroller

import android.icu.text.CaseMap.Title
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.layout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.diceroller.ui.theme.DiceRollerTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerTheme {
                DiceRollerApp()
            }
        }
    }
@Preview
@Composable
//Name of the program
fun DiceRollerApp() {
    //Compose uses a Modifier object, which is a collection of elements
    // that decorate or modify the behavior of Compose UI elements.
    DiceWithButtonAndImage(
        modifier = Modifier
            //if the componet insisde is smaller than the layout.
            .fillMaxSize()
            //to be able to center components.
            .wrapContentSize(Alignment.Center))

}
@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {
    var result by remember { mutableStateOf(1) }
    //The result variable can now be used to determine which image to show.
    val imageResource = when (result) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
    //This ensures that the children within the column are centered on the device screen with respect to the width.
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        //adding just a title.
        Text(text = stringResource(R.string.Title))
        Spacer(modifier = Modifier.height(100.dp))

        Image(painter = painterResource(imageResource), contentDescription = result.toString())
        //Now the button is tappable, but a tap of the button won't cause any visual change yet
        // because you still need to build that functionality. 2.0
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { result = (1..6).random()}
        ) {
            Text(text = stringResource(R.string.roll))
        }
    }
}
}