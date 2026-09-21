package profile

fun main() {
    val first = Person(name = "John", lastName = "Felix", height = 175, weight = 85)
    val second = Person(name = "Ivan", lastName = "Fedor", height = 175, weight = 85)
    val third = Person(name = "John", lastName = "Felix", height = 175, weight = 85)
    val fourth = second.copy()
    val people = setOf(first, second, third, fourth)
    people.forEach { println(it) }
}