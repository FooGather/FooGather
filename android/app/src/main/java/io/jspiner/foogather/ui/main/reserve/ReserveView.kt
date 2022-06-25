package io.jspiner.foogather.ui.main.reserve

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
@Preview(showSystemUi = true)
private fun Preview() {
    ReserveView()
}

@Composable
fun ReserveView() {
    Text(text = "reserve")
}
