package io.weeku.domain.service

import io.weeku.domain.model.Dish
import io.weeku.domain.model.WeeklyMenu
import org.springframework.stereotype.Component

@Component
class MinMaxMenuService(
    val dishRepository: DishRepository
) : MenuService {
    override fun generateWeeklyMenu(numberOfDays: Int): WeeklyMenu {
        val miniMax = MiniMax(dishRepository)

        val possibleStates = miniMax.getPossibleStates()
        possibleStates.forEach {
            miniMax.constructTree(
                Node(
                    dish = it,
                    isMaxPlayer = false,
                    score = 0,
                    children = mutableListOf(),
                    depth = 1,
                    parent = null
                )
            )
        }
        return WeeklyMenu(emptyList())
    }
}

class MiniMax(val dishRepository: DishRepository) {

    fun getPossibleStates(): List<Dish> {
        return dishRepository.fetchAllDishes()
    }

    fun constructTree(parentNode: Node) {
        val listofPossibleHeaps = getPossibleStates()
        val isChildMaxPlayer = parentNode.isMaxPlayer
        listofPossibleHeaps.forEach {
            if (isValid(it, parentNode)) {
                val newNode = Node(
                    dish = it,
                    isMaxPlayer = false,
                    score = 0,
                    children = mutableListOf(),
                    depth = parentNode.depth + 1,
                    parent = parentNode
                )
                parentNode.children.add(newNode)
                if (newNode.depth < 7) {
                    constructTree(newNode)
                }
            }
        }
    }

    private fun isValid(dish: Dish, parentNode: Node): Boolean {
        return parentNode.depth < 7 && !pathContain(dish, parentNode)
    }

    private fun pathContain(dish: Dish, parentNode: Node): Boolean {
        var current = parentNode.parent
        while (current != null) {
            if (current.dish == dish) {
                return true
            }
            current = current.parent
        }
        return false
    }
}

data class Node(
    val dish: Dish,
    val isMaxPlayer: Boolean = false,
    val score: Int = 0,
    val children: MutableList<Node>,
    val depth: Int,
    val parent: Node? = null
)

class Tree {
    internal var root: Node? = null
    // setters and getters
}
