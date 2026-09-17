package profile

fun main() {

//    val name = readln()
    print("Input your age: ")
    val age = readln().toInt()
    val first = Person(name = "John", lastName = "Felix", height = 175, weight = 85)
    val second = Person(name = "Ivan", lastName = "Fedor", height = 175, weight = 85)
    first.age = age
    second.age = age
    print("Input your name: ")
//    println("Name: ${first.name}\nAge: ${first.age}")

    second.sayHello()
    first.sayHello()
    second.run()
}