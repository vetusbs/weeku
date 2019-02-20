package io.weeku.domain.usecase.shoppinglist

import io.weeku.domain.model.*
import io.weeku.test.UnitTest
import org.junit.Assert.assertEquals
import org.junit.jupiter.api.Test

internal class ExtractShoppingListUseCaseTest : UnitTest() {

    private lateinit var sut: ExtractShoppingListUseCase

    override fun onPrepareBeforeEachTest() {
        sut = ExtractShoppingListUseCase()
    }

    @Test
    fun `when empty menu then empty shopping list`() {
        val weeklyMenu = provideWeeklyMenuWithThreeIngredients()

        val shoppingList = sut.extractShoppingList(weeklyMenu)

        assertEquals(3, shoppingList.list.size)
    }

    private fun provideWeeklyMenuWithThreeIngredients() = WeeklyMenu(
        listOf(
            DailyMenu(
                listOf(
                    Meal(listOf(
                        Dish(name = "Flam", ingredients = listOf(Ingredient(name = "Flam", amount = 1.0, unitType = UnitType.UNIT))),
                        Dish(name = "Yougurt", ingredients = listOf(Ingredient(name = "Yougurt", amount = 1.0, unitType = UnitType.UNIT)))
                    ))
                )
            ),
            DailyMenu(
                listOf(
                    Meal(listOf(
                        Dish(name = "Yougurt", ingredients = listOf(Ingredient(name = "Yougurt", amount = 1.0, unitType = UnitType.UNIT))),
                        Dish(name = "Crema", ingredients = listOf(Ingredient(name = "Crema", amount = 1.0, unitType = UnitType.UNIT)))
                    ))
                )
            )
        )
    )
}
