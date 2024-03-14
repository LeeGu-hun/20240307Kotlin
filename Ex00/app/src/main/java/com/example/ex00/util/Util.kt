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
fun getRand(d1: Int, d2: Int): Int {
    var result = (Math.random() * d2).toInt()
    if (d1 != 0) result = result + 1
    return result
}

fun listPrint(list: List<Any>): Unit {
    print("[")
    for (i in 0..list.size - 1) {
        if (i!=0) print(",")
        print(list.get(i))
    }
    println("]")
}