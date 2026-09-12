package corporation

enum class OperationType(val title: String) {
    EXIT(title = "exit"),
    REGISTER_PRODUCT(title = "register new item"),
    SHOW_ALL_ITEMS(title = "Show all items"),
    REMOVE_PRODUCT_CARD(title = "Remove product card"),
}