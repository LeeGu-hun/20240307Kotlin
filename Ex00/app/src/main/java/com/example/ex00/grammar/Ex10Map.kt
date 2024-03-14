package com.example.ex00.grammar

fun main() {
    // 1. Map은 key, value를 한쌍으로 다룬다.
    // 특징 :: key는 순서 없고 중복 불허, value는 순서 없고 중복 허용
    // val map = Map<Any, Any>() //에러 발생 Map은 interface
    var pair: Pair<Any, Any> = "c" to "cherry"
    val map1 = mapOf("a" to "apple", "b" to "banana", pair)

}