package io.weeku.data.repository.dish

import io.weeku.domain.model.Dish
import io.weeku.domain.model.Ingredient
import io.weeku.domain.model.Tag
import io.weeku.domain.model.UnitType
import io.weeku.domain.service.DishRepository
import org.apache.logging.log4j.LogManager
import org.springframework.stereotype.Component

@Component
class SimpleDishRepository(
    private val dishDatasource: DishDatasource
) : DishRepository {

    val logger = LogManager.getLogger(SimpleDishRepository::class.java)

    init {
        logger.info("repository started with [{}]", dishDatasource)
    }

    override fun fetchRandomDish(): Dish = dishDatasource.findRandomDish()
        .let {
            Dish(
                name = it.name,
                ingredients = it.ingredients.map { ingredient ->
                    Ingredient(ingredient.name, ingredient.amount.toDouble(), UnitType.valueOf(ingredient.unit_type))
                },
                tags = it.tags.map { tag ->
                    Tag(tag.name)
                },
                minutesOfPreparation = it.minutesOfPreparation,
                amountOfServants = it.amountOfServants
            )
        }
}