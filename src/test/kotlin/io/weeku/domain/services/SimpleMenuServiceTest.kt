package io.weeku.domain.services

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SimpleMenuServiceTest {

    private val simpleMenuService = SimpleMenuService()

    @Test
    fun `should return a weekly menu when generate menu`() {
        val weeklyMenu = simpleMenuService.generateWeeklyMenu()

        assertThat(weeklyMenu).isNotNull
    }
}
