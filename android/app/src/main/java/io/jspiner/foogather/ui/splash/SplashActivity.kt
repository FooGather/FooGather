package io.jspiner.foogather.ui.splash

import android.content.Intent
import android.os.Bundle
import io.jspiner.foogather.base.BaseActivity
import io.jspiner.foogather.ui.login.LoginActivity
import io.jspiner.foogather.ui.main.MainActivity

class SplashActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO
        val isLoggedIn = false

        startActivity(
            if (isLoggedIn) {
                Intent(this, MainActivity::class.java)
            } else {
                Intent(this, LoginActivity::class.java)
            }
        )
        finish()
    }
}
