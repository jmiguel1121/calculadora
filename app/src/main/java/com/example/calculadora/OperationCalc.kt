package com.example.calculadora

import com.example.enumcalc.ModeCalc

class OperationCalc {

    var num: Int = 0
    var num2: Int = 0

    fun sumar(): String {
        num += num2
        return num.toString();
    }

    fun restar(): String {
        num -= num2
        return num.toString();
    }

    fun dvidir(): String {
        if (num2 == 0) return "Error" else num /= num2
        return num.toString()
    }

    fun multiplicar(): String {
        num *= num2
        return num.toString();
    }

    fun callOperation(mode: ModeCalc): String {
        return when (mode) {
            ModeCalc.SUMAR -> sumar()
            ModeCalc.RESTAR -> restar()
            ModeCalc.MULTIPLICAR -> multiplicar()
            ModeCalc.DIVIDIR -> dvidir()
            else -> ""
        }
    }
}