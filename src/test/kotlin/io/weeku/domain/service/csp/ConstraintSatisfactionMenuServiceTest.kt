package io.weeku.domain.service.csp

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import io.weeku.domain.model.Dish
import io.weeku.domain.service.ConstraintSatisfactionMenuService
import io.weeku.domain.service.DishRepository
import org.junit.jupiter.api.Test
import kotlin.random.Random

internal class ConstraintSatisfactionMenuServiceTest {
    val random = Random(1)

    val mockDishRepository = mock<DishRepository>()
    val cspMenuService = ConstraintSatisfactionMenuService(mockDishRepository, emptyList())

    private val listOfDish = listOf(
        generateTestDish(),
        generateTestDish(),
        generateTestDish(),
        generateTestDish(),
        generateTestDish(),
        generateTestDish(),
        generateTestDish(),
        generateTestDish(),
        generateTestDish(),
        generateTestDish()
    )

    @Test
    fun `test de prova`() {
        whenever(mockDishRepository.fetchAllDishes()).thenReturn(listOfDish)

        val generateWeeklyMenu = cspMenuService.generateWeeklyMenu(3)
    }

    private fun generateTestDish(): Dish {
        return Dish(
            name = "name.${random.nextInt()}",
            minutesOfPreparation = random.nextInt(),
            amountOfServants = random.nextInt(),
            ingredients = emptyList(),
            tags = emptyList()
        )
    }
}
