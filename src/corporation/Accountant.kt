package corporation

import java.io.File

class Accountant(
    name: String,
    age: Int
) : Worker(name, age) {


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
                OperationType.REMOVE_PRODUCT_CARD -> removeProductCard()
            }
        }
    }

    fun showAllItems() {
        val cards = loadAllCards()
        for (card in cards) {
            card.printInfo()
        }
    }

    fun removeProductCard() {
        val cards = loadAllCards()
        print("Enter name of card for removing: ")
        val name = readln()
        for ((index, card) in cards.withIndex()) {
            if (card.name == name) {
                cards.removeAt(index)
                break
            }
        }
        file.writeText("")
        for (card in cards) {
            saveProductCardToFile(card)
        }
    }

    fun saveProductCardToFile(productCard: ProductCard) {
        file.appendText("${productCard.name}%${productCard.brand}%${productCard.price}%")
        when (productCard) {
            is FoodCard -> file.appendText("${productCard.caloric}%")
            is ApplianceCard -> file.appendText("${productCard.wattage}%")
            is ShoeCard -> file.appendText("${productCard.size}%")
        }
        file.appendText("${productCard.productType}\n")
    }

    fun loadAllCards(): MutableList<ProductCard> {
        val cards = mutableListOf<ProductCard>()
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
            cards.add(productCard)
        }
        return cards
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
}