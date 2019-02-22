package io.weeku.domain.service

import io.weeku.domain.model.Dish
import io.weeku.domain.model.Meal
import org.springframework.stereotype.Component

@Component
interface DishRepository {
    fun fetchRandomDish(): Dish
}
