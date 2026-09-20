package corporation

import java.io.File


object ProductsRepository {

    private val fileProductCards = File("product_cards.txt")
    private val _productCards = loadAllCards()
    val productCards
        get() = _productCards.toList()


    fun loadAllCards(): MutableList<ProductCard> {
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

    fun removeProductCard(name: String) {
        _productCards.removeIf { it.name == name }
    }

    fun registerNewItem(productCard: ProductCard) {
        _productCards.add(productCard)
    }

    fun saveChanges() {
        val content = StringBuilder()
        for (card in _productCards) {
            content.append("${card.name}%${card.brand}%${card.price}%")
            when (card) {
                is FoodCard -> fileProductCards.appendText("${card.caloric}%")
                is ApplianceCard -> fileProductCards.appendText("${card.wattage}%")
                is ShoeCard -> fileProductCards.appendText("${card.size}%")
            }
            fileProductCards.appendText("${card.productType}\n")
        }
        fileProductCards.writeText(content.toString())
    }
}