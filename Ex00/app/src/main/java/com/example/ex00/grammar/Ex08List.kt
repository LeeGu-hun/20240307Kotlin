package com.example.ex00.grammar

import com.example.ex00.util.getRand
import com.example.ex00.util.listPrint
import java.util.LinkedList
import java.util.Stack

// List 순서가 있음. 중복은 허용
// List , MutableList


var list: List<Int> = listOf(10, 20, 30)
fun main() {
    //1. List : 불변
//    val list1 = List<Any>() //에러 발생 List는 interface
    var list: List<Any> = listOf(40, 50, 60, "hello")
    println("0번째 ${list[0]}")

//    list는 추가와 수정 안됨 :: 불변
//    list[0] = 100
//    list.add(70)

    // 원소에 직접 접근 출력
    println("list: $list")
    for (i in list) print(i);println()
    for (i in list.toTypedArray()) print(i);println()

    // 인덱스로 원소에 접근하여 출력
    for (i in 0..list.size - 1) print(list.get(i));println()
    for (i in list.indices) print(list.get(i));println()

    // 인덱스와 원소를 동시에 접근하여 출력
    for ((idx, num) in list.withIndex()) println("index: $idx / number: $num")

    println(list.toTypedArray().contentToString())
    listPrint(list)

    val list1 = listOf(10, 33, 21, 55, 24)
    println("max: ${list1.max()}")
    println("min: ${list1.min()}")
    println("sort: ${list1.sorted()}")

    //2. mutableList : 가변
    var lotto = mutableListOf<Int>()
    while (lotto.size < 6) {
        val ball = getRand(1, 45)
        var dupli: Boolean = false
        for (i in lotto) {
            if (i == ball) {
                dupli = true; break
            }
        }
        if (!dupli) lotto.add(ball)
    }
    lotto.set(0, 10) // lotto번호에 특정번호 추가할 경우
    println("로또 번호: $lotto")
    while (lotto.size != 0) {
//        lotto.removeAt(5) // IndexOutOfBoundsException
//        lotto.removeAt(0)
        lotto.removeAt(lotto.size-1)
    }
    println("로또 번호: $lotto")

    // ArrayList
    val arrayList1 : ArrayList<Int> = arrayListOf(1,2,3)
    val arrayList2 : ArrayList<Int> = ArrayList()
    arrayList2.add(100);arrayList2.add(100);arrayList2.add(100)
    println("arrayList2: $arrayList2")

    // Queue :: LinkedList를 활용
    val linkedList:LinkedList<Int> = LinkedList() //변수명을 queue 선언해도 됨
    linkedList.add(100);linkedList.add(200);linkedList.add(300);//원소추가
    linkedList.pop() // 맨앞에 원소 삭제
    linkedList.removeAt(0) // 맨앞에 원소 삭제
    println("linkedList.peek(): ${linkedList.peek()}") // 맨앞의 원소 확인
    println("linkedList: $linkedList")

    // Stack
    //val stack = Stack<Int>() //간단하게 선언
    val stack:Stack<Int> = Stack<Int>()
    stack.add(1);stack.add(2);stack.add(3);
    stack.pop(); //맨끝에 원소 삭제
    stack.removeAt(stack.size-1) //맨끝에 원소삭제
    println("stack.peek(): ${stack.peek()}") // 맨끝의 원소 확인
    println("stack: $stack")

    // Array, List, mutableList, ArrayList, LinkedList, Stack등은
    // List의 특징으로 서로 교차 구현 가능함.
}









