package corporation

import kotlin.random.Random

data class Consultant(
    override val id: Int,
    override val name: String,
    override val age: Int = 0,
    override val salary: Int = 0,
) : Worker(
    id = id,
    name = name,
    age = age,
    salary = salary,
    position = EmployeePosition.CONSULTANT
), Cleaner {
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

    override fun copy(salary: Int, age: Int): Consultant {
        return Consultant(this.id, this.name, age, salary)
    }

    override fun work() {
        serveCustomers()
    }

    override fun clean() {
        println("My position is ${position.title}. I'm cleaning workplace...")
    }
}