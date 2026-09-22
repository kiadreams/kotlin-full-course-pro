package corporation

import java.io.File


object WorkersRepository {

    private val fileWorkers = File("workers.txt")
    private val _workers = loadAllEmployees()
    val workers
        get() = _workers.toList()

    private fun loadAllEmployees(): MutableSet<Worker> {
        println("Loading all employees...")
        val employees = mutableSetOf<Worker>()
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
        _workers.removeIf { it.id == id }
    }

    fun registerNewEmployee(employee: Worker) {
        _workers.add(employee)
    }

    fun findAssistant(): Assistant? {
        val worker = _workers.find { it is Assistant }
        return worker as? Assistant
    }

    fun findDirector(): Director? {
        val worker = _workers.find { it is Director }
        return worker as? Director
    }

    fun changeSalary(id: Int, newSalary: Int) {
        for (worker in _workers) {
            if (worker.id == id) {
                val newWorker = worker.copy(salary = newSalary)
                _workers.remove(worker)
                _workers.add(newWorker)
                break
            }
        }
    }

    fun changeAge(id: Int, newAge: Int) {
        for (worker in _workers) {
            if (worker.id == id) {
                val newWorker = worker.copy(age = newAge)
                _workers.remove(worker)
                _workers.add(newWorker)
                break
            }
        }
    }

    fun saveChanges() {
        val content = StringBuilder()
        _workers.forEach {
            val workerAsText = "${it.id}%${it.name}%${it.age}%${it.salary}%${it.position}\n"
            content.append(workerAsText)
        }
        fileWorkers.writeText(content.toString())
    }
}