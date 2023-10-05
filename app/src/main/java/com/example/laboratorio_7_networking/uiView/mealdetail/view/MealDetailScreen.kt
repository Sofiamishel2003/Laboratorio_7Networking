package com.example.laboratorio_7_networking.uiView.mealdetail.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue

@Composable
fun MealDetailScreen(viewModel: MealDetailViewModel) {
    val mealDetail by viewModel.mealDetail  // Asume que mealDetail es un LiveData o State en tu ViewModel

    mealDetail?.let { detail ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = detail.strMeal,
                style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "ID: ${detail.idMeal}",
                style = TextStyle(fontSize = 18.sp),
                modifier = Modifier.padding(bottom = 8.dp)
            )
            // Aquí puedes añadir más campos, como ingredientes, etc.
        }
    } ?: run {
        Text("Cargando detalles de la comida...")
    }
}
