package com.example.ex00.grammar

// 클래스 생성자를 통해서 getter와 setter를 적용 가능
class Person
class Person1(name: String) //getter X, setter X
class Person2(var name: String) //getter O, setter O
class Person3(val name: String) //getter O, setter X

fun main() {
    val p = Person()
    val p1 = Person1("LGH")
    val p2 = Person2("LGH")
    val p3 = Person3("LGH")
    println(p)
    println(p1) //getter와 setter 없음
    println(p2.name) //getter
    p2.name = "LifeisGoodandHappy" //setter
    println(p2.name)
    println(p3.name) //getter
//    p3.name = "LGH"  //setter는 적용 불가
    val tv = Tv(-1, 10)
    println(tv.channel)
    println(tv.volume)
}

class Tv(channel: Int, volume: Int) {
    // field는 getter, setter에서 값을 접근할 때 사용
    var channel: Int = channel
        set(value) {
            if(value>0) field = value
        }
        get() {
            return Math.abs(field)
        }
    var volume: Int = volume
        set(value) {
            if(value>0) field = value
        }
        get() = field
}