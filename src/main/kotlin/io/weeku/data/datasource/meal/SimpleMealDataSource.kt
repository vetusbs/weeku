package io.weeku.data.datasource.meal

import io.weeku.data.model.Dish
import io.weeku.data.model.Ingredient
import io.weeku.data.model.Meal
import io.weeku.data.model.UnitType
import org.springframework.stereotype.Component
import kotlin.random.Random

@Component
class SimpleMealDataSource : MealDataSource {

    private val random = Random(1)

    override val meal: Meal
        get() = Meal(
            listOf(
                getRandomDish(STARTERS),
                getRandomDish(MAIN_DISHES),
                getRandomDish(DESERTS)
            )
        )

    private fun getRandomDish(dishes: List<Dish>) =
        dishes[random.nextInt(0, dishes.size)]
}

private val STARTERS = listOf(
    Dish(name = "Macarrons bolonyesa",
        minutesOfPreparation = 30,
        ingredients = listOf(
            Ingredient(name = "Macarrons", amount = 250.0, unitType = UnitType.GRAM),
            Ingredient(name = "Salsa de tomàquet", amount = 150.0, unitType = UnitType.GRAM)
        )
    ),
    Dish(name = "Patata i mongeta tendra", minutesOfPreparation = 20, ingredients = emptyList()),
    Dish(name = "Sopa de peix amb pistons", minutesOfPreparation = 45, ingredients = emptyList()),
    Dish(name = "Caldo de verdures", minutesOfPreparation = 35, ingredients = emptyList()),
    Dish(name = "Amanida verda amb burrata", minutesOfPreparation = 15, ingredients = emptyList()),
    Dish(name = "Arròs a la cubana",
        minutesOfPreparation = 25,
        ingredients = listOf(
            Ingredient(name = "Arrós", amount = 150.0, unitType = UnitType.GRAM),
            Ingredient(name = "Salsa de tomàquet", amount = 100.0, unitType = UnitType.GRAM),
            Ingredient(name = "Ou", amount = 2.0, unitType = UnitType.UNIT)
        )
    )
)

private val MAIN_DISHES = listOf(
    Dish(name = "Entrecot", minutesOfPreparation = 10, ingredients = emptyList()),
    Dish(name = "Vedella amb bolets", minutesOfPreparation = 50, ingredients = emptyList()),
    Dish(name = "Rap a la planxa", minutesOfPreparation = 20, ingredients = emptyList()),
    Dish(name = "Filet de pollastre", minutesOfPreparation = 10, ingredients = emptyList()),
    Dish(name = "Croquetes", minutesOfPreparation = 40, ingredients = emptyList()),
    Dish(name = "Conill", minutesOfPreparation = 15, ingredients = emptyList())
)

private val DESERTS = listOf(
    Dish(name = "Flam", ingredients = listOf(Ingredient(name = "Flam", amount = 1.0, unitType = UnitType.UNIT))),
    Dish(name = "Yougurt", ingredients = listOf(Ingredient(name = "Yougurt", amount = 1.0, unitType = UnitType.UNIT))),
    Dish(name = "Poma", ingredients = listOf(Ingredient(name = "Poma", amount = 1.0, unitType = UnitType.UNIT))),
    Dish(name = "Pera", ingredients = listOf(Ingredient(name = "Pera", amount = 1.0, unitType = UnitType.UNIT))),
    Dish(name = "Taronja", ingredients = listOf(Ingredient(name = "Taronja", amount = 1.0, unitType = UnitType.UNIT))),
    Dish(name = "Crema", ingredients = listOf(Ingredient(name = "Crema", amount = 1.0, unitType = UnitType.UNIT)))
)
