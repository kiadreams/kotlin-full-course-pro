package oop.profile

fun main() {

//    val name = readln()
//    print("Input your age: ")
//    val age = readln().toInt()
    val first = Person(name = "John", age = 25, height = 175, weight = 85)
    val second = Person(name = "Ivan", age = 25, height = 175, weight = 85)
    print("Input your name: ")
    println("Name: ${first.name}\nAge: ${first.age}")

    second.sayHello()
    first.sayHello()
    second.run()
}