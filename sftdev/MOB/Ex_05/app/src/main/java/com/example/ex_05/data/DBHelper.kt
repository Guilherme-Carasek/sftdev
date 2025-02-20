package com.example.ex_05.data

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.ex_05.model.Utilizador

class DBHelper(context: Context): SQLiteOpenHelper(context, "database.db", null, 1) {

    val sql = arrayOf(
        "CREATE TABLE utilizador (id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, password TEXT)",
        "INSERT INTO utilizador (username, password) VALUES ('user', 'pass')",
        "INSERT INTO utilizador (username, password) VALUES ('admin', 'pwd')"
    )

    override fun onCreate(db: SQLiteDatabase?) {
        sql.forEach {
            db?.execSQL(it)
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE utilizador")
        onCreate(db)
    }

    fun utilizadorInsert(username:String, password:String):Long {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put("username", username)
        contentValues.put("password", password)
        val res = db.insert("utilizador", null, contentValues)
        db.close()
        return res
    }

    fun utilizadorUpdate ( id:Int, username:String, password:String ):Int{

        val dp = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put("username", username)
        contentValues.put("password", password)
        val res = dp.update("utilizador", contentValues, "username = ?", arrayOf(username) )
        dp.close()
        return res
    }

    fun utilizadorDelete(id:Int):Int{
        val dp = this.writableDatabase
        val res = dp.delete("utilizador", "id = ?", arrayOf(id.toString()))
        dp.close()
        return res
    }

    fun utilizadorSelect():Cursor {
        val db = this.readableDatabase
        val c = db.rawQuery("SELECT * FROM utilizador", null)
        db.close()
        return c
    }

    fun utilizadorListSelectAll(): ArrayList<Utilizador> {
        val db = this.readableDatabase
        val c = db.rawQuery("SELECT * FROM utilizador", null)
        val listaUtilizador : ArrayList<Utilizador> = ArrayList()
        if (c.count > 0) {
            c.moveToFirst()
            do {
                val idIndex = c.getColumnIndex("id")
                val usernameIndex = c.getColumnIndex("username")
                val passwordIndex = c.getColumnIndex("password")
                val id = c.getInt(idIndex)
                val username = c.getString(usernameIndex)
                val password = c.getString(passwordIndex)
                listaUtilizador.add(Utilizador(id, username, password))
            }while (c.moveToNext())
        }
        db.close()
        return listaUtilizador

    }

    fun utilizadorSelectById(id:Int): Cursor{
        val db = this.readableDatabase
        return db.rawQuery("SELECT * FROM utilizador WHERE id = $id", null)
    }

    fun utilizadorObjectSelectById (id:Int): Utilizador {
        val db = this.readableDatabase
        val c= db.rawQuery("SELECT * FROM utilizador WHERE id = ?", arrayOf(id.toString()))
        var utilizador = Utilizador()
        if (c.count == 1){
            c.moveToFirst()
            val idIndex = c.getColumnIndex("id")
            val usernameIndex = c.getColumnIndex("username")
            val passwordIndex = c.getColumnIndex("password")
            val id = c.getInt(idIndex)
            val username = c.getString(usernameIndex)
            val password = c.getString(passwordIndex)
            utilizador = Utilizador(id, username, password)

        }

        return utilizador
    }



}