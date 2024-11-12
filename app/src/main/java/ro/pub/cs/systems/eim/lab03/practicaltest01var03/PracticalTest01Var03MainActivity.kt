package ro.pub.cs.systems.eim.lab03.practicaltest01var03

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PracticalTest01Var03MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_practical_test01_var03_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        if (savedInstanceState != null) {
            val firstEditText = findViewById<EditText>(R.id.first_number)
            val secondEditText = findViewById<EditText>(R.id.second_number)
            val resultTextView = findViewById<TextView>(R.id.result)

            firstEditText.setText(savedInstanceState.getString(Constants.FIRST_NUMBER))
            secondEditText.setText(savedInstanceState.getString(Constants.SECOND_NUMBER))
            resultTextView.text = savedInstanceState.getString(Constants.RESULT)
            Toast.makeText(applicationContext, "First number: " + Constants.FIRST_NUMBER + " second number: " + Constants.SECOND_NUMBER + " result: " + Constants.RESULT, Toast.LENGTH_SHORT).show()

        }

        val addButton = findViewById<Button>(R.id.plus_btn)
        val subtractButton = findViewById<Button>(R.id.minus_btn)

        addButton.setOnClickListener {
            val firstEditText = findViewById<EditText>(R.id.first_number)
            val secondEditText = findViewById<EditText>(R.id.second_number)
            val resultTextView = findViewById<TextView>(R.id.result)

            if (firstEditText.text.toString().toIntOrNull() == null) {
                Toast.makeText(applicationContext, "First value is not an integer: " + firstEditText.text.toString(), Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (secondEditText.text.toString().toIntOrNull() == null) {
                Toast.makeText(applicationContext, "Second value is not an integer: " + secondEditText.text.toString(), Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }


            val firstValue = firstEditText.text.toString().toInt()
            val secondValue = secondEditText.text.toString().toInt()

            resultTextView.text = firstValue.toString() + " + " + secondValue.toString() + " = " + (firstValue + secondValue).toString()
        }

        subtractButton.setOnClickListener {
            val firstEditText = findViewById<EditText>(R.id.first_number)
            val secondEditText = findViewById<EditText>(R.id.second_number)
            val resultTextView = findViewById<TextView>(R.id.result)

            // daca vreunul dintre campurin nu contine valori de tip intreg se va afisa un mesaj de eroare intr-un Toast care contine valoarea eronata
            if (firstEditText.text.toString().toIntOrNull() == null) {
                Toast.makeText(
                    applicationContext,
                    "First value is not an integer: " + firstEditText.text.toString(),
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }
            if (secondEditText.text.toString().toIntOrNull() == null) {
                Toast.makeText(
                    applicationContext,
                    "Second value is not an integer: " + secondEditText.text.toString(),
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }


            val firstValue = firstEditText.text.toString().toInt()
            val secondValue = secondEditText.text.toString().toInt()


            resultTextView.text =
                firstValue.toString() + " - " + secondValue.toString() + " = " + (firstValue - secondValue).toString()
        }

        val navigateToSecondaryActivityButton = findViewById<Button>(R.id.secondary_btn)
        navigateToSecondaryActivityButton.setOnClickListener {
            val intent = Intent(this, PracticalTest01Var03SecondaryActivity::class.java)
            intent.putExtra(Constants.RESULT, findViewById<EditText>(R.id.result).text.toString())
            startActivityForResult(intent, 1)
        }


    }

    public override fun onSaveInstanceState(savedInstanceState: Bundle) {
        super.onSaveInstanceState(savedInstanceState)
        val firstEditText = findViewById<EditText>(R.id.first_number)
        val secondEditText = findViewById<EditText>(R.id.second_number)
        val resultTextView = findViewById<TextView>(R.id.result)

        savedInstanceState.putString(
            Constants.FIRST_NUMBER,
            firstEditText.text.toString()
        )
        savedInstanceState.putString(
            Constants.SECOND_NUMBER,
            secondEditText.text.toString()
        )
        savedInstanceState.putString(
            Constants.RESULT,
            resultTextView.text.toString()
        )


    }

}