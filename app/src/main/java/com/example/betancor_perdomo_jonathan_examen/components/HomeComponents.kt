package com.example.betancor_perdomo_jonathan_examen.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun Boton(name: String, backColor: Color, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = backColor,
            contentColor = Color.White
        )
    ) {
        Text(text = name)
    }

}

@Composable
fun TituloBarra(name: String, colorFuente: Color) {
    Text(
        text=name,
        fontSize = 25.sp,
        color = colorFuente
    )
}

@Composable
fun TarjetaAlumno(nombre: String, imagenID: Int) {

    Row(
        modifier = Modifier.padding(all = 8.dp)
            .shadow(30.dp, shape = RectangleShape)
            .background(MaterialTheme.colorScheme.surface)

    ) {
        Image(
            painter = painterResource(imagenID),
            contentDescription = "Imagen de perfil del alumno $nombre",
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colorScheme.secondary, CircleShape)
        )

        SpaceV(8.dp)

        Column {

            Text(
                text = "Alumno: $nombre",
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.titleLarge
            )

            Text(
                text = "Soy un alumno",
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.titleMedium
            )

        }
    }

}



@Composable
fun SpaceH(size: Dp = 5.dp){
    Spacer(modifier = Modifier.height(size))
}

@Composable
fun SpaceV(size: Dp = 5.dp){
    Spacer(modifier = Modifier.width(size))
}


data class Message(val author: String, val body: String)

@Composable
fun Conversacion(messages: List<Message>, colorExpandido: Color, imagenID: Int) {
    LazyColumn {
        items(messages) { message ->
            MessageCard(message, colorExpandido, imagenID)
        }
    }
}

@Composable
fun MessageCard(msg: Message, colorExpandido: Color, imagenID: Int ) {

    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(imagenID),
            contentDescription = "Imagen de perfil",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colorScheme.secondary, CircleShape)
        )

        Spacer(modifier = Modifier.width(8.dp))

        var isExpanded by remember { mutableStateOf(false) }

        val surfaceColor by animateColorAsState(
            if (isExpanded) colorExpandido else MaterialTheme.colorScheme.surface,
            label = "",
        )


        Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {

            Text(
                text = msg.author,
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.titleMedium
            )

            SpaceH(4.dp)

            Surface(
                shape = MaterialTheme.shapes.medium,
                tonalElevation = 1.dp,
                color = surfaceColor,
                modifier = Modifier.animateContentSize().padding(1.dp)
            ) {
                Text(
                    text = msg.body,
                    modifier = Modifier.padding(all = 4.dp),
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}
