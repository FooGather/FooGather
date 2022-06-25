package io.jspiner.foogather.ui.main

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.airbnb.mvrx.viewModel
import io.jspiner.foogather.base.BaseActivity
import io.jspiner.foogather.ui.food.FoodDetailActivity
import io.jspiner.foogather.ui.main.home.HomeViewModel
import io.jspiner.foogather.ui.theme.FooGatherTheme

class MainActivity : BaseActivity() {

    private val homeViewModel: HomeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FooGatherTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainView(
                        onHomeItemClick = ::onHomeItemClick,
                        onTimeSelectorClick = ::onDateTimeSelectorClick
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

    private fun onDateTimeSelectorClick() {
        DatePickerDialog(this)
            .apply {
                setOnDateSetListener { _, year, monthOfYear, dayOfMonth ->
                    showTimePicker(year, monthOfYear, dayOfMonth)
                }
            }.show()
    }

    private fun showTimePicker(year: Int, monthOfYear: Int, dayOfMonth: Int) {
        TimePickerDialog(
            this,
            { _, hourOfDay, minute ->
                homeViewModel.setSelectedDate(
                    year,
                    monthOfYear,
                    dayOfMonth,
                    hourOfDay,
                    minute
                )
            },
            1,
            1,
            false
        ).show()
    }
}
