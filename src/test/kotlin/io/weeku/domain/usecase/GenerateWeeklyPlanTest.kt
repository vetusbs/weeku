package io.weeku.domain.usecase

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import io.weeku.domain.model.ShoppingList
import io.weeku.domain.model.WeeklyMenu
import io.weeku.domain.service.MenuService
import io.weeku.domain.service.ShoppingListService
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import kotlin.random.Random

internal class GenerateWeeklyPlanTest {

    private val anyValidInputNumber = Random.nextInt(1, 8)
    private val anyWeeklyMenu = WeeklyMenu(emptyList())
    private val anyShoppingList = ShoppingList(emptyList())

    private val menuService = mock<MenuService>()
    private val shoppingListService = mock<ShoppingListService>()

    private val generateWeeklyPlan = GenerateWeeklyPlan(menuService, shoppingListService)

    @Test
    fun `should return GenerateWeeklyPlanOkOutput with weeklyMenu and shoppingList`() {
        val generateWeeklyPlanInput = GenerateWeeklyPlanInput(anyValidInputNumber)
        whenever(menuService.generateWeeklyMenu(anyValidInputNumber)).thenReturn(anyWeeklyMenu)
        whenever(shoppingListService.extractShoppingList(anyWeeklyMenu)).thenReturn(anyShoppingList)

        val output = generateWeeklyPlan.execute(generateWeeklyPlanInput) as GenerateWeeklyPlanOkOutput

        assertThat(output).isInstanceOf(GenerateWeeklyPlanOkOutput::class.java)
        assertThat(output.weeklyPlan.weeklyMenu).isEqualTo(anyWeeklyMenu)
        assertThat(output.weeklyPlan.shoppingList).isEqualTo(anyShoppingList)
    }

    @Test
    fun `should return error output when input numberOfDays is greater than 7`() {
        val generateWeeklyPlanInput = GenerateWeeklyPlanInput(10)

        val output = generateWeeklyPlan.execute(generateWeeklyPlanInput)

        assertThat(output).isInstanceOf(GenerateWeeklyPlanErrorOutput::class.java)
    }

    @Test
    fun `should return error output when input numberOfDays is lower than 0`() {
        val generateWeeklyPlanInput = GenerateWeeklyPlanInput(-1)

        val output = generateWeeklyPlan.execute(generateWeeklyPlanInput)

        assertThat(output).isInstanceOf(GenerateWeeklyPlanErrorOutput::class.java)
    }

    @Test
    fun `should return error output when input numberOfDays is 0`() {
        val generateWeeklyPlanInput = GenerateWeeklyPlanInput(0)

        val output = generateWeeklyPlan.execute(generateWeeklyPlanInput)

        assertThat(output).isInstanceOf(GenerateWeeklyPlanErrorOutput::class.java)
    }
}
