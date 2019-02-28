package io.weeku.domain.usecase

import org.springframework.stereotype.Component
import java.lang.annotation.Inherited

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FILE)
@Component
@Inherited
annotation class UseCaseComponent
