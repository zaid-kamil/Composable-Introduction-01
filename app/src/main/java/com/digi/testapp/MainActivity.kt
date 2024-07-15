package com.digi.testapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.digi.testapp.ui.theme.TestAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TestAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android", modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hi $name!", modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TestAppTheme {
        Greeting("Android")
    }
}

@Composable
fun CardOne(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .background(Color.White)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(
            text = "Welcome to Jetpack Compose",
            style = MaterialTheme.typography.headlineLarge,
            textAlign = TextAlign.Center
        )
        Text(text = "14 July, 2024", style = MaterialTheme.typography.bodySmall)
        Text(text = "Zaid Kamil", style = MaterialTheme.typography.bodyLarge)
    }
}

@Composable
fun RatingCard(modifier: Modifier = Modifier) {
    Column {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.FavoriteBorder,
                contentDescription = null,
                Modifier
                    .size(32.dp)
                    .padding(8.dp)
            )
            Text(text = "Is this a good recommendation for you?", fontWeight = FontWeight.Bold)
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "🤬",
                modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp),
                fontSize = 32.sp
            )
            Text(
                text = "☹️",
                modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp),
                fontSize = 32.sp
            )
            Text(
                text = "😐",
                modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp),
                fontSize = 32.sp
            )
            Text(
                text = "😊",
                modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp),
                fontSize = 32.sp
            )
            Text(
                text = "🤩",
                modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp),
                fontSize = 32.sp
            )
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(text = "Very bad", fontWeight = FontWeight.ExtraBold)
            Text(text = "Very good", fontWeight = FontWeight.ExtraBold)
        }
    }
}


@Composable
fun SupermanInfo(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = R.drawable.superman),
                contentDescription = "superman",
                contentScale = ContentScale.Inside,
                modifier = Modifier
                    .weight(1f)
                    .drawBehind {
                        drawCircle(color = Color.Red.copy(alpha = 0.2f), radius = 350f)
                    }
            )
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp)
            ) {
                Text(text = "Superman", style = MaterialTheme.typography.headlineLarge)
                Text(text = "Clark Kent", style = MaterialTheme.typography.bodyLarge)
                Text(text = "Metropolis", style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SuperManInfoPreview() {
    SupermanInfo()

}

@Preview(showBackground = true)
@Composable
private fun RatingCardPreview() {
    RatingCard()
}

@Preview
@Composable
private fun CardOnePreview() {
    CardOne()
}
