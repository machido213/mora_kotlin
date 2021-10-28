package com.example.mora_kot

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var edit_name =findViewById<EditText>(R.id.ed_name)
        var status =findViewById<TextView>(R.id.tv_text)
        var radiogroup =findViewById<RadioGroup>(R.id.radioGroup)
        var btn_scissor =findViewById<RadioButton>(R.id.btn_scissor)
        var btn_stone =findViewById<RadioButton>(R.id.btn_stone)
        var btn_paper =findViewById<RadioButton>(R.id.btn_paper)
        var btn_mora = findViewById<Button>(R.id.btn_mora)
        var tv_name =findViewById<TextView>(R.id.tv_name)
        var tv_winner =findViewById<TextView>(R.id.tv_winner)
        var tv_mmora =findViewById<TextView>(R.id.tv_mmora)
        var tv_cmora = findViewById<TextView>(R.id.tv_cmora)

        btn_mora.setOnClickListener {
            if (edit_name.length() < 1) status.text = "請輸入玩家命名" else {
                tv_name.text = """
                    名字是
                    ${edit_name.text}
                    """.trimIndent()
                if (btn_scissor.isChecked) tv_mmora.text =
                    "玩家出\n剪刀" else if (btn_stone.isChecked) tv_mmora.text =
                    "玩家出\n石頭" else tv_mmora.text = "玩家出\n布"
                val computer = (Math.random() * 3).toInt()
                if (computer == 0) tv_cmora.text = "電腦出\n剪刀" else if (computer == 1) tv_cmora.text =
                    "電腦出\n石頭" else tv_cmora.text =
                    "電腦出\n布"
                if (btn_scissor.isChecked && computer == 0 ||
                    btn_stone.isChecked && computer == 1 ||
                    btn_paper.isChecked && computer == 2
                ) {
                    tv_winner.text = "勝利者\n平手"
                    status.text = "平手"
                } else if (btn_scissor.isChecked && computer == 2 ||
                    btn_stone.isChecked && computer == 0 ||
                    btn_paper.isChecked && computer == 1
                ) {
                    tv_winner.text = "勝利者\n玩家"
                    status.text = "你贏了"
                } else {
                    tv_winner.text = "勝利者\n電腦"
                    status.text = "你輸了"
                }
            }
        }

    }


}