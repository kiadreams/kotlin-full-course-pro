package profile

class Person(
    private val name: String,
    var lastName: String,
    private val height: Int,
    private val weight: Int
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
            println("Спрашивать о возрасте не прилично")
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