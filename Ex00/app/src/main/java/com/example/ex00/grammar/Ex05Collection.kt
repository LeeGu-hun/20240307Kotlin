package com.example.ex00.grammar

// 1.배열을 전역으로 선언할 때
// 1) 선언만 할 때
// var arr0: Array<Int> // 에러 발생
lateinit var arr0: Array<Int> // lateinit으로 선언만 가능
// arr0 = Array(3, {0}) //에러 발생 연산이 단독으로 진행 안됨

// 2) 할당(선언과 초기화) 할 때
val arr01: Array<Int> = Array(3, {0})
var arr02: Array<Int> = arrayOf<Int>(1,2,3,4,5)


fun main() {
    //1. 배열 선언 하기
    // 1) 선언과 동시에 배열전체를 같은 원소로 초기화
    val arr1: Array<Int> = Array(3, {0})
    println(arr1.contentToString())

    // 2) 선언과 동시에 원소별로 초기화
    var arr2: Array<Int> = arrayOf<Int>(1,2,3,4,5)
    println(arr2.contentToString())

    // 3) 배열의 선언과 초기화 각각 진행
    var arr3: Array<Int>  // 선언
    arr3 = arrayOf<Int>(1,2,3) // 초기화

    // 4) 빈배열 선언
    var arr4: Array<Int?> = arrayOfNulls<Int>(5)
    println(arr4.contentToString())
    var arr5 = arrayOfNulls<Int>(5)

    // 2. 배열 다루기
    var arr11: Array<Int> = arrayOf(1,2,3,4,5)

    arr11.fill(1)
    println(arr11.contentToString())

    arr11.set(2, 10)
    println(arr11.contentToString())

    val arr12 = arrayOf(10,33,21,52,27)
    println("최대값: ${arr12.max()}")
    println("최소값: ${arr12.min()}")
    println("최대값: ${arr12.maxOrNull()}")
    println("최소값: ${arr12.minOrNull()}")
    println(arr12.first())
    println(arr12.last())

    var arr12Temp = arr12.sorted()
    println(arr12Temp.toTypedArray().contentToString())
    arr12Temp = arr12.sortedDescending()
    println(arr12Temp.toTypedArray().contentToString())
    println(arr12Temp.first())
    println(arr12Temp.last())

}



