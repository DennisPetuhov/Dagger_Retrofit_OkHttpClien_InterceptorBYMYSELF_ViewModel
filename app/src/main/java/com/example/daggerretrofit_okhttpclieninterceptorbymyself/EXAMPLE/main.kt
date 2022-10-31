package com.example.daggerretrofit_okhttpclieninterceptorbymyself.EXAMPLE

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

fun getUsers()= flow<String> {
    for (i in 1..5 ){
        delay(400)
        emit(i.toString())

    }
}
suspend fun getUsers1(): List<String> {
    val a= mutableListOf<String>()
    for (i in 1..5 ){
        delay(400)
        a.add(i.toString())

    }
    return a
}
 suspend fun main() {
     GlobalScope.launch {
         delay(500)
         println("Hello World")
     }
//getUsers().drop(2).take(2).collect{ println(it)}
//     getUsers1().asFlow().collect{println(it)}
//     val userFlow = flowOf("Tom", "Sam", "Bob")
//     var userfloff =flow{
//         emit(1)
//         delay(400)
//         emit(2)
//         delay(400)
//         emit(3)
//         delay(400)
//         emit(4)
//     }
//     userfloff.collect{println(it)}



}