package io.weeku.domain.service.csp

data class MaxTagPerMenu(val maxNumber: Int) : Constrain {
    override fun type(): ConstrainType = ConstrainType.MAX_TAG_PER_MENU
}
