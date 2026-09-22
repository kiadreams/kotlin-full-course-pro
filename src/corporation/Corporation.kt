package corporation


fun main() {
    val director = WorkersRepository.findDirector() ?: throwDirectorIsRequired()
    director.printInfo()
}

fun throwDirectorIsRequired(): Nothing {
    throw Exception("Director is required fot this program. Please add it to the file workers.txt")
}