package corporation

abstract class Worker(
    val id: Int,
    val name: String,
    val age: Int = 0,
    val position: EmployeePosition
) {

    abstract fun work()

    fun printInfo() {
        print(this)
    }

    override fun toString(): String {
        return "Id: $id, Name: $name, Age: $age, Position: ${position.title}\n"
    }
}