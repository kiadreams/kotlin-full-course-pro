package corporation

import kotlin.random.Random

class Consultant(
    id: Int,
    name: String,
    age: Int = 0
) : Worker(id = id, name = name, age = age, position = EmployeePosition.CONSULTANT) {
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