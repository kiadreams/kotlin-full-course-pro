package profile

data class Person(
    val name: String,
    val lastName: String,
    val height: Int,
    val weight: Int
) {

    val fullName: String
        get() = "$name $lastName"

    var age: Int = 0
        set(value) {
            if (value > field) {
                field = value
            } else {
                println("The new age must be great")
            }
        }
        get() {
            println("It is indecent to ask a person his age")
            return field
        }

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