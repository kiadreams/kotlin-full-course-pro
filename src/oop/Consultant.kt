package oop

class Consultant(
    val name: String,
    val age: Int = 0
) {
    fun sayHello() {
        print("Привет! Меня зовут $name.")
        if (age > 0) println(" Мне $age лет.")
    }
}