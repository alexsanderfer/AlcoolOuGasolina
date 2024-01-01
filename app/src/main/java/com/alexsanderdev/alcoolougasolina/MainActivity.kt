package com.alexsanderdev.alcoolougasolina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    private lateinit var textInputAlcohol: TextInputLayout
    private lateinit var editAlcohol: TextInputEditText

    private lateinit var textInputGasoline: TextInputLayout
    private lateinit var editGasoline: TextInputEditText

    private lateinit var buttonCalculate: Button
    private lateinit var textResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeInterfaceComponents()
        buttonCalculate.setOnClickListener {
            calculateBetterPrice()
        }
    }

    private fun calculateBetterPrice() {
        val priceAlcohol = editAlcohol.text.toString()
        val priceGasoline = editGasoline.text.toString()
        val validateResult = validateInput(priceAlcohol, priceGasoline)
        if (validateResult) {
            val result = priceAlcohol.toDouble() / priceGasoline.toDouble()
            if(result >= 0.7) {
                textResult.text = getString(R.string.melhor_utilizar_a_gasolina)
            } else {
                textResult.text = getString(R.string.melhor_utilizar_o_alcool)
            }
        }
    }

    private fun validateInput(priceAlcohol: String, priceGasoline: String): Boolean {

        textInputAlcohol.error = null
        textInputGasoline.error = null

        if (priceAlcohol.isEmpty()) {
            textInputAlcohol.error = getString(R.string.error_alcohol_field_required)
            return false
        } else if (priceGasoline.isEmpty()) {
            textInputGasoline.error = getString(R.string.error_gasoline_field_required)
            return false
        }
        return true
    }

    private fun initializeInterfaceComponents() {
        textInputAlcohol = findViewById(R.id.text_input_alcohol)
        editAlcohol = findViewById(R.id.edit_alcohol)

        textInputGasoline = findViewById(R.id.text_input_gasoline)
        editGasoline = findViewById(R.id.edit_gasoline)

        buttonCalculate = findViewById(R.id.button_calculate)
        textResult = findViewById(R.id.text_result)
    }
}