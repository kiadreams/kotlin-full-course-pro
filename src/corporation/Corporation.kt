package corporation


fun main() {
    val director = Director("Andrey", 25)
    val consultant = Consultant("Max")
    val assistant = Assistant("Helen", age = 20)
    val accountant = Accountant("Christian", age = 30)

    val employees = listOf<Worker>(director, consultant, assistant, accountant)
    for (employee in employees) {
        employee.work()
    }

}