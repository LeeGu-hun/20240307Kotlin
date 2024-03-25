package com.example.ex03sqlite.dao

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.example.ex03sqlite.vo.MemberVO

class DbSqlHandler private constructor(ctx: Context){
    private val openHelper: DbOpenHelper = DbOpenHelper(ctx, "member.db", null, 1)
    private val sqLiteDatabase: SQLiteDatabase = openHelper.writableDatabase

    companion object {
        private var sqlHandler: DbSqlHandler? = null
        fun open(ctx: Context): DbSqlHandler {
            if (sqlHandler == null) {
                sqlHandler = DbSqlHandler(ctx)
            }
            return sqlHandler as DbSqlHandler
        }
    }

    fun close(): Unit {openHelper.close()}
    fun insert(vo: MemberVO): Long {
        val values = ContentValues()
        values.put("name", vo.name)
        values.put("age", vo.age)
        values.put("mobile", vo.mobile)
        return sqLiteDatabase.insert("member", null, values)
    }

    fun update(vo: MemberVO): Unit {
        val values = ContentValues()
        values.put("_id", vo.id)
        values.put("name", vo.name)
        values.put("age", vo.age)
        values.put("mobile", vo.mobile)
        sqLiteDatabase.update("member", null, "_id=?", arrayOf(vo.id.toString()))
    }
    fun delete(id: Int): Unit {
        sqLiteDatabase.delete("member", "_id=?", arrayOf(id.toString()))
    }

    @SuppressLint("Range")
    fun get(id: Int): MemberVO? {
        val cursor: Cursor = sqLiteDatabase.query(
            "member", null, "_id=?", arrayOf(id.toString()), null, null, null)
        return if (cursor.moveToNext()) {
            val _id = cursor.getInt(cursor.getColumnIndex("_id"))
            val name = cursor.getString(cursor.getColumnIndex("name"))
            val age = cursor.getInt(cursor.getColumnIndex("age"))
            val mobile = cursor.getString(cursor.getColumnIndex("mobile"))
            MemberVO(_id, name, age, mobile)
        } else {
            null
        }
    }
    @SuppressLint("Range")
    fun getList(): ArrayList<MemberVO> {
        var list: ArrayList<MemberVO> = ArrayList()
        val cursor: Cursor = sqLiteDatabase.query(
            "member", null, null, null, null, null, null)
        while (cursor.moveToNext()) {
            val _id = cursor.getInt(cursor.getColumnIndex("_id"))
            val name = cursor.getString(cursor.getColumnIndex("name"))
            val age = cursor.getInt(cursor.getColumnIndex("age"))
            val mobile = cursor.getString(cursor.getColumnIndex("mobile"))
            list.add(MemberVO(_id, name, age, mobile))
        }
        return list
    }
}












