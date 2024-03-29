package com.example.ex00.grammar

import com.example.ex00.util.getRand
import com.example.ex00.util.typePrint
import java.util.Date
import java.util.TreeSet

fun main() {
    // 1. set :: 순서 없다, 중복 불허
//    val set1 = Set<Any>() //에러 발생 Set은 interface
    val set1 = setOf(1, 2, 3, 2, 1)
    println("set1: $set1")
//    set1.add(4) //에러 immutable

//    val mutableSet:MutableSet<Int> = mutableSetOf<Int>()
    val mutableSet = mutableSetOf<Int>() //비어있는 set 생성
    mutableSet.add(1);mutableSet.add(1);mutableSet.add(1);
    println("mutableSet: $mutableSet")

    val lotto = mutableSetOf<Int>()
    while (lotto.size < 6) {
        val ball = getRand(1, 45)
        lotto.add(ball)
    }
    println("lotto: $lotto")

    val it = lotto.iterator()
    var cnt = 0;
    while (it.hasNext()) {
        if (cnt++ != 0) print(",")
        val tmp = it.next()
        print("$tmp")
    }
    println()
    for (item in lotto) {
        print("$item ,")
    }
    println()
    val list = lotto.toList()
    println(list.sorted())

    //HashSet
    val hashSet1 = HashSet<Int>()
//    val hashSet1 = hashSetOf<Int>()
    hashSet1.add(-1);hashSet1.add(0);hashSet1.add(3);
    println("hashSet1: $hashSet1")
    val hashSet2 = hashSetOf<Int>()
    hashSet2.add(0);hashSet2.add(3);
    println("hashSet2: $hashSet2")
    println(hashSet1 + hashSet2) //Union
    println(hashSet1 - hashSet2) //Difference
    println(hashSet1.intersect(hashSet2)) //Intersect
    println("hashSet1: $hashSet1")
    println("hashSet2: $hashSet2")

    val hashSet3 = hashSetOf<Any>()
    hashSet3.add(3);hashSet3.add("3");
    hashSet3.add(false);hashSet3.add(Date());
    hashSet3.remove("3")
    println("hashSet3: ${hashSet3}")
    for (item in hashSet3) typePrint(item)

    // TreeSet
    val treeSet: TreeSet<Any> = TreeSet()
    while (treeSet.size < 6) {
        val ball = getRand(1, 45)
        treeSet.add(ball)
    }
    println("treeSet 로또: $treeSet")

    val stdSet = HashSet<Student>()
    stdSet.add(Student(1, "LGH"))
    stdSet.add(Student(2, "LG"))
    stdSet.add(Student(1, "LGH"))
    println(stdSet.toString())
}

class Student(stdNo: Int, stdName: String) {
    var stdNo: Int
    var stdName: String
    init {
        this.stdNo = stdNo
        this.stdName = stdName
    }
    override fun toString(): String {
        return "번호: $stdNo, 이름: $stdName"
    }

    override fun equals(other: Any?): Boolean {
        // other가 Student타입이 아니면 null 반환
        // 'val student = other as? Student'가 null이면
        // return false 처리함.
        val student = other as? Student ?: return false
        return student.stdNo == this.stdNo
                && student.stdName == this.stdName
    }

    // Any는 hashCode()에 해당 메모리주소값을 반환한다. 그러면
    // 인스턴스의 메모리 주소값이 다르기 때문에 내용은 같지만
    // 다르다고 본다. 그래서 hashCode() 값을 동일하게 하는 것
    override fun hashCode(): Int {
        return 5 //responseCode 같은 개념. 5는 임의의 수
    }
}









