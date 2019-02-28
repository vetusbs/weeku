package io.weeku.data.repository.meal

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import io.weeku.data.repository.JpaDish
import io.weeku.data.repository.JpaIngredient
import io.weeku.data.repository.JpaTag
import io.weeku.data.repository.dish.DishDatasource
import io.weeku.data.repository.dish.SimpleDishRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.NullPointerException
import kotlin.random.Random

internal class SimpleDishRepositoryTest {

    val dishDatasource = mock<DishDatasource>()

    val simpleDishRepository = SimpleDishRepository(dishDatasource)

    @Test
    fun `should throw exception when no random dish is selected`() {
        whenever(dishDatasource.findRandomDish()).thenReturn(null)

        assertThrows<NullPointerException> {
            simpleDishRepository.fetchRandomDish()
        }
    }

    @Test
    fun `should return Dish when random dishJpa is returned from dataSource`() {
        val randomJpaDish = generateTestDish()
        whenever(dishDatasource.findRandomDish()).thenReturn(randomJpaDish)

        val randomDish = simpleDishRepository.fetchRandomDish()

        assertThat(randomDish.amountOfServants).isEqualTo(randomJpaDish.amountOfServants)
        assertThat(randomDish.name).isEqualTo(randomJpaDish.name)
        assertThat(randomDish.tags.size).isEqualTo(randomJpaDish.tags.size)
        assertThat(randomDish.ingredients.size).isEqualTo(randomJpaDish.ingredients.size)
        assertThat(randomDish.minutesOfPreparation).isEqualTo(randomJpaDish.minutesOfPreparation)
    }

    private fun generateTestDish(): JpaDish {
        val random = Random(1)
        return JpaDish(
            id = random.nextInt(),
            name = "name.${random.nextInt()}",
            minutesOfPreparation = random.nextInt(),
            amountOfServants = random.nextInt(),
            ingredients = generateTestSetOfIngredients(random),
            tags = generateTestSetOfTags(random)
        )
    }

    private fun generateTestSetOfTags(random: Random): Set<JpaTag> = emptySet()

    private fun generateTestSetOfIngredients(random: Random): Set<JpaIngredient> = emptySet()
}
