package com.example.daggerretrofit_okhttpclieninterceptorbymyself.EXAMPLE

import kotlinx.coroutines.*

suspend fun doWork(){
    for (i in 1..5){
        delay(400)
        println(i)
    }

}




suspend fun main() = coroutineScope{

    // создаем и запускаем корутину
    val message = async {
        getMessage()
    }
    // отмена корутины
  //  message.cancelAndJoin()

    try {
        // ожидаем получение результата
        println("message: ${message.await()}")
    }
    catch (e:CancellationException){
        println("Coroutine has been canceled")
    }
    println("Program has finished")
}

suspend fun getMessage() : String{
    delay(500L)
    return "Hello"
}



