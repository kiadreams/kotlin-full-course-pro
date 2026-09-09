package oop.corporation

class Accountant(
    name: String,
    age: Int
) : Worker(name, age) {

    override fun work() {
        while (true) {
            print("Enter the operation code. 0 - exit, 1 - register new item: ")
            when (readln().toInt()) {
                0 -> break
                1 -> print("\nEnter the product type. 0 - Food, 1 - Appliance, 2 - Shoe: ")
            }
            val productType = readln().toInt()
            createProductCard(productType)
        }
    }

    fun createProductCard(productType: Int) {
        print("\nEnter the product name: ")
        val name = readln()
        print("\nEnter the brand: ")
        val brand = readln()
        print("\nEnter the price: ")
        val price = readln().toInt()
        val productCard = when (productType) {
            0 -> {
                print("\nEnter the caloric: ")
                FoodCard(name = name, brand = brand, price = price, caloric = readln().toInt())
            }

            1 -> {
                print("\nEnter the wattage: ")
                ApplianceCard(name = name, brand = brand, price = price, wattage = readln().toInt())
            }

            else -> {
                print("\nEnter the size: ")
                ShoeCard(name = name, brand = brand, price = price, size = readln().toFloat())
            }
        }
        productCard.printInfo()
    }
}