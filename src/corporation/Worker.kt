package corporation

abstract class Worker(
    val id: Int,
    val name: String,
    val age: Int,
    val salary: Int,
    val position: EmployeePosition
) {

    abstract fun copy(salary: Int = this.salary, age: Int = this.age): Worker

    abstract fun work()

    fun printInfo() {
        print(this)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Worker) return false
        return id == other.id
                && name == other.name
                && age == other.age
                && salary == other.salary
                && position == other.position
    }

    override fun toString(): String {
        return "Id: $id, Name: $name, Age: $age, Position: ${position.title}, Salary: ${salary}\n"
    }
}