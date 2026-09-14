package cats

class Lion(val countInPride: Int) : CatsFamily() {
    override fun eat() {
        println("I'm eating antelope")
    }
}