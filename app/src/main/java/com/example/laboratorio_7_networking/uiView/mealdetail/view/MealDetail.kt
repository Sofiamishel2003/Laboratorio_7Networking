package com.example.laboratorio_7_networking.uiView.mealdetail.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.laboratorio_7_networking.Navigation.Screens
import com.example.laboratorio_7_networking.Networking.response.CategoryItem
import com.example.laboratorio_7_networking.uiView.categories.view.CategoriesViewModel

@Composable
fun MealDetail(mealId: String, navController: NavController) {
    val viewModel: MealDetailViewModel = viewModel()

    LaunchedEffect(mealId) {
        viewModel.getMealDetail(mealId)
    }

    val mealDetail by viewModel.mealDetail.collectAsState(null)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)  // Aumentar el padding
    ) {
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier.align(Alignment.Start)
        ) {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
        }

        Spacer(modifier = Modifier.height(24.dp))  // Aumentar el espacio

        if (mealDetail != null) {
            Column {
                Text(
                    text = mealDetail?.details?.first()?.strMeal ?: "Cargando...",
                    style = MaterialTheme.typography.headlineLarge,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(12.dp))  // Espacio adicional
                Text(
                    text = mealDetail?.details?.first()?.strInstructions ?: "No instructions available",
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Medium  // Añadir peso medio
                )
                // Añadir más elementos visuales aquí si es necesario
            }
        } else {
            Text("Cargando detalles de la comida...", style = MaterialTheme.typography.displayLarge)
        }
    }
}
