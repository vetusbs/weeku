package io.weeku.domain.service

import io.weeku.domain.model.Meal
import org.springframework.stereotype.Component

@Component
interface MealRepository {
    val meal: Meal
}
