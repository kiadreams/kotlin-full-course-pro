package corporation

import java.io.File

class Accountant(
    name: String,
    age: Int
) : Worker(name, age) {


    val items = mutableListOf<ProductCard>()
    val file = File("product_cards.txt")

    override fun work() {
        val operationTypes = OperationType.entries
        while (true) {
            print("Enter the operation code. ")
            for ((index, operationType) in operationTypes.withIndex()) {
                print("$index - ${operationType.title}")
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
                OperationType.SHOW_ALL_ITEMS -> showAllItems()
            }
        }
    }

    fun showAllItems() {
        for (line in file.readLines()) {
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
            productCard.printInfo()
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
        file.appendText("$name%")
        print("\nEnter the brand: ")
        val brand = readln()
        file.appendText("$brand%")
        print("\nEnter the price: ")
        val price = readln().toInt()
        file.appendText("$price%")
        val productCard = when (productType) {
            ProductType.FOOD -> {
                print("\nEnter the caloric: ")
                val caloric = readln().toInt()
                file.appendText("$caloric")
            }

            ProductType.APPLIANCE -> {
                print("\nEnter the wattage: ")
                val wattage = readln().toInt()
                file.appendText("$wattage")
            }

            ProductType.SHOE -> {
                print("\nEnter the size: ")
                val size = readln().toInt()
                file.appendText("$size")
            }
        }
        file.appendText("%$productType\n")
    }
}