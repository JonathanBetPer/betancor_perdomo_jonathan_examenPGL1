package com.example.betancor_perdomo_jonathan_examen.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.betancor_perdomo_jonathan_examen.Mensajes
import com.example.betancor_perdomo_jonathan_examen.R
import com.example.betancor_perdomo_jonathan_examen.components.Boton
import com.example.betancor_perdomo_jonathan_examen.components.Conversacion
import com.example.betancor_perdomo_jonathan_examen.components.ConversacionDoble
import com.example.betancor_perdomo_jonathan_examen.components.SpaceV
import com.example.betancor_perdomo_jonathan_examen.components.TarjetaAlumno
import com.example.betancor_perdomo_jonathan_examen.components.TituloBarra

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(){
    val alumno3Color = Color(0xFFFF9E80)
    val imagenProfesor = R.drawable.profesor
    val imagenAlumno = R.drawable.avatar3
    val nombreAlumno = "Jonathan B."


    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { TituloBarra(name="Conversación $nombreAlumno", alumno3Color)},
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            )
        }
    ) {
        ContentHomeView(imagenProfesor, imagenAlumno, nombreAlumno)
    }
}


@Composable
fun ContentHomeView(imagenProfesor: Int, imagenAlumno: Int, nombreAlumno: String) {

    val listaColores = listOf(Color.Magenta, Color.Green, Color.Blue, Color.Red, Color.Cyan)
    var numeroRandom by remember {
        mutableStateOf(0)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 80.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TarjetaAlumno(nombre = nombreAlumno, imagenID = imagenAlumno)

        SpaceV(5.dp)
        
        Boton(name = "Elegir nuevo color", backColor = listaColores.get(numeroRandom)) {
            numeroRandom = (0..listaColores.size).random()
        }

        SpaceV(5.dp)
        // Conversación Simple
        // Conversacion(messages = Mensajes.conversationSample , colorExpandido = listaColores.get(numeroRandom), imagenID = imagenProfesor)
        ConversacionDoble(messages = Mensajes.conversaionAlumnoProfesor,
            colorExpandido = listaColores.get(numeroRandom),
            imagenIDProfesor = imagenProfesor,
            imagenIDAlumno = imagenAlumno,
            nombreAlumno = nombreAlumno )

    }
}
