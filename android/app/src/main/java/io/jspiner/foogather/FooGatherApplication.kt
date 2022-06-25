package io.jspiner.foogather

import android.app.Application
import com.airbnb.mvrx.Mavericks

class FooGatherApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        Mavericks.initialize(this)
    }

}
