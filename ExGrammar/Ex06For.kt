package com.example.ex00.grammar

fun main() {
    // 미만일 때 0~9
    for (i in 0 until (10)) {
        println(i)
    }

    // 포함일 때
    for (i in 1..9) {
        println(i)
    }

    // step 증가
    for (i in 1..10 step (3)) {
        println(i)
    }

    // 감소할 때
    for (i in 10 downTo (1) step (1)) {
        println(i)
    }

    var sum = 0
    for (i in 1..10) {
        sum += i
    }
    println("sum: $sum")

    val arr:IntArray = intArrayOf(1,2,3,4,5)
    // 배열의 인덱스와 원소를 다룰 때
    for ((i, value) in arr.withIndex()) println(" arr[$i] : $value ")
    for (i in 0..arr.size) println(" 인덱스 : $i / 값 : arr[$i] ")

    // 배열의 인덱스를 다룰 때 indices
    for (i in arr.indices) println(i)

    // 배열의 원소만 다룰 때
    for (i in arr) println(i)
}



