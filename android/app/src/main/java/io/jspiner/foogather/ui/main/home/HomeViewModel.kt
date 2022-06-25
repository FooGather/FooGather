package io.jspiner.foogather.ui.main.home

import com.airbnb.mvrx.MavericksState
import io.jspiner.foogather.base.BaseViewModel
import java.util.*

data class HomeState(
    val selectedDateTime: Date = Calendar.getInstance().time
) : MavericksState

class HomeViewModel(initialState: HomeState) : BaseViewModel<HomeState>(initialState) {

    fun setSelectedDate(year: Int, monthOfYear: Int, dayOfMonth: Int, hourOfDay: Int, minute: Int) {
        val calendar = Calendar.getInstance()

        calendar.set(Calendar.DAY_OF_YEAR, year)
        calendar.set(Calendar.MONTH, monthOfYear)
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)

        calendar.set(Calendar.HOUR_OF_DAY, hourOfDay)
        calendar.set(Calendar.MINUTE, minute)
        calendar.set(Calendar.SECOND, 0)

        setState {
            copy(selectedDateTime = calendar.time)
        }

    }
}
