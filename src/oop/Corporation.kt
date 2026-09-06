package oop


fun main() {
    val assistant = Assistant()
    assistant.bringCoffee(5, "Latte")
    val card = ProductCard(name = "Sneakers", brand = "Nike", size = 39.toFloat(), price = 3000)
    card.printInfo()
}