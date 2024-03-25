package com.example.ex00.grammar

import com.example.ex00.util.typePrint
import com.example.ex00.util.typePrintOld
import java.lang.IllegalStateException
import kotlin.reflect.typeOf

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
    c1 = 'a'
    println("c1: " + ++c1)
    //kotlin에서는 Char가 이항 연산되면 숫자가 아니라 Char타입 출력
    println("c1 + 1 : " + (c1 + 1))
    println(c1.toInt())
    if (c1 == 98.toChar()) println("같습니다.")
    val str1 = "Hello \n world"
    val str2 = """
        hello
        world
    """
    println("str1: $str1")
    println("str2: $str2")
    fun sum(no: Int): Int {
        var sum = 0
        for (i in 1..no) sum += i
        return sum
    }

    val name: String = "LGH"
    println("name: $name, sum: ${sum(10)}")

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
    var uint: UInt = 1000u
    var ul: ULong = 1000u
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
    println(data4) // lazy

    // 1. Any 코틀린에서 최상위 클래스
    var data10: Any
    data10 = 10
    typePrint(data10)
    var data11: Any = "Hello"

    class User
    var data12: Any = User()
    typePrint(data12)

    // 2. Unit 특수한 상황을 표현하기 위한 목적 자바의 void와 같음
    val data13: Unit = Unit

    // fun some() { //함수의 리턴타입을 쓰지않으면 Unit이 됨.
    fun some(): Unit {
        println(10 + 20)
    }

    // 3. null 허용과 불허용
    var data20: Int = 10
//    data20 = null // 에러 발생
    var data21: Int? = 10
    data21 = null   // 에러 없음
    typePrint(data21)

    // 4. Nothing //리턴없는 Unit에다가 null 또는 예외를 추가해서 반환할 경우
    val nullableVal: String? = null
//    val value1 = nullableVal ?: throw IllegalStateException()

//    nullableVal?는 null을 허용하는 변수라서 null이면 return 해서 종료
//    val value2 = nullableVal?.toInt() ?: return
//    typePrintOld(value2)

    println("================================")
    val data14: Nothing? = null
    typePrint(data14)

    fun some1(): Nothing { // Nothing 이지만 예외를 반환
        throw IllegalStateException()
    }
    fun some2(): Nothing? { // Nothing 이지만 null을 반환
        return null
    }

}
