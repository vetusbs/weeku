package io.weeku.domain.model

sealed class Meal(val dishes: List<Dish>)

data class OneDishMeal(private val dish: Dish) : Meal(listOf(dish))
data class TwoDishMeal(val starter: Dish, val main: Dish) : Meal(listOf(starter, main))
data class RegularMeal(
    val starter: Dish,
    val mainDish: Dish,
    val desert: Dish
) : Meal(listOf(starter, mainDish, desert))
