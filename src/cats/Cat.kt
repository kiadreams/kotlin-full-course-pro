package cats

class Cat(val name: String) : CatsFamily(4) {

    fun playWithMouse() {
        println("I'm playing with mouse")
    }

    override fun eat() {
        println("I'm eating whiskas")
    }
}