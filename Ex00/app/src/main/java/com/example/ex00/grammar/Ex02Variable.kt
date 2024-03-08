package com.example.ex00.grammar

import com.example.ex00.util.typePrint

var name: String = "LGH"

var name1 = "Thor" // 동적 할당, 타입 유추

var num: Int = 10

fun main() {
    var num2: Int
    num2 = 10
    num = 200
//    num = true
    var num3 = true
    println(name1)
    println(name1::class.simpleName)
    typePrint(name1)
    typePrint(num3)
    num3 = false
    val num4 = 100
//    num4 = 200  //val은 상수 선언시
//    num5:Int = 10 //변수선언시 var 적용
    var l1: Long = 1000
    var i1: Int = 1000
    var f1: Float = 0.1f
    var d1: Double = 0.0
    var b1: Byte = 100
    var s1: Short = 100
    var c1: Char = ' ' // '\u0000'
    var b: Boolean = true

    var ub: UByte = 10u
    var us: UShort = 10u
    var uint:UInt = 1000u
    var ul:ULong = 1000u
    println("UByte: ${UByte.MIN_VALUE}~${UByte.MAX_VALUE}")
    println("UShort: ${UShort.MIN_VALUE}~${UShort.MAX_VALUE}")
    println("UInt: ${UInt.MIN_VALUE}~${UInt.MAX_VALUE}")
    println("ULong: ${ULong.MIN_VALUE}~${ULong.MAX_VALUE}")

}
