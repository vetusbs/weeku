package com.weeku.domain.services.objects

data class Meal(
    val starter: com.weeku.domain.services.objects.Dish,
    val mainDish: com.weeku.domain.services.objects.Dish,
    val deserts: com.weeku.domain.services.objects.Dish
)