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
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.digi.testapp.ui.theme.TestAppTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TestAppTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    JJKList(modifier = Modifier.padding(innerPadding))
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

@Preview
@Composable
private fun CardOnePreview() {
    CardOne()
}

@Composable
fun RatingCard(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                imageVector = Icons.Default.Info,
                contentDescription = null,
                modifier = Modifier
                    .size(32.dp)
                    .padding(8.dp)
            )
            Text(
                text = "Do you like this recommendation?",
                fontWeight = FontWeight.Bold
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "🤬", fontSize = 32.sp)
            Text(text = "☹️", fontSize = 32.sp)
            Text(text = "😐", fontSize = 32.sp)
            Text(text = "😊", fontSize = 32.sp)
            Text(text = "🤩", fontSize = 32.sp)
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Very bad", fontWeight = FontWeight.Bold)
            Text(text = "Very Good", fontWeight = FontWeight.Bold)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun RatingCardPreview() {
    RatingCard()
}

@Composable
fun InfoCard(modifier: Modifier = Modifier) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .weight(1f)
                    .height(200.dp)
            ) {
                Column {
                    Text(
                        text = "Son Goku",
                        style = MaterialTheme.typography.displaySmall,
                        fontWeight = FontWeight.ExtraBold
                    )
                    Text(
                        text = "Super Sayian",
                        style = MaterialTheme.typography.headlineSmall,
                        color = MaterialTheme.colorScheme.secondary
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                    Text(
                        text = "9000 lvl",
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.ExtraBold
                    )
                }
            }
            Image(
                painter = painterResource(id = R.drawable.goku),
                contentDescription = null,
                modifier = Modifier
                    .weight(1f)
                    .height(200.dp)
                    .drawBehind {
                        drawCircle(
                            color = Color.Blue.copy(alpha = 0.1f),
                            radius = 400f,
                        )
                        drawCircle(
                            color = Color.Blue.copy(alpha = 0.2f),
                            radius = 300f,
                        )
                    }
            )
        }
    }
}

@Preview
@Composable
private fun InfoCardPreview() {
    InfoCard()
}

@Composable
fun TaskList(modifier: Modifier = Modifier) {
    val myTasks = listOf(
        "Do Laundry", "Buy Shoes",
        "Buy clothes", "Shave", "Sleep", "Dont eat sweets",
    )
    LazyColumn {
        items(myTasks) {
            Row(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            ) {
                Text("📌 $it", fontSize = 24.sp)
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun TaskListPreview() {
    TaskList()
}


@Composable
fun JJKList(modifier: Modifier = Modifier) {
    val jjk = listOf(
        "Aoi Todo", "Satoru Gojo", "Nanami Kento",
        "Takuma Ino", "Yuji Itadori", "Yuta Okkotsu",
    )
    val jjkImages = listOf(
        R.drawable.aoitodo, R.drawable.gojo,
        R.drawable.nanami, R.drawable.takuma,
        R.drawable.yuji, R.drawable.yuta,
    )
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.fillMaxSize().padding(16.dp)
    ) {
        itemsIndexed(jjk) { index, name ->
            val imgScale = 1f
            Card(
                colors = CardDefaults.cardColors(
                   containerColor = MaterialTheme.colorScheme.background
                ),
                modifier = Modifier.padding(8.dp).width(300.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 8.dp
                ),
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = jjkImages[index]),
                        contentDescription = null,
                        modifier = Modifier
                            .weight(1f)
                            .size(200.dp)
                            .drawBehind {
                                drawCircle(
                                    color = Color.Blue.copy(alpha = 0.1f),
                                    radius = 400f,
                                )
                                drawContext.transform.scale(
                                    scaleX = imgScale,
                                    scaleY = imgScale
                                )
                                drawContext.transform.translate(
                                    left = 0f,
                                    top = 100f
                                )
                                drawCircle(
                                    color = Color.Red.copy(alpha = 0.2f),
                                    radius = 300f,
                                )

                            }
                    )
                    Text(
                        text = name,
                        modifier = Modifier.weight(1f),
                        style = MaterialTheme.typography.headlineLarge,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
private fun JJKListPrevieew() {
    JJKList()
}