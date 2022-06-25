package io.jspiner.foogather.base

import androidx.appcompat.app.AppCompatActivity
import com.airbnb.mvrx.MavericksView

abstract class BaseActivity : AppCompatActivity(), MavericksView {

    override fun setContentView(layoutResID: Int) {
        super.setContentView(layoutResID)
    }

    override fun invalidate() = Unit
}
