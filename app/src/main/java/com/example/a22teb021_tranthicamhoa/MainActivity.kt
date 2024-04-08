package com.example.a22teb021_tranthicamhoa

import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.SimpleCursorAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a22teb021_tranthicamhoa.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var db: SQLiteDatabase
    lateinit var rs: Cursor
    lateinit var adapter: SimpleCursorAdapter
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.ktrasntbtn.setOnClickListener{
            val i = Intent(this,KtrasntActivity::class.java)
            startActivity(i)
        }
        binding.giaiptbtn.setOnClickListener {
            var i = Intent(this, PTB::class.java)
            startActivity(i)
        }
        binding.qlhpbtn.setOnClickListener {
            var i = Intent(this, QLHP::class.java)
            startActivity(i)
        }
        var helpers = Helpers(applicationContext)
        db = helpers.readableDatabase
        rs = db.rawQuery("SELECT * FROM HPhan LIMIT 20", null)

    }

}