package io.jspiner.foogather.ui.main.home

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MavericksState
import com.airbnb.mvrx.Uninitialized
import io.jspiner.foogather.base.BaseViewModel
import io.jspiner.foogather.dto.CategoryDto
import io.jspiner.foogather.dto.FoodDto
import io.jspiner.foogather.repository.FooGatherRepository
import java.util.*

data class HomeState(
    val selectedDateTime: Date = Calendar.getInstance().time,
    val categoryList: Async<List<CategoryDto>> = Uninitialized,
    val selectedCategoryId: Int = 0, // 0 : 전체
    val foodList: Async<List<FoodDto>> = Uninitialized
) : MavericksState

class HomeViewModel(
    initialState: HomeState,
) : BaseViewModel<HomeState>(initialState) {

    private val repository: FooGatherRepository = FooGatherRepository()

    fun fetchCategoryList() {
        suspend {
            repository.getCategoryList()
        }.execute { copy(categoryList = it) }
    }

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

    fun fetchFoodList() {
        withState { state ->
            suspend {
                repository.getFoodList(state.selectedCategoryId, state.selectedDateTime.time)
            }.execute {
                copy(foodList = it)
            }
        }
    }
}
