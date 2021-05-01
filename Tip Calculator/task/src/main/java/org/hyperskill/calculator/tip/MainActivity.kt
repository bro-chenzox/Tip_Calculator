package org.hyperskill.calculator.tip

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.google.android.material.slider.Slider
class MainActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private lateinit var slider: Slider
    private lateinit var textView: TextView

    private var billValue = ""
    private var tipPercentage = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.edit_text)
        slider = findViewById(R.id.slider)
        textView = findViewById(R.id.text_view)

        editText.addTextChangedListener {
            billValue = it.toString()
            updateUI()
        }

        slider.addOnChangeListener(Slider.OnChangeListener { _, value, _ ->
            tipPercentage = value.toInt()
            updateUI()
        })
    }

    private fun updateUI() {
        textView.text = if (editText.text.isNotEmpty()) {
            "Tip amount: ${"%.2f".format(billValue.toDouble() * tipPercentage/100)}"
        } else ""
    }
}