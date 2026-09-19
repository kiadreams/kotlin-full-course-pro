package corporation


fun main() {
    val workersRepository = WorkersRepository
    val workers = workersRepository.workers
    workers.forEach { it.work() }
}