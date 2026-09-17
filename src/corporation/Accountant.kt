package corporation

class Accountant(
    id: Int,
    name: String,
    age: Int,
    salary: Int,
) : Worker(
    id = id,
    name = name,
    age = age,
    salary = salary,
    position = EmployeePosition.ACCOUNTANT
), Cleaner, Supplier {

    private val workersRepository = WorkersRepository()
    private val productsRepository = ProductsRepository()


    override fun work() {
        val operationTypes = OperationType.entries
        while (true) {
            print("Enter the operation code. \n")
            for ((index, operationType) in operationTypes.withIndex()) {
                print("$index - ${operationType.title}\n")
            }
            val operationType = operationTypes[readln().toInt()]
            when (operationType) {
                OperationType.EXIT -> {
                    workersRepository.saveChanges()
                    productsRepository.saveChanges()
                    break
                }

                OperationType.REGISTER_PRODUCT -> registerNewItem()
                OperationType.SHOW_ALL_ITEMS -> showAllItems()
                OperationType.REMOVE_PRODUCT_CARD -> removeProductCard()
                OperationType.REGISTER_NEW_EMPLOYEE -> registerNewEmployee()
                OperationType.FIRE_AN_EMPLOYEE -> fireAnEmployee()
                OperationType.SHOW_ALL_EMPLOYEES -> showAllEmployees()
                OperationType.CHANGE_SALARY -> changeSalary()
            }
        }
    }

    private fun showAllItems() {
        val cards = productsRepository.productCards
        for (card in cards) {
            card.printInfo()
        }
    }

    private fun removeProductCard() {
        print("Enter name of card for removing: ")
        val name = readln()
        productsRepository.removeProductCard(name)
    }

    private fun registerNewItem() {
        val productTypes = ProductType.entries
        print("Enter the product type. ")
        for ((index, type) in productTypes.withIndex()) {
            print("$index - ${type.title}")
            if (index < productTypes.size - 1) {
                print(", ")
            } else {
                print(": ")
            }
        }
        val productTypeIndex = readln().toInt()
        val productType = productTypes[productTypeIndex]
        print("\nEnter the product name: ")
        val name = readln()
        print("\nEnter the brand: ")
        val brand = readln()
        print("\nEnter the price: ")
        val price = readln().toInt()
        val card = when (productType) {
            ProductType.FOOD -> {
                print("\nEnter the caloric: ")
                val caloric = readln().toInt()
                FoodCard(name, brand, price, caloric)
            }

            ProductType.APPLIANCE -> {
                print("\nEnter the wattage: ")
                val wattage = readln().toInt()
                ApplianceCard(name, brand, price, wattage)
            }

            ProductType.SHOE -> {
                print("\nEnter the size: ")
                val size = readln().toFloat()
                ShoeCard(name, brand, price, size)
            }
        }
        productsRepository.registerNewItem(card)
    }

    private fun registerNewEmployee() {
        val employeePositions = EmployeePosition.entries
        print("Choose position - ")
        for ((index, position) in employeePositions.withIndex()) {
            print("$index - ${position.title}")
            when (index) {
                EmployeePosition.entries.size - 1 -> print(": ")
                else -> print(", ")
            }
        }
        val indexOfPosition = readln().toInt()
        print("\nEnter id: ")
        val id = readln().toInt()
        print("\nEnter name: ")
        val name = readln()
        print("\nEnter age: ")
        val age = readln().toInt()
        print("\nEnter salary: ")
        val salary = readln().toInt()
        val employeePosition = employeePositions[indexOfPosition]
        val employee = when (employeePosition) {
            EmployeePosition.DIRECTOR -> Director(id, name, age, salary)
            EmployeePosition.ACCOUNTANT -> Accountant(id, name, age, salary)
            EmployeePosition.ASSISTANT -> Assistant(id, name, age, salary)
            EmployeePosition.CONSULTANT -> Consultant(id, name, age, salary)
        }
        workersRepository.registerNewEmployee(employee)
    }

    private fun fireAnEmployee() {
        print("Enter employee's id to fire: ")
        val id = readln().toInt()
        workersRepository.fireAnEmployee(id)
    }

    private fun showAllEmployees() {
        val employees = workersRepository.workers
        for (employee in employees) {
            employee.printInfo()
        }
    }

    private fun changeSalary() {
        print("Enter employee's id to change salary: ")
        val id = readln().toInt()
        print("Enter new salary: ")
        val newSalary = readln().toInt()
        workersRepository.changeSalary(id, newSalary)
    }

    override fun clean() {
        println("My position is ${position.title}. I'm cleaning workplace...")
    }

    override fun buyThings() {
        println("My position is ${position.title}. I'm buying things...")
    }
}