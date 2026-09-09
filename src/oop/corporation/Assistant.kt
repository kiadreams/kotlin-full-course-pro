package oop.corporation

class Assistant(name: String, age: Int = 0) : Worker(name = name, age = age) {

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

    override fun work() {
        println("I'm answering the phone now...")
    }
}