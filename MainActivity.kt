// MainActivity.kt
package com.example.eveng2demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EvenG2DemoScreen()
        }
    }
}

@Composable
fun EvenG2DemoScreen() {
    // Reaaliaikainen kello ja päivämäärä
    var currentTime by remember { mutableStateOf("") }
    var currentDate by remember { mutableStateOf("") }
    var greetingText by remember { mutableStateOf("Hello Even G2!\nSpatial Experience Demo") }

    // Päivitetään kelloa sekunnin välein
    LaunchedEffect(Unit) {
        while (true) {
            val timeFormat = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
            val dateFormat = SimpleDateFormat("EEE dd.MM.yyyy", Locale.getDefault())
            val now = Date()

            currentTime = timeFormat.format(now)
            currentDate = dateFormat.format(now)
            delay(1000L)
        }
    }

    // Vaihdetaan tervehdystekstiä 5 sekunnin kuluttua
    LaunchedEffect(Unit) {
        delay(5000L)
        greetingText = "Tervetuloa Even Hubiin!\nRakentamassa tulevaisuutta"
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.6f)) // Simuloi läpinäkyvää lasitaustaa
    ) {
        // Päätervehdys keskellä
        Text(
            text = greetingText,
            color = Color(0xFF00FF00), // Even G2 -vihreä
            fontSize = 42.sp,
            fontWeight = FontWeight.Bold,
            textAlign = androidx.compose.ui.text.style.TextAlign.Center,
            modifier = Modifier.align(Alignment.Center),
            letterSpacing = 2.sp,
            lineHeight = 56.sp
        )

        // Alaosa: ilmoitus
        Text(
            text = "Pilot Program Application in Progress 🚀",
            color = Color(0xFF00FF00).copy(alpha = 0.8f),
            fontSize = 28.sp,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 80.dp)
        )

        // Reaaliaikainen kello oikeassa yläkulmassa
        Column(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(top = 40.dp, end = 40.dp)
        ) {
            Text(
                text = currentTime,
                color = Color(0xFF00FF00),
                fontSize = 48.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 3.sp
            )
            Text(
                text = currentDate,
                color = Color(0xFF00FF00).copy(alpha = 0.7f),
                fontSize = 28.sp,
                letterSpacing = 1.sp
            )
        }
    }
}