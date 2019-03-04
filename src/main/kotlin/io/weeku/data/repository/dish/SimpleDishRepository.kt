package io.weeku.data.repository.dish

import io.weeku.data.repository.JpaDish
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
            it.toDish()
        }

    override fun fetchAllDishes():
        List<Dish> = dishDatasource.findAll().map { it.toDish() }

    private fun JpaDish.toDish(): Dish = Dish(
        name = this.name,
        ingredients = this.ingredients.map { ingredient ->
            Ingredient(ingredient.name, ingredient.amount.toDouble(), UnitType.valueOf(ingredient.unit_type))
        },
        tags = this.tags.map { tag ->
            Tag(tag.name)
        },
        minutesOfPreparation = this.minutesOfPreparation,
        amountOfServants = this.amountOfServants
    )
}
