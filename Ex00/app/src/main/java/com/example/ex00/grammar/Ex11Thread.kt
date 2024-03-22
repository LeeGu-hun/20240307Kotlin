package com.example.ex00.grammar
import java.util.Scanner

class Bomb : Thread() {
    val life = getRandom(0,1)
    override fun run() {
        for (i in 10 downTo (1) step (1)) {
            println(i)
            Thread.sleep(1000)
        }
        println("Bomb!!!")
    }
}

fun main() {
    val scan = Scanner(System.`in`)

    val bomb = Bomb()
    bomb.start()
    println("빨간선(0), 파란선(1) 중에 선택하세요")
    var input = scan.nextInt()

}