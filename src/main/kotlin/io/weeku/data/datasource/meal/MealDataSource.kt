package io.weeku.data.datasource.meal

import io.weeku.domain.model.Meal
import org.springframework.stereotype.Component

@Component
interface MealDataSource {
    val meal: Meal
}
