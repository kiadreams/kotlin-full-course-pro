package corporation

abstract class Worker(
    open val id: Int,
    open val name: String,
    open val age: Int,
    open val salary: Int,
    val position: EmployeePosition
) {

    abstract fun copy(
        id: Int = this.id,
        name: String = this.name,
        age: Int = this.age,
        salary: Int = this.salary,
        position: EmployeePosition = this.position
    ): Worker

    abstract fun work()

    fun printInfo() {
        println(this)
    }
}