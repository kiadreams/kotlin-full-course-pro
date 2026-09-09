package oop.corporation

class Director(
    name: String,
    age: Int
) : Worker(name = name, age = age) {
    fun takeCoffee(assistant: Assistant) {
        val typeCoffee = assistant.bringCoffee()
        println("Thank you ${assistant.name}! The $typeCoffee was vary tasty :)")
    }

    fun getConsultantToWork(consultant: Consultant) {
        val customerCount = consultant.serveCustomers()
        println("The consultant ${consultant.name} served $customerCount customers.")

    }

    override fun work() {
        println("I'm drinking coffee...")
    }
}