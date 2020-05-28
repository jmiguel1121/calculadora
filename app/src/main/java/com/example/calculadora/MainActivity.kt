package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.enumcalc.ModeCalc
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity(var ope: OperationCalc = OperationCalc()) : AppCompatActivity() {

    var lastOperation = false
    var currentText = ""
    var currentOperation = ModeCalc.EMPTY

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupCalculator()
    }

    private fun setupCalculator() {
        val listButtoms =
            arrayOf(btn_0, btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9);
        for (i in listButtoms.indices) {
            listButtoms[i].setOnClickListener { didiPressNumber(i) };
        }
        btn_sum.setOnClickListener { changeOperation(ModeCalc.SUMAR) }
        btn_rest.setOnClickListener { changeOperation(ModeCalc.RESTAR) }
        btn_div.setOnClickListener { changeOperation(ModeCalc.DIVIDIR) }
        btn__mult.setOnClickListener { changeOperation(ModeCalc.MULTIPLICAR) }
        btn_result.setOnClickListener { didPressResult() }
        btn_clear.setOnClickListener { didPressClear() }
    }

    fun updateText(txt: String) {
        tv_screen.text = txt
    }

    fun didiPressNumber(number: Int) {
        currentText = "$currentText$number"
        updateText(currentText)
    }

    private fun changeOperation(mode: ModeCalc) {
        ope.num = currentText.toInt()
        currentOperation = mode
        currentText = ""
    }

    private fun didPressResult() {
        ope.num2 = currentText.toInt()
        if (ModeCalc.EMPTY == currentOperation) return
        currentText = ope.callOperation(currentOperation)
        currentOperation = ModeCalc.EMPTY
        updateText(currentText)
        currentText = ""
    }

    private fun didPressClear() {
        currentOperation = ModeCalc.EMPTY
        currentText = ""
        ope.num = 0
        updateText("")
    }

}
