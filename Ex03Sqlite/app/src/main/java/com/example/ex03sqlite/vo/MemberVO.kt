package com.example.ex03sqlite.vo

import android.os.Parcel
import android.os.Parcelable

class MemberVO(
    var id: Int, var name: String?, var age: Int, var mobile: String?
) : Parcelable {
    constructor(name: String?, age: Int, mobile: String?) : this(0, name, age, mobile)
    constructor(source: Parcel) : this(source.readInt(), source.readString(), source.readInt(), source.readString())

    companion object CREATOR : Parcelable.Creator<MemberVO> {
        override fun createFromParcel(source: Parcel): MemberVO {
            return MemberVO(source)
        }

        override fun newArray(size: Int): Array<MemberVO?> {
            return arrayOfNulls<MemberVO>(size)
        }
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeInt(id)
        dest.writeString(name)
        dest.writeInt(age)
        dest.writeString(mobile)

    }

    override fun toString(): String {
        return "$id/$name/$age/$mobile"
    }
}








