package com.example.a22teb021_tranthicamhoa

import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.widget.SimpleCursorAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a22teb021_tranthicamhoa.databinding.ActivityPtbBinding

class PTB : AppCompatActivity() {
    lateinit var binding: ActivityPtbBinding
    lateinit var db: SQLiteDatabase
    lateinit var rs: Cursor
    lateinit var adapter: SimpleCursorAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityPtbBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnquaylai.setOnClickListener {
            var i  = Intent(this, MainActivity::class.java)
            startActivity(i)
        }
        binding.btncheck.setOnClickListener {
            var s1 = binding.checknum1.text.toString()
            var sot1 = s1.toDouble()
            var s2 = binding.checknum2.text.toString()
            var sot2 = s2.toDouble()
            if(sot1 == 0.0){
                if(sot2 == 0.0){
                    binding.kq.text = "Oiiii vô số nghiệm"

                }else{
                    binding.kq.text = "Oiii vô nghiệm mất rồi"
                }
            }else{
                binding.kq.text = "Đại khái x là : "+ (-sot2/sot1).toString()
            }
        }



    }
}