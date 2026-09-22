package exceptions

fun main() {
    try {
        val a = readln().toInt()
        val b = readln().toInt()
        println(a / b)
    } catch (exception: ArithmeticException) {
        println("You can't divide by zero!")
    } catch (exception: NumberFormatException) {
        println("Wrong input!")
    } catch (exception: Throwable) {
        println("Common error!")
    }
    println("After try-catch")

    val valueList = listOf(1, 2, 3, 4, 5)
    try {
        print(valueList[10])
    } catch (e: ArrayIndexOutOfBoundsException) {
        println("Index is out of bounds!")
    }
}