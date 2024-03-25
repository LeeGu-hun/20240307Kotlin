package com.example.ex00.grammar

//class Person()
//class Person constructor()
class Person // Person(), Person constructor() 와 같은 적용

// 클래스 생성자를 통해서 getter와 setter를 적용 가능
class Person1(name: String) //getter X, setter X
class Person2(var name: String) //getter O, setter O
class Person3(val name: String) //getter O, setter X
class Person4(name2: String){
    // 주생성자의 매개변수가 var,val이 없기 때문에 초기화 사용가능, 전역변수는 불가
    var name2: String
    init {  // 인스턴스 생성시 실행
        this.name2 = name2 // 전역변수화
        println("Person4 init name : $name2")
    }
    fun some(): Unit { // 사용할 시점에 호출
        println("Person4 some name : $name2")
    }
}


fun main() {
    val p = Person()
    val p1 = Person1("LGH")
    val p2 = Person2("LGH")
    val p3 = Person3("LGH")
    val p4 = Person4("GH")
    p4.some()
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

    // 오버로딩시 주의 할 내용
    tv.test(1, 1)  // 더 정확한 매개변수타입을 선택
    tv.test(1) //매개변수의 갯수가 달라도 적용가능
}

class Tv(channel: Int, volume: Int) {
    var power: Boolean = true

//    아래처럼 부생성자에서 this()를 사용하지 않으면 무조건 에러
//    constructor(channel: Int, volume: Int, power: Boolean) {
//        this.channel = channel; this.volume = volume;
//    }

//    주생성자가 존재한다면 부생성자는 무조건 주생성자에게 직간접으로 생성을 위임
    constructor(channel: Int, volume: Int, power: Boolean) : this(channel, volume) {
        this.channel = channel; this.volume = volume;
    }

    constructor(channel: Int) : this(channel, 0) {
        this.channel = channel
    }

    // field 는 get, set 에서 값을 접근할 때 사용
    var channel: Int = channel
        set(value) {
            if (value > 0) field = value
        }
        get() {
            return Math.abs(field)
        }
    var volume: Int = volume
        set(value) {
            if (value > 0) field = value
        }
        get() = field

    fun test(a: Int, b: Int, c: String? = null) {
        println("test2 $c")
    }

    fun test(a: Int, b: Int? = null) {
        println("test1")
    }

}