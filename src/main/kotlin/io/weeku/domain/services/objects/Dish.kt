package io.weeku.domain.services.objects

data class Dish(val name: String, val ingredients: List<Ingredient>, val minutesOfPreparation: Int = 0, val amountOfServants: Int = 1)
