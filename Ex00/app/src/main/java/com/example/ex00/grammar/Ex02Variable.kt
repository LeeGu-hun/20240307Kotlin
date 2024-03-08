package com.example.ex00.grammar

import com.example.ex00.util.typePrint

//var n5: Int
//n5 = 10  // 대입연산자가 단독으로 함수밖에서 사용 불가
var name: String = "LGH"
var name1 = "Thor" // 동적 할당, 타입 유추
var num: Int = 10

//lateinit var data2: Int//lateinit은 Byte,Short,Int,Long,Float,Double사용 안됨
lateinit var data3: String

// lazy는 변수가 사용되는 시점에 초기화
val data4: Int by lazy {
    println("lazy...")
    100
}

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
    var b: Boolean = true
    var c1: Char = ' ' // '\u0000'

    var b1: Byte = 100
    var s1: Short = 100
    var i1: Int = 1000
    var l1: Long = 1000
    println("Byte: ${Byte.MIN_VALUE}~${Byte.MAX_VALUE}")
    println("Int: ${Int.MIN_VALUE}~${Int.MAX_VALUE}")
    println("Short: ${Short.MIN_VALUE}~${Short.MAX_VALUE}")
    println("Long: ${Long.MIN_VALUE}~${Long.MAX_VALUE}")

    var f1: Float = 0.1f
    var d1: Double = 0.0
    println("Float: ${Float.MIN_VALUE}~${Float.MAX_VALUE}")
    println("Double: ${Double.MIN_VALUE}~${Double.MAX_VALUE}")

    var ub: UByte = 10u
    var us: UShort = 10u
    var uint:UInt = 1000u
    var ul:ULong = 1000u
    println("UByte: ${UByte.MIN_VALUE}~${UByte.MAX_VALUE}")
    println("UShort: ${UShort.MIN_VALUE}~${UShort.MAX_VALUE}")
    println("UInt: ${UInt.MIN_VALUE}~${UInt.MAX_VALUE}")
    println("ULong: ${ULong.MIN_VALUE}~${ULong.MAX_VALUE}")

    var sum = b1 + s1 // 연산시 4byte단위인 Int로 형변환
    typePrint(sum) //Int

    var realSum = f1 + d1 // 표현범위가 큰 쪽으로 형변환
    typePrint(realSum)

    var floatSum = f1 + l1  // 표현범위가 큰 쪽으로 형변환
    typePrint(floatSum)

    data3 = "late initiate"
    println(data4)
}
