package oop

class ProductCard(
    val name: String,
    val brand: String,
    val size: Float,
    val price: Int
) {

    fun printInfo() {
        println("Name: $name, Brand: $brand, size: $size, Price: $price")
    }

}