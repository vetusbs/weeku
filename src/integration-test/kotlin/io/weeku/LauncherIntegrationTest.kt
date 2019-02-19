
import io.restassured.RestAssured
import io.restassured.RestAssured.given
import io.weeku.IntegrationTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.boot.web.server.LocalServerPort

@IntegrationTest
class LauncherIntegrationTest {

    @LocalServerPort
    val serverPort: Int = 0

    @BeforeEach
    fun setupMockServerAndAwsCredentials() {
        RestAssured.baseURI = "http://localhost:$serverPort"
    }

    @Test
    fun contextLoadsAndHealthReturnsUp() {
        given().`when`()
            .get("actuator/health")
            .then()
            .statusCode(200)
    }
}
