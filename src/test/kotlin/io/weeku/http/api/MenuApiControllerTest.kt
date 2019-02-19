package io.weeku.http.api

import com.nhaarman.mockitokotlin2.whenever
import io.weeku.domain.services.MenuService
import io.weeku.domain.services.objects.WeeklyMenu
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext

@WebMvcTest
internal class MenuApiControllerTest {
    @Autowired
    private lateinit var context: WebApplicationContext

    @MockBean
    lateinit var menuService: MenuService

    lateinit var mockMvc: MockMvc

    @BeforeEach
    fun setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build()
    }

    @Test
    fun `should return 200 when get menu`() {
        whenever(menuService.generateWeeklyMenu()).thenReturn(WeeklyMenu(emptyList()))

        this.mockMvc.perform(get("/api/menu"))
            .andExpect(status().isOk)
    }
}