package io.jspiner.foogather.ui.main.home

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
@Preview(showSystemUi = true)
private fun Preview() {
    HomeView()
}

@Composable
fun HomeView() {
    Text(text = "home")
}
