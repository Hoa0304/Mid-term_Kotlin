package com.example.a22teb021_tranthicamhoa

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class Helpers(context: Context) :SQLiteOpenHelper(context, "kpdb", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE HPhan(mahp TEXT, ten TEXT,sotin TEXT, hk TEXT)")
        db?.execSQL("Insert into HPhan(mahp,ten,sotin,hk) values ('it1','Cong Nghe PM','2','1')")
        db?.execSQL("Insert into HPhan(mahp,ten,sotin,hk) values ('it2','Cong Nghe PM5','2','2')")
        db?.execSQL("Insert into HPhan(mahp,ten,sotin,hk) values ('it3','Cong Nghe PM4','3','3')")
        db?.execSQL("Insert into HPhan(mahp,ten,sotin,hk) values ('it4','Cong Nghe PM3','4','5')")
        db?.execSQL("Insert into HPhan(mahp,ten,sotin,hk) values ('it5','Cong Nghe PM2','5','4')")
        db?.execSQL("Insert into HPhan(mahp,ten,sotin,hk) values ('it6','Cong Nghe PM1','2','3')")

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
}