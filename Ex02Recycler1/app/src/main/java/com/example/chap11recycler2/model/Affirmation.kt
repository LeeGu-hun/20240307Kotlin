package com.example.chap11recycler2.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

// Data class : 데이터를 보관하는 목적으로 만든 클래스
data class Affirmation(
  @StringRes val stringResourceId: Int,
  @DrawableRes val imageResourcId: Int
)