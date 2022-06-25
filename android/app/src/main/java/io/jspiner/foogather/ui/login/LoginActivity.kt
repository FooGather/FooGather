package io.jspiner.foogather.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import io.jspiner.foogather.base.BaseActivity
import io.jspiner.foogather.ui.main.MainActivity
import io.jspiner.foogather.ui.theme.FooGatherTheme

class LoginActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            FooGatherTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LoginView(
                        onLoginClick = ::onLoginClick
                    )
                }
            }
        }
    }

    private fun onLoginClick() {
        // TODO 카카오 로그인
        startActivity(
            Intent(this, MainActivity::class.java)
        )
        finish()
    }
}
