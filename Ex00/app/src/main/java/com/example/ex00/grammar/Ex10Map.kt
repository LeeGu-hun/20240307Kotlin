package com.example.ex00.grammar

import androidx.compose.material.icons.Icons
import java.util.TreeMap

fun main() {
    // 1. Map은 key, value를 한쌍으로 다룬다.
    // 특징 :: key는 순서 없고 중복 불허, value는 순서 없고 중복 허용
    // val map = Map<Any, Any>() //에러 발생 Map은 interface
    var pair: Pair<Any, Any> = "c" to "cherry"
    val map1 = mapOf("a" to "apple", "b" to "banana", pair)
    println("immutable map1 : $map1")

    var map2 = mutableMapOf(pair, "d" to Student(1,"LGH"), pair)
    map2.put("e", 200)
    map2.put("f", "fine")
    map2.put("g", Student(1,"LG"))
    map2["h"] = "hello"
    println("mutable map2 : $map2")

    map2.forEach({ k, v -> println("$k 의 값은 $v 이다.") })
    for ((k, v) in map2) println("$k 의 값은 $v 이다.")

    val it = map2.entries.iterator() // k, v를 동시에 접근
    while (it.hasNext()) {
        val entry: Map.Entry<Any, Any> = it.next()
        println("${entry.key} 의 값은 ${entry.value} 이다.")
    }

    println("======================================")
    val itKey = map2.keys.iterator() // k에 접근
    while (itKey.hasNext()) {
        val key = itKey.next()
        println("$key 의 값은 ${map2.get(key)}")
    }
    for (key in map2.keys) {
        println("$key 의 값은 ${map2.get(key)}")
    }

    val itVal = map2.values.iterator() // v에 접근
    while (itVal.hasNext()) println(itVal.next())

    var treeMap = TreeMap<Int, Student>()
    treeMap.put(1, Student(1, "홍길동"))
    treeMap.put(2, Student(2, "박길동"))
    treeMap.put(1, Student(1, "김길동"))
    println(treeMap)
}







