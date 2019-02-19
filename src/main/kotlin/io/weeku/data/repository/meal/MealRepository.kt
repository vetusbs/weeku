package io.weeku.data.repository.meal

import io.weeku.data.model.Meal
import org.springframework.stereotype.Component

@Component
interface MealRepository {
    val meal: Meal
}
