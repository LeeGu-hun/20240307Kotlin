package com.example.ex00.grammar

fun main() {
    println(getRandom(1, 100))
    println(getSum(10, 1))
}

fun getRandom(d1: Int, d2: Int): Int {
    var result = (Math.random() * d2).toInt()
    if (d1 != 0) result = result + 1
    return result
}

fun getSum(x: Int, y: Int): Int {
    var k = x
    var l = y
    if(x>y) {
        k = y
        l = x
    }
    var sum = 0;
    for (i in k..l) sum += i
    return sum
}


