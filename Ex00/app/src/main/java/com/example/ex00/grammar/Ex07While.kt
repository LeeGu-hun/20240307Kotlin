package com.example.ex00.grammar

import java.util.Scanner

fun main() {
    var i = 0
    while (i < 10) {
        if (i != 0) print(",")
        print(i++)
    }
    println()
    i = 10
    do {
        println(i--)
//        Thread.sleep(1000)
    } while (i > 0)

    var scan = Scanner(System.`in`)
    val randNum: Int = getRandom(1, 100)
    var count = 1
    println(randNum)
    do {
        print("Input Number: ")
        var input = scan.nextInt()
        if (input == randNum) {
            println("$count 번 만에 맞췄습니다")
            break
        } else if (input > randNum) {
            println("큽니다")
        } else if (input < randNum) {
            println("작습니다")
        }
        count++
    } while (true)
}