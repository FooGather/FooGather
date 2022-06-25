package io.jspiner.foogather.ui.food

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MavericksState
import com.airbnb.mvrx.Uninitialized
import io.jspiner.foogather.base.BaseViewModel
import io.jspiner.foogather.dto.FoodDto
import io.jspiner.foogather.repository.FooGatherRepository

data class FoodDetailState(
    val food: Async<FoodDto> = Uninitialized
) : MavericksState

class FoodDetailViewModel(initialState: FoodDetailState) :
    BaseViewModel<FoodDetailState>(initialState) {

    private val repository = FooGatherRepository()

    fun fetchFood(id: Int) {
        suspend { repository.getFood(id) }
            .execute { copy(food = it) }
    }

}
