package io.weeku.data.model

data class Dish(val name: String, val ingredients: List<Ingredient>, val minutesOfPreparation: Int = 0, val amountOfServants: Int = 1)