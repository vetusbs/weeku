package io.weeku.domain.usecase.shoppinglist

import io.weeku.domain.model.WeeklyMenu
import io.weeku.domain.service.ShoppingListService
import io.weeku.test.UnitTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class ShoppingListServiceTest : UnitTest() {

    private lateinit var sut: ShoppingListService

    override fun onPrepareBeforeEachTest() {
        sut = ShoppingListService()
    }

    @Test
    fun `when empty menu then empty shopping list`() {
        val weeklyMenu = WeeklyMenu(emptyList())

        val shoppingList = sut.extractShoppingList(weeklyMenu)

        assertEquals(0, shoppingList.list.size)
    }
}
