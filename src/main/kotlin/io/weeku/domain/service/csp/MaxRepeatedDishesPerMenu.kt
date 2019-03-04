package io.weeku.domain.service.csp

data class MaxRepeatedDishesPerMenu(val maxNumber: Int) : Constrain {
    override fun type(): ConstrainType = ConstrainType.MAX_TIMES_PER_DISH
}
