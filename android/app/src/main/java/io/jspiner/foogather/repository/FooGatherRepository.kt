package io.jspiner.foogather.repository

import io.jspiner.foogather.R
import io.jspiner.foogather.dto.CategoryDto
import io.jspiner.foogather.dto.FoodDto
import kotlinx.coroutines.delay

class FooGatherRepository {
    suspend fun getCategoryList(): List<CategoryDto> {
        delay(800)

        return listOf(
            CategoryDto(
                1,
                "일식",
                R.drawable.ic_category_1
            ),
            CategoryDto(
                2,
                "한식",
                R.drawable.ic_category_2
            ),
            CategoryDto(
                3,
                "치킨",
                R.drawable.ic_category_3
            ),
            CategoryDto(
                4,
                "피자",
                R.drawable.ic_category_4
            ),
            CategoryDto(
                5,
                "양식",
                R.drawable.ic_category_5
            ),
            CategoryDto(
                6,
                "햄버거",
                R.drawable.ic_category_6
            )
        )
    }

    suspend fun getFoodList(
        categoryId: Int,
        selectedTime: Long
    ): List<FoodDto> {
        delay(800)

        return listOf(
            FoodDto(
                1,
                "푸게더 돈까스",
                "부드럽고 촉촉한 안심, 바삭한 튀김옷을 입은 돈까스입니다. 추억의 향기를 기억하는 분들은 푸게더 한입과 추억이 되살아나는 경험을 할 수 있어요!",
                "푸게더",
                "서울 서초구 주홍로 3",
                "2022.06.25 토요일\n오후 3:00",
                6,
                3,
                listOf(R.drawable.food_1, R.drawable.food_2),
                R.drawable.store
            ),
            FoodDto(
                2,
                "마루 스시",
                "즉석에서 바로 만든 일품 수제초밥",
                "마루 스시",
                "서울 서초구 주홍로 3",
                "2022.06.25 토요일\n오후 3:00",
                5,
                2,
                listOf(R.drawable.food_4, R.drawable.food_4),
                R.drawable.store
            ),
            FoodDto(
                3,
                "호호식당",
                "좋은 재료로 만든 맛있고 건강한 일본 가정식",
                "호호식당",
                "서울 서초구 주홍로 3",
                "2022.06.25 토요일\n오후 3:00",
                2,
                1,
                listOf(R.drawable.food_6, R.drawable.food_6),
                R.drawable.store
            ),
            FoodDto(
                4,
                "상무초밥",
                "밥이 맛있는 상무초밥",
                "상무초밥",
                "서울 서초구 주홍로 3",
                "2022.06.25 토요일\n오후 3:00",
                3,
                0,
                listOf(R.drawable.food_8, R.drawable.food_8),
                R.drawable.store
            )
        )
    }

    suspend fun getFood(
        foodId: Int
    ): FoodDto {
        return getFoodList(0, 0).find { it.id == foodId }!!
    }
}
