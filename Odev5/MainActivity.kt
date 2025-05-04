package com.example.odev5

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.odev5.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var currentInput = ""
    private var total = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val digitButtons = listOf(
            binding.btn0, binding.btn1, binding.btn2,
            binding.btn3, binding.btn4, binding.btn5,
            binding.btn6, binding.btn7, binding.btn8,
            binding.btn9)

        digitButtons.forEach{
            btn -> btn.setOnClickListener{
                currentInput += btn.text
                binding.sonuc.text = currentInput
        }
        }

        binding.topla.setOnClickListener {
            if (currentInput.isNotEmpty()){
                total += currentInput.toInt()
                currentInput = ""
                binding.sonuc.text = total.toString()
            }
        }

        binding.btnEsittir.setOnClickListener {
            if (currentInput.isNotEmpty()) {
                total += currentInput.toInt()
                currentInput = ""
            }
            binding.sonuc.text = total.toString()
        }

        binding.silBtn.setOnClickListener {
            currentInput = ""
            total = 0
            binding.sonuc.text = ""
        }


    }


}