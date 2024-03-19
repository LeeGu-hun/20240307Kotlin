package com.example.ex02recycler.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

//데이터클래스는 VO클래스를 편리하게 이용할 수 있게 해줌
data class Affirmation(
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int
)

/*
class NonDataClass(val name: String, val email: String, val age: Int)
data class DataClass(val name: String, val email: String, val age: Int)

fun main() {
    val non1 = NonDataClass("LGH", "a@z", 10)
    val non2 = NonDataClass("LGH", "a@z", 10)
    val data1 = DataClass("LGH", "a@z", 10)
    val data2 = DataClass("LGH", "a@z", 10)
    println(non1.equals(non2))  // false
    println(data1.equals(data2))  // true
}
*/

















