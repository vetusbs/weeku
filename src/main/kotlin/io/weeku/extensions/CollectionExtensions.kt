package io.weeku.extensions

fun <T> MutableCollection<T>.extractElementEquals(element: T): T {
    val index = indexOf(element)
    val value = elementAt(index)
    remove(value)
    return value
}
