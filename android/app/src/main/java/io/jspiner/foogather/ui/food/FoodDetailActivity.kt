package io.jspiner.foogather.ui.food

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.airbnb.mvrx.viewModel
import io.jspiner.foogather.base.BaseActivity
import io.jspiner.foogather.ui.done.DoneActivity
import io.jspiner.foogather.ui.main.home.HomeViewModel
import io.jspiner.foogather.ui.theme.FooGatherTheme

class FoodDetailActivity : BaseActivity() {

    private val viewModel: FoodDetailViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            FooGatherTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    FoodDetailView {
                        startActivity(
                            Intent(this, DoneActivity::class.java)
                        )
                    }
                }
            }
        }

        viewModel.fetchFood(intent.getIntExtra(KEY_ID, 1))
    }

    companion object {

        private const val KEY_ID = "key_id"

        fun getIntent(context: Context, foodId: Int) =
            Intent(context, FoodDetailActivity::class.java)
                .putExtra(KEY_ID, foodId)
    }
}
