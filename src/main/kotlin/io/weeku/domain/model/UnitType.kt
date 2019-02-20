package io.weeku.domain.model

enum class UnitType(val metric: Boolean) {
    UNIT(false),
    LITTLE_SPOON(false),
    BIG_SPOON(false),
    GRAM(true),
    LITRE(true)
}
