package oop.corporation

import kotlin.random.Random

class Consultant(
    name: String,
    age: Int = 0
) : Worker(name = name, age = age) {
    fun sayHello() {
        print("Привет! Меня зовут $name.")
        if (age > 0) println(" Мне $age лет.")
    }

    fun serveCustomers(): Int {
        val customerCount = Random.nextInt(100)
        repeat(customerCount) {
            println("The customer is served...")
        }
        return customerCount
    }

    override fun work() {
        serveCustomers()
    }
}