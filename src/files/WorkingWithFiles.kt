package files

import java.io.File

fun main() {
    val file = File("test.txt")
//    file.appendText(" Hello World  ")
//    file.appendText(" \n" + "Hi, I'm Igor  ")
    val text = file.readText().trim().split("\n")
    println(text + text.size)
}