package com.example.laboratorio_7_networking.uiView.categories.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue

@Composable
fun MealsInCategoryScreen(viewModel: CategoriesViewModel) {
    val categories by viewModel.categories
    LazyColumn {
        items(categories) { category ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(
                    text = category.strCategory,
                    style = TextStyle(fontSize = 20.sp)
                )
            }
        }
    }
}
