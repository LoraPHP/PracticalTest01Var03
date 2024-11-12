package ro.pub.cs.systems.eim.lab03.practicaltest01var03

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PracticalTest01Var03SecondaryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_practical_test01_var03_secondary)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val result = findViewById<TextView>(R.id.result)

        val intent = intent
        if (intent != null && intent.extras != null) {
            val resultValue = intent.extras!!.getString(Constants.RESULT)
            result.text = resultValue
        }

        val correctButton = findViewById<Button>(R.id.correct_btn)
        val incorrectButton = findViewById<Button>(R.id.incorrect_btn)
        correctButton.setOnClickListener {
            setResult(RESULT_OK, null)
            finish()
        }
        incorrectButton.setOnClickListener {
            setResult(RESULT_CANCELED, null)
            finish()
        }
    }
}