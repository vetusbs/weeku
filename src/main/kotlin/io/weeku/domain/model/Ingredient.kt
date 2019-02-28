package io.weeku.domain.model

data class Ingredient(val name: String, val amount: Double, val unitType: UnitType) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Ingredient

        if (name != other.name) return false
        if (unitType != other.unitType) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + unitType.hashCode()
        return result
    }
}
