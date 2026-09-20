package corporation

enum class OperationType(val title: String) {
    EXIT(title = "exit"),
    REGISTER_PRODUCT(title = "register new item"),
    SHOW_ALL_ITEMS(title = "Show all items"),
    REMOVE_PRODUCT_CARD(title = "Remove product card"),
    REGISTER_NEW_EMPLOYEE(title = "Register new employee"),
    FIRE_AN_EMPLOYEE(title = "Fire an employee"),
    SHOW_ALL_EMPLOYEES(title = "Show all employees"),
    CHANGE_SALARY(title = "Change salary"),
    CHANGE_AGE(title = "Change age"),
}