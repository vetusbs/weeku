package io.weeku.data.repository.meal

import io.weeku.data.datasource.meal.DishDatasource
import io.weeku.domain.model.Dish
import io.weeku.domain.model.Ingredient
import io.weeku.domain.model.UnitType
import io.weeku.domain.service.DishRepository
import org.springframework.stereotype.Component

@Component
class SimpleDishRepository(
    private val dishDatasource: DishDatasource
) : DishRepository {

    override fun fetchRandomDish():
        Dish = dishDatasource.findAll().random().let {
        val toMutableList = it.ingredients.toMutableList()
        return Dish(
            name = it.name,
            ingredients = toMutableList.map { ingredient ->
                Ingredient(ingredient.name, ingredient.amount.toDouble(), UnitType.valueOf(ingredient.unit_type))
            },
            minutesOfPreparation = it.preparationTime
        )
    }
}
