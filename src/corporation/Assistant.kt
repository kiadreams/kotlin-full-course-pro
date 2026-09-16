package corporation

class Assistant(
    id: Int,
    name: String,
    age: Int,
    salary: Int,
) : Worker(
    id = id,
    name = name,
    age = age,
    salary = salary,
    position = EmployeePosition.ASSISTANT
), Cleaner, Supplier {

    fun bringCoffee(count: Int = 1, typeCoffee: String = "Cappuccino"): String {
        repeat(count) {
            println("Get up")
            println("Go to the coffee machine")
            println("Press the \"$typeCoffee\" button")
            println("Wait for the ${typeCoffee.lowercase()} to be prepared.")
            println("Take coffee")
            println("Bring coffee to the director")
            println("Put coffee on the table")
            println("Return to the workplace")
        }
        return typeCoffee
    }

    override fun clean() {
        println("My position is ${position.title}. I'm cleaning workplace...")
    }

    override fun buyThings() {
        println("My position is ${position.title}. I'm buying things...")
    }

    override fun work() {
        println("I'm answering the phone now...")
    }
}