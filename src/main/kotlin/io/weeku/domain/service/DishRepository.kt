package io.weeku.domain.service

import io.weeku.domain.model.Dish
import org.springframework.stereotype.Component

@Component
interface DishRepository {
    fun fetchRandomDish(): Dish

    fun fetchAllDishes(): List<Dish>
}
