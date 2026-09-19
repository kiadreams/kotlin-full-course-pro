package corporation

import java.io.File


object WorkersRepository {

    private val fileWorkers = File("workers.txt")
    val workers = loadAllEmployees()

    private fun loadAllEmployees(): MutableList<Worker> {
        println("Loading all employees...")
        val employees = mutableListOf<Worker>()
        if (!fileWorkers.exists()) fileWorkers.createNewFile()
        for (line in fileWorkers.readLines()) {
            val employeeData = line.trim().split("%")
            val id = employeeData[0].toInt()
            val name = employeeData[1]
            val age = employeeData[2].toInt()
            val salary = employeeData[3].toInt()
            val position = EmployeePosition.valueOf(employeeData.last())
            val employee = when (position) {
                EmployeePosition.DIRECTOR -> Director(id, name, age, salary)
                EmployeePosition.ACCOUNTANT -> Accountant(id, name, age, salary)
                EmployeePosition.ASSISTANT -> Assistant(id, name, age, salary)
                EmployeePosition.CONSULTANT -> Consultant(id, name, age, salary)
            }
            employees.add(employee)
        }
        return employees
    }

    fun fireAnEmployee(id: Int) {
        workers.removeIf { it.id == id }
    }

    fun registerNewEmployee(employee: Worker) {
        workers.add(employee)
    }

    fun changeSalary(id: Int, newSalary: Int) {
        workers.forEach {
            if (it.id == id) {
                it.setSalary(newSalary)
            }
        }
    }

    fun saveChanges() {
        val content = StringBuilder()
        workers.forEach {
            val workerAsText = "${it.id}%${it.name}%${it.age}%${it.getSalary()}%${it.position}\n"
            content.append(workerAsText)
        }
        fileWorkers.writeText(content.toString())
    }
}