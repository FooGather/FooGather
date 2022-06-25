package io.jspiner.foogather.ui.main.settings

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
@Preview(showSystemUi = true)
private fun Preview() {
    SettingsView()
}

@Composable
fun SettingsView() {
    Text(text = "settings")
}
