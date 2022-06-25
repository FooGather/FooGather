package io.jspiner.foogather.dto

data class FoodDto(
    val id: Int,
    val name: String,
    val description: String,
    val restaurantName: String,
    val location: String,
    val displayDateTime: String,
    val maxCount: Int,
    val reservedCount: Int,
    val foodImageList: List<Int>,
    val storeImage: Int
)
