package homework

data class Order(
    val id: Int,
    val status: String,
    val type: String
)

fun removeCompletedOrders(orders: List<Order>, typeToRemove: String): List<Order> {
    val totalOrders = mutableListOf<Order>()
    for (order in orders) {
        if (order.type != typeToRemove || order.status != "completed") totalOrders.add(order)
    }
    return totalOrders
}

fun main() {

}