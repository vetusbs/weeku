package io.weeku.test

import com.nhaarman.mockitokotlin2.reset
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.TestInstance

@Suppress("IllegalIdentifier")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
abstract class UnitTest {
    val mocksCache = mutableListOf<Any>()

    @BeforeEach
    fun onBefore() {
        reset(*mocksCache.toTypedArray())
        onPrepareBeforeEachTest()
    }

    @AfterAll
    fun onAfterAll() {
        mocksCache.clear()
    }

    inline fun <reified T : Any> mock(): T {
        val mockObject = com.nhaarman.mockitokotlin2.mock<T>()
        mocksCache.add(mockObject)
        return mockObject
    }

    open fun onPrepareBeforeEachTest() {}
}
