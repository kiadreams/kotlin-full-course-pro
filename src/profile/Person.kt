package profile

class Person(
    val name: String, val age: Int, val height: Int, val weight: Int
) {

    fun sayHello() {
        println("Hello, my name is $name")
    }

    fun printInfo() {
        println("Name: $name, Age: $age, Height: $height, Weight: $weight")
    }

    fun run() {
        repeat(10) {
            println("Running...")
        }
        print("\n")
    }

}