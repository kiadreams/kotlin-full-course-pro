package corporation

abstract class Worker(
    val id: Int,
    val name: String,
    val age: Int,
    private var salary: Int,
    val position: EmployeePosition
) {

    fun getSalary() = this.salary
    fun setSalary(salary: Int) {
        if (salary < this.salary) {
            println("The new salary is too small...")
        } else {
            this.salary = salary
        }
    }

    abstract fun work()

    fun printInfo() {
        print(this)
    }

    override fun toString(): String {
        return "Id: $id, Name: $name, Age: $age, Position: ${position.title}, Salary: ${salary}\n"
    }
}