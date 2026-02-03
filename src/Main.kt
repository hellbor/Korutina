import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    //1
    val job = launch {
        repeat(5) {
            println("Работаю в корутине")
            delay(100L)
        }
    }
    repeat(5) {
        println("Работаю в main")
        delay(100L)
    }

    //2
    val deferredResult = async {
        println("Начало вычислений")
        delay(1000L)
        return@async 10
    }
    println("Корутина запущена")

    val result = deferredResult.await()
    println("Результат: $result")
}