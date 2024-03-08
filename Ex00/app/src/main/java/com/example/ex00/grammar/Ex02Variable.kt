package com.example.ex00.grammar

import com.example.ex00.util.typePrint

var name: String = "LGH"

var name1 = "Thor" // 동적 할당, 타입 유추

fun main() {
    println(name1)
    println(name1::class.simpleName)
    typePrint(name1)
}
