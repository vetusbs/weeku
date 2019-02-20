package io.weeku.domain.usecase.shoppinglist

import io.weeku.data.model.WeeklyMenu
import io.weeku.test.UnitTest
import org.junit.Assert.assertEquals
import org.junit.jupiter.api.Test

internal class ShoppingListUseCaseTest : UnitTest() {

    private lateinit var sut: ShoppingListUseCase

    override fun onPrepareBeforeEachTest() {
        sut = ShoppingListUseCase()
    }

    @Test
    fun `when empty menu then empty shopping list`() {
        val weeklyMenu = WeeklyMenu(emptyList())

        val shoppingList = sut.extractShoppingList(weeklyMenu)

        assertEquals(0, shoppingList.list.size)
    }
}
