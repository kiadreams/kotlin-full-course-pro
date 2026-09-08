package oop.corporation


fun main() {
    val director = Director("Andrey", 25)
    val consultant = Consultant("Max")
    val assistant = Assistant("Helen", age = 20)
    director.getConsultantToWork(consultant)
    director.takeCoffee(assistant)
}