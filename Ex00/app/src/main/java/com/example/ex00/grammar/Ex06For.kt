package com.example.ex00.grammar

fun main() {
    var sum = 0
    for (i in 1..10) {
        sum += i
    }
    println("sum: $sum")

    val arr:IntArray = intArrayOf(1,2,3,4,5)
    // 배열의 인덱스와 원소를 다룰 때
    for ((i, value) in arr.withIndex()) println("arr[$i] : $value ")

    // 배열의 인덱스를 다룰 때 indices
    for (i in arr.indices) println(i)

    // 배열의 원소만 다룰 때
    for (i in arr) println(i)

}