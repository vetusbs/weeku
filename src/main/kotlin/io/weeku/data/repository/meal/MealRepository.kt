package io.weeku.data.repository.meal

import io.weeku.domain.model.Meal
import org.springframework.stereotype.Component

@Component
interface MealRepository {
    val meal: Meal
}
