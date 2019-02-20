package io.weeku

import io.restassured.RestAssured
import io.restassured.RestAssured.given
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.boot.web.server.LocalServerPort

@IntegrationTest
class LauncherIntegrationTest {

    @LocalServerPort
    val serverPort: Int = 0

    @BeforeEach
    fun setUp() {
        RestAssured.baseURI = "http://localhost:$serverPort"
    }

    @Test
    fun `context is loaded and health endpoint is up`() {
        given().`when`()
            .get("actuator/health")
            .then()
            .statusCode(200)
    }
}
