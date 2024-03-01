package com.example.lotterytest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.util.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvNumbers = mutableListOf<TextView>()
        tvNumbers.add(findViewById(R.id.tv_1))
        tvNumbers.add(findViewById(R.id.tv_2))
        tvNumbers.add(findViewById(R.id.tv_3))
        tvNumbers.add(findViewById(R.id.tv_4))
        tvNumbers.add(findViewById(R.id.tv_5))
        tvNumbers.add(findViewById(R.id.tv_6))


        var input = findViewById<EditText>(R.id.edittext)

        var button= findViewById<Button>(R.id.btn_generate)

        button.setOnClickListener {
            calculate(tvNumbers)
        }
    }

    fun calculate(textViews: List<TextView>){
        var gen_num= mutableListOf<Int>()

        var gen: Random = Random()

        while(gen_num.size<6){
            var new_num= 1+ gen.nextInt(59)

            if(new_num !in gen_num)
                gen_num.add(new_num)
        }

        for (i in 0 until textViews.size) {
            textViews[i].text = gen_num[i].toString()
        }
    }
}