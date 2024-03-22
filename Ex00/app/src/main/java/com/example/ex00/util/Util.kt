package com.example.ex00.util

import java.util.Scanner
//import javax.swing.JOptionPane

class Bomb : Thread() {
    val life = getRand(0, 1)
    var stopped = false

    override fun run() {
        for (i in 10 downTo (1) step (1)) {
            if (stopped) break
            println(i)
            Thread.sleep(1000)
        }
    }

    fun choice(line: Int) {
        stopped = true
        if (line == life) {
            println("살았다")
        } else {
            println("꽥 bomb~~~!")
        }
    }
}

fun getRand(d1: Int, d2: Int): Int {
    var result = (Math.random() * d2).toInt()
    if (d1 != 0) result = result + 1
    return result
}

fun main() {
    val bomb = Bomb()
    bomb.start()
    val scan = Scanner(System.`in`)
    println("빨간선(0), 파란선(1) 중에 선택하세요")
    var input = scan.nextInt()
//    val input = JOptionPane.showInputDialog("빨간선(0)과 파란선(1)중에 선택하세요").toInt()
    bomb.choice(input)
}