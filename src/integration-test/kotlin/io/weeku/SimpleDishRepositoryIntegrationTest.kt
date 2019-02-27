package io.weeku.data.repository.meal

import io.weeku.DockerComposeExtension
import io.weeku.IntegrationTest
import io.weeku.domain.service.DishRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired

@IntegrationTest
@ExtendWith(value = [DockerComposeExtension::class])
class SimpleDishRepositoryIntegrationTest {

    @Autowired
    lateinit var dishRepository: DishRepository

    @Test
    fun `should get data when exists`() {
        val randomDish = dishRepository.fetchRandomDish()

        assertThat(randomDish).isNotNull
    }
}
