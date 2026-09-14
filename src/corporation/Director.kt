package corporation

class Director(
    id: Int,
    name: String,
    age: Int
) : Worker(
    id = id,
    name = name,
    age = age,
    position = EmployeePosition.DIRECTOR
), Supplier {
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

    override fun buyThings() {
        println("My position is ${position.title}. I'm buying things...")
    }
}