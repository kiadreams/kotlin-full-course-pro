package corporation


fun main() {
    val workersRepository = WorkersRepository
    val workers = workersRepository.workers
    for (worker in workers) {
        worker.work()
    }
    val a: Any = 1
}