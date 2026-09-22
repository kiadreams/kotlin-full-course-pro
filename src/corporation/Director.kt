package corporation

data class Director(
    override val id: Int,
    override val name: String,
    override val age: Int,
    override val salary: Int,
) : Worker(
    id = id,
    name = name,
    age = age,
    salary = salary,
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

    override fun copy(
        id: Int,
        name: String,
        age: Int,
        salary: Int,
        position: EmployeePosition
    ): Worker {
        return copy(id = id, name = name, age = age, salary = salary)
    }

    override fun work() {
        println("I'm drinking coffee...")
    }

    override fun buyThings() {
        println("My position is ${position.title}. I'm buying things...")
    }
}