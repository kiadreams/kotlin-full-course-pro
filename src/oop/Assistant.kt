package oop

class Assistant {

    fun bringCoffee(count: Int, typeCoffee: String) {
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
    }
}