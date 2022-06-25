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
                "피자왕 파파존스",
                "파파존스 코리아는 피자 재료의 품질과 관리 시스템 모두 철저하게 까다로운 미국 본사의 가이드라인을 따르며 탁월한 '맛의 차이'를 바탕으로 국내의 대표적인 프리미엄 피자브랜드로 그 위상을 더욱 확고히 할 것입니다.",
                "파파존스",
                "서울 서초구 주홍로 3",
                "2022.06.25 토요일\n오후 3:00",
                5,
                2,
                listOf(R.drawable.food_3, R.drawable.food_4),
                R.drawable.store
            ),
            FoodDto(
                3,
                "처갓집 양념치킨",
                "처갓집양념치킨의 닭고기는 가족회사인 체리부로를 통해\n" +
                        "제공받는 단일 브랜드의 신선육만을 사용합니다",
                "처갓집",
                "서울 서초구 주홍로 3",
                "2022.06.25 토요일\n오후 3:00",
                2,
                1,
                listOf(R.drawable.food_5, R.drawable.food_6),
                R.drawable.store
            ),
            FoodDto(
                4,
                "맘쓰터치 싸이버거",
                "부드럽고 촉촉한 안심, 바삭한 튀김옷을 입은 돈까스입니다. 추억의 향기를 기억하는 분들은 푸게더 한입과 추억이 되살아나는 경험을 할 수 있어요!",
                "맘스터치",
                "서울 서초구 주홍로 3",
                "2022.06.25 토요일\n오후 3:00",
                3,
                0,
                listOf(R.drawable.food_7, R.drawable.food_8),
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
