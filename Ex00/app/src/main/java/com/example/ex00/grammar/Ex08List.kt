package com.example.ex00.grammar

import com.example.ex00.util.getRand
import com.example.ex00.util.listPrint

// List 순서가 있음. 중복은 허용
// List , MutableList

//1. List : 불변
var list:List<Int> = listOf(10,20,30)
fun main() {
    var list:List<Int> = listOf(40,50,60)
    println("0번째 ${list[0]}")

//    list는 추가와 수정 안됨 :: 불변
//    list[0] = 100
//    list.add(70)

    // 원소에 직접 접근 출력
    println("list: $list")
    for (i in list) print(i);println()
    for (i in list.toTypedArray()) print(i);println()

    // 인덱스로 원소에 접근하여 출력
    for (i in 0..list.size-1) print(list.get(i));println()
    for (i in list.indices) print(list.get(i));println()

    // 인덱스와 원소를 동시에 접근하여 출력
    for ((idx, num) in list.withIndex()) println("index: $idx / number: $num")

    println(list.toTypedArray().contentToString())
    listPrint(list)

    val list1 = listOf(10, 33, 21, 55, 24)
    println("max: ${list1.max()}")
    println("min: ${list1.min()}")
    println("sort: ${list1.sorted()}")

    var lotto = mutableListOf<Int>()
    while (lotto.size < 6) {
        val ball = getRand(1, 45)
        var dupli: Boolean = false
        for (i in lotto) {
            if(i == ball){
                dupli = true; break
            }
        }
        if (!dupli) lotto.add(ball)
    }
    println("로또 번호: $lotto")
}









