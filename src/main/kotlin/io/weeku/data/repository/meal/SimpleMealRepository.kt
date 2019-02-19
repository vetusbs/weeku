package io.weeku.data.repository.meal

import io.weeku.data.datasource.meal.MealDataSource
import io.weeku.data.model.Meal
import org.springframework.stereotype.Component

@Component
class SimpleMealRepository(
    private val mealDataSource: MealDataSource
) : MealRepository {

    override val meal: Meal
        get() = mealDataSource.meal
}
