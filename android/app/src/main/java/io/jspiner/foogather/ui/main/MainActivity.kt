package io.jspiner.foogather.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import io.jspiner.foogather.ui.food.FoodDetailActivity
import io.jspiner.foogather.ui.theme.FooGatherTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FooGatherTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainView(
                        onHomeItemClick = ::onHomeItemClick
                    )
                }
            }
        }
    }

    private fun onHomeItemClick() {
        startActivity(
            Intent(this, FoodDetailActivity::class.java)
        )
    }
}
