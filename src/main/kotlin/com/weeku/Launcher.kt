package com.weeku

import com.netflix.concurrency.limits.internal.EmptyMetricRegistry
import com.netflix.concurrency.limits.limit.VegasLimit
import com.netflix.concurrency.limits.servlet.ConcurrencyLimitServletFilter
import com.netflix.concurrency.limits.servlet.ServletLimiterBuilder
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

@SpringBootApplication
class Launcher

@Configuration
class MainConfig {
    @Bean
    fun restTemplate() = RestTemplate()

    @Bean
    fun concurrencyFilter() = ConcurrencyLimitServletFilter(
            ServletLimiterBuilder()
                    .limit(VegasLimit.newBuilder().build())
                    .metricRegistry(EmptyMetricRegistry.INSTANCE)
                    .build()
    )
}

fun main(args: Array<String>) {
    runApplication<Launcher>(*args)
}
