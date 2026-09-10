package oop.corporation

class Accountant(
    name: String,
    age: Int
) : Worker(name, age) {

    override fun work() {
        val operationTypes = OperationType.entries
        while (true) {
            print("Enter the operation code. ")
            for ((index, operationType) in operationTypes.withIndex()) {
                print("$index - ${operationType.operationName}")
                if (index < operationTypes.size - 1) {
                    print(", ")
                } else {
                    print(": ")
                }
            }
            val operationType = operationTypes[readln().toInt()]
            when (operationType) {
                OperationType.EXIT -> break
                OperationType.REGISTER_PRODUCT -> registerNewItem()
            }
        }
    }

    fun registerNewItem() {
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
        val productCard = when (productType) {
            ProductType.FOOD -> {
                print("\nEnter the caloric: ")
                FoodCard(name = name, brand = brand, price = price, caloric = readln().toInt())
            }
            ProductType.APPLIANCE -> {
                print("\nEnter the wattage: ")
                ApplianceCard(name = name, brand = brand, price = price, wattage = readln().toInt())
            }
            ProductType.SHOE -> {
                print("\nEnter the size: ")
                ShoeCard(name = name, brand = brand, price = price, size = readln().toFloat())
            }
        }
        productCard.printInfo()
    }
}