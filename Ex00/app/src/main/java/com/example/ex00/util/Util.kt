package com.example.ex00.util

fun typePrintOld(x: Any) {
    println("type: ${x::class.simpleName}")
}
fun typePrint(x: Any?) {
    if (x == null) {
        println("type: null")
    } else {
        println("type: ${x::class.simpleName}")
    }
}