package com.divijgupta.neumorphiccalculator

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.divijgupta.neumorphiccalculator.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

private lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.btnClear.setOnClickListener {
            clear()
        }
        binding.btn0.setOnClickListener {
            append("0")
        }
        binding.btn1.setOnClickListener {
            append("1")
        }
        binding.btn2.setOnClickListener  {
            append("2")
        }
        binding.btn3.setOnClickListener {
            append("3")
        }
        binding.btn4.setOnClickListener {
            append("4")
        }
        binding.btn5.setOnClickListener {
            append("5")
        }
        binding.btn6.setOnClickListener {
            append("6")
        }
        binding.btn7.setOnClickListener {
            append("7")
        }
        binding.btn8.setOnClickListener {
            append("8")
        }
        binding.btn9.setOnClickListener {
            append("9")
        }
        binding.btnDecimal.setOnClickListener {
            append(".")
        }
        binding.btnMul.setOnClickListener {
            append("*")
        }
        binding.btnDiv.setOnClickListener {
            append("/")
        }
        binding.btnSub.setOnClickListener {
            append("-")
        }
        binding.btnAdd.setOnClickListener {
            append("+")
        }
        binding.btnBraces.setOnClickListener {
            append("(")
        }
        binding.btnPerc.setOnClickListener {
            append(")")
        }
        binding.btnAnswer.setOnClickListener {
            findAns()
        }

        binding.btnBack.setOnClickListener {
            val expr = binding.tvInput.text.toString()
            if (expr.isNotEmpty()) {
                tvInput.text = expr.substring(0, expr.length - 1)
            }
        }

    }
    fun clear() {
        //binding.tvAns.text = ""
        binding.tvInput.text = ""
    }
    fun append(s : String) {
        binding.tvInput.append(s)
    }
    fun findAns() {
        try {
            val expression = ExpressionBuilder(binding.tvInput.text.toString()).build()
            val result = expression.evaluate()
            val longResult = result.toLong()
            if (result == longResult.toDouble()) {
                tvInput.text = longResult.toString()
            } else
                tvInput.text = result.toString()

        } catch (e: Exception) {
            tvInput.text = "Error!"
        }
    }
}