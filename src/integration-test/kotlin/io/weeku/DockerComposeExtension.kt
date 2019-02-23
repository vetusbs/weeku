package io.weeku

import com.meltwater.docker.compose.DockerCompose
import org.junit.jupiter.api.extension.AfterAllCallback
import org.junit.jupiter.api.extension.BeforeAllCallback
import org.junit.jupiter.api.extension.ExtensionContext

class DockerComposeExtension : BeforeAllCallback, AfterAllCallback {
    lateinit var compose: DockerCompose

    @Throws(Exception::class)
    override fun beforeAll(ctx: ExtensionContext) {
        val env = HashMap<String, String>()
        compose = DockerCompose("docker-compose.yml", "uniqe-namespace", env)

        compose.up()
    }

    override fun afterAll(context: ExtensionContext?) {
        compose.kill()
    }
}
