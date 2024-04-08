package com.example.a22teb021_tranthicamhoa

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a22teb021_tranthicamhoa.databinding.ActivityKtrasntBinding
import com.example.a22teb021_tranthicamhoa.databinding.ActivityMainBinding

class KtrasntActivity : AppCompatActivity() {
    lateinit var binding: ActivityKtrasntBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityKtrasntBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnquaylai.setOnClickListener {
            var i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }
        binding.btncheck.setOnClickListener {
          var so  = binding.checknum.text.toString()
            var sos = so.toInt()
            fun isPrime(number: Int): Boolean{
                if(number<=1){
                    return false
                }
                for (i in 2 until number){
                    if(number%i==0){
                        return false
                    }
                }
                return true
            }
            if(isPrime(sos)) {
                binding.kq.text = "yasua "+ sos.toString() +" chắc chắn là 1 số nguyên tố"
            }else{
                binding.kq.text = "thật tiếc nó không phải"
            }
        }
    }
}