package tech.edem.calculator_app

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import net.objecthunter.exp4j.ExpressionBuilder

private lateinit var zeroBtn: Button
private lateinit var oneBtn: Button
private lateinit var twoBtn: Button
private lateinit var threeBtn: Button
private lateinit var fourBtn: Button
private lateinit var fiveBtn: Button
private lateinit var sixBtn: Button
private lateinit var sevenBtn: Button
private lateinit var eightBtn: Button
private lateinit var nineBtn: Button
private lateinit var result: TextView
private lateinit var mathOperation: TextView
private lateinit var delBtn: Button
private lateinit var remBtn: Button
private lateinit var divBtn: Button
private lateinit var multiBtn: Button
private lateinit var subBtn: Button
private lateinit var plusBtn: Button
private lateinit var pointBtn: Button
private lateinit var equalsBtn: Button
private lateinit var correctBtn: Button


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        zeroBtn = findViewById(R.id.zero)
        oneBtn = findViewById(R.id.one)
        twoBtn = findViewById(R.id.two)
        threeBtn = findViewById(R.id.three)
        fourBtn = findViewById(R.id.four)
        fiveBtn = findViewById(R.id.five)
        sixBtn = findViewById(R.id.six)
        sevenBtn = findViewById(R.id.seven)
        eightBtn = findViewById(R.id.eight)
        nineBtn = findViewById(R.id.nine)
        result = findViewById(R.id.result)
        mathOperation = findViewById(R.id.math_operation)
        remBtn = findViewById(R.id.remainder)
        divBtn = findViewById(R.id.division)
        multiBtn = findViewById(R.id.multi)
        subBtn = findViewById(R.id.subtraction)
        plusBtn = findViewById(R.id.plus)
        delBtn = findViewById(R.id.delete)
        correctBtn = findViewById(R.id.correct)
        equalsBtn = findViewById(R.id.equals)
        pointBtn = findViewById(R.id.point)

        zeroBtn.setOnClickListener { setTextFields("0") }
        oneBtn.setOnClickListener { setTextFields("1") }
        twoBtn.setOnClickListener { setTextFields("2") }
        threeBtn.setOnClickListener { setTextFields("3") }
        fourBtn.setOnClickListener { setTextFields("4") }
        fiveBtn.setOnClickListener { setTextFields("5") }
        sixBtn.setOnClickListener { setTextFields("6") }
        sevenBtn.setOnClickListener { setTextFields("7") }
        eightBtn.setOnClickListener { setTextFields("8") }
        nineBtn.setOnClickListener { setTextFields("9") }
        remBtn.setOnClickListener { setTextFields("%") }
        divBtn.setOnClickListener { setTextFields("/") }
        multiBtn.setOnClickListener { setTextFields("*") }
        subBtn.setOnClickListener { setTextFields("-") }
        plusBtn.setOnClickListener { setTextFields("+") }
        pointBtn.setOnClickListener { setTextFields(".") }

        delBtn.setOnClickListener {
            mathOperation.text = ""
            result.text = ""
        }

        correctBtn.setOnClickListener {
            val str = mathOperation.text.toString()
            if (str.isNotEmpty()) {
                mathOperation.text = str.substring(0, str.length - 1)
                result.text = ""
            }
        }

        equalsBtn.setOnClickListener {
            try {
                val impl = ExpressionBuilder(mathOperation.text.toString()).build()
                val endResult = impl.evaluate()
                val longRes = endResult.toLong()
                val doubleRes = endResult.toFloat()

                if (endResult == longRes.toDouble()) {
                    result.text = longRes.toString()
                } else {
                    result.text = doubleRes.toString()
                }
            } catch (e: Exception) {
                Log.d("Ошибка", "${e.message}")
            }
        }
    }

    fun setTextFields(str: String) {
        if (result.text != "") {
            mathOperation.text = result.text
            result.text = ""
        }
        mathOperation.append(str)
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
