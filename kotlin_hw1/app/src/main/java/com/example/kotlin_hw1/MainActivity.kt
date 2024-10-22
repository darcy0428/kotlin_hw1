package com.example.kotlin_hw1

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ed_Name = findViewById<EditText>(R.id.ed_Name)
        val tv_Text = findViewById<TextView>(R.id.tv_Text)
        val btn_Mora = findViewById<Button>(R.id.btn_Mora)
        val tv_Name = findViewById<TextView>(R.id.tv_Name)
        val tv_Winner = findViewById<TextView>(R.id.tv_Winner)
        val tv_MyMora = findViewById<TextView>(R.id.tv_MyMora)
        val tv_TargetMora = findViewById<TextView>(R.id.tv_TargetMora)
        val btn_Stone = findViewById<RadioButton>(R.id.btn_Stone)
        val btn_Paper = findViewById<RadioButton>(R.id.btn_Paper)
        val btn_Scissor = findViewById<RadioButton>(R.id.btn_Scissor)

        btn_Mora.setOnClickListener {
            if (ed_Name.length() < 1) {
                tv_Text.text = "請輸入玩家姓名"
            } else {
                tv_Name.text = "名字\n${ed_Name.text}"

                when {
                    btn_Scissor.isChecked -> tv_MyMora.text = "我方出拳\n剪刀"
                    btn_Stone.isChecked -> tv_MyMora.text = "我方出拳\n石頭"
                    else -> tv_MyMora.text = "我方出拳\n布"
                }

                val computerRandom = (0..2).random()
                tv_TargetMora.text = when (computerRandom) {
                    0 -> "電腦出拳\n剪刀"
                    1 -> "電腦出拳\n石頭"
                    else -> "電腦出拳\n布"
                }

                when {
                    (btn_Scissor.isChecked && computerRandom == 2) ||
                            (btn_Stone.isChecked && computerRandom == 0) ||
                            (btn_Paper.isChecked && computerRandom == 1) -> {
                        tv_Winner.text = "勝利者\n${ed_Name.text}"
                        tv_Text.text = "恭喜您獲勝了！！！"
                    }
                    (btn_Scissor.isChecked && computerRandom == 1) ||
                            (btn_Stone.isChecked && computerRandom == 2) ||
                            (btn_Paper.isChecked && computerRandom == 0) -> {
                        tv_Winner.text = "勝利者\n電腦"
                        tv_Text.text = "可惜，電腦獲勝了！"
                    }
                    else -> {
                        tv_Winner.text = "勝利者\n平手"
                        tv_Text.text = "平局，請再試一次！"
                    }
                }
            }
        }

    }
    
    private fun getMoraString(mora: Int): String {
        return when (mora) {
            0 -> "剪刀"
            1 -> "石頭"
            else -> "布"
        }
    }
}