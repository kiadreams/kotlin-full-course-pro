package cats

fun main() {
    val cat = Cat("Sam")
    val lion = Lion(25)
    val animals = listOf<CatsFamily>(cat, lion)
    animals.forEach { it.eat() }
}