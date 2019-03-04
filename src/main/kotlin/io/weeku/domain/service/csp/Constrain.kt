package io.weeku.domain.service.csp

interface Constrain {
    fun type(): ConstrainType
}

enum class ConstrainType(val isWeekly: Boolean, isDailyMenu: Boolean) {
    MAX_TIMES_PER_DISH(true, true),
    MAX_TAG_PER_MENU(false, true)
}
