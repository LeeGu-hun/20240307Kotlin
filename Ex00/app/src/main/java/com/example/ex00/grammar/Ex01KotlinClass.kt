package com.example.ex00.grammar

import com.example.ex00.util.typePrint

var n1 = 10

class Ex01VariableClass {
    fun p() {
        println("Hello world")
    }
}

fun main() {
    var ex01 = Ex01VariableClass() // class 안에 있는 메서드를 사용할 경우
    ex01.p()
    var ex01Java = Ex01Java() // 순수한 자바 소스에서 메서드를 사용할 경우
    ex01Java.printJava()
    p1() // 같은 패키지 내의 코틀린 파일의 메서드, 변수는 선언없이 사용가능
    typePrint(10)
}