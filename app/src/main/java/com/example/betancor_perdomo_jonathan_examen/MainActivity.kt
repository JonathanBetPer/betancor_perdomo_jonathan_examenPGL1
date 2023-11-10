package com.example.betancor_perdomo_jonathan_examen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.betancor_perdomo_jonathan_examen.ui.theme.Betancor_perdomo_jonathan_examenTheme
import com.example.betancor_perdomo_jonathan_examen.views.HomeView

//Número de lista 3
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Betancor_perdomo_jonathan_examenTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeView()
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun Preview() {
    Betancor_perdomo_jonathan_examenTheme {
        HomeView()
    }
}