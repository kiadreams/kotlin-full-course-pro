package corporation

import java.io.File

class Accountant(
    id: Int,
    name: String,
    age: Int
) : Worker(
    id = id,
    name = name,
    age = age,
    position = EmployeePosition.ACCOUNTANT
), Cleaner, Supplier {


    private val fileProductCards = File("product_cards.txt")
    private val fileWorkers = File("workers.txt")

    override fun work() {
        val operationTypes = OperationType.entries
        while (true) {
            print("Enter the operation code. \n")
            for ((index, operationType) in operationTypes.withIndex()) {
                print("$index - ${operationType.title}\n")
            }
            val operationType = operationTypes[readln().toInt()]
            when (operationType) {
                OperationType.EXIT -> break
                OperationType.REGISTER_PRODUCT -> registerNewItem()
                OperationType.SHOW_ALL_ITEMS -> showAllItems()
                OperationType.REMOVE_PRODUCT_CARD -> removeProductCard()
                OperationType.REGISTER_NEW_EMPLOYEE -> registerNewEmployee()
                OperationType.FIRE_AN_EMPLOYEE -> fireAnEmployee()
                OperationType.SHOW_ALL_EMPLOYEES -> showAllEmployees()
            }
        }
    }

    private fun showAllItems() {
        val cards = loadAllCards()
        for (card in cards) {
            card.printInfo()
        }
    }

    private fun removeProductCard() {
        val cards = loadAllCards()
        print("Enter name of card for removing: ")
        val name = readln()
        for ((index, card) in cards.withIndex()) {
            if (card.name == name) {
                cards.removeAt(index)
                break
            }
        }
        fileProductCards.writeText("")
        for (card in cards) {
            saveProductCardToFile(card)
        }
    }

    private fun saveProductCardToFile(productCard: ProductCard) {
        fileProductCards.appendText("${productCard.name}%${productCard.brand}%${productCard.price}%")
        when (productCard) {
            is FoodCard -> fileProductCards.appendText("${productCard.caloric}%")
            is ApplianceCard -> fileProductCards.appendText("${productCard.wattage}%")
            is ShoeCard -> fileProductCards.appendText("${productCard.size}%")
        }
        fileProductCards.appendText("${productCard.productType}\n")
    }

    private fun loadAllCards(): MutableList<ProductCard> {
        val cards = mutableListOf<ProductCard>()
        if (!fileProductCards.exists()) fileProductCards.createNewFile()
        for (line in fileProductCards.readLines()) {
            val productData = line.trim().split("%")
            val productType = ProductType.valueOf(productData.last())
            val name = productData[0]
            val brand = productData[1]
            val price = productData[2].toInt()
            val productCard = when (productType) {
                ProductType.FOOD -> {
                    val caloric = productData[3].toInt()
                    FoodCard(name, brand, price, caloric)
                }

                ProductType.APPLIANCE -> {
                    val wattage = productData[3].toInt()
                    ApplianceCard(name, brand, price, wattage)
                }

                ProductType.SHOE -> {
                    val size = productData[3].toFloat()
                    ShoeCard(name, brand, price, size)
                }
            }
            cards.add(productCard)
        }
        return cards
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
        saveProductCardToFile(card)
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
        val employeePosition = employeePositions[indexOfPosition]
        val employee = when (employeePosition) {
            EmployeePosition.DIRECTOR -> Director(id, name, age)
            EmployeePosition.ACCOUNTANT -> Accountant(id, name, age)
            EmployeePosition.ASSISTANT -> Assistant(id, name, age)
            EmployeePosition.CONSULTANT -> Consultant(id, name, age)
        }
        saveEmployeeToFile(employee)
    }

    private fun saveEmployeeToFile(worker: Worker) {
        fileWorkers.appendText("${worker.id}%${worker.name}%${worker.age}%${worker.position}\n")
    }

    fun loadAllEmployees(): MutableList<Worker> {
        val employees = mutableListOf<Worker>()
        if (!fileWorkers.exists()) fileWorkers.createNewFile()
        for (line in fileWorkers.readLines()) {
            val employeeData = line.trim().split("%")
            val id = employeeData[0].toInt()
            val name = employeeData[1]
            val age = employeeData[2].toInt()
            val position = EmployeePosition.valueOf(employeeData.last())
            when (position) {
                EmployeePosition.DIRECTOR -> employees.add(Director(id, name, age))
                EmployeePosition.ACCOUNTANT -> employees.add(Accountant(id, name, age))
                EmployeePosition.ASSISTANT -> employees.add(Assistant(id, name, age))
                EmployeePosition.CONSULTANT -> employees.add(Consultant(id, name, age))
            }
        }
        return employees
    }

    private fun fireAnEmployee() {
        val employees = loadAllEmployees()
        print("Enter employee's id to fire: ")
        val id = readln().toInt()
        employees.removeIf { it.id == id }
        fileWorkers.writeText("")
        employees.forEach { saveEmployeeToFile(it) }
    }

    private fun showAllEmployees() {
        val employees = loadAllEmployees()
        for (employee in employees) {
            employee.printInfo()
        }
    }

    override fun clean() {
        println("My position is ${position.title}. I'm cleaning workplace...")
    }

    override fun buyThings() {
        println("My position is ${position.title}. I'm buying things...")
    }
}