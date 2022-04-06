package edu.wit.mobileapp.myguessgame
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var actualNum: Int = ((Math.random() * 100).toInt())
        var button: Button = findViewById(R.id.button)
        var userGuess: EditText = findViewById(R.id.guess)
        var feedbackText: TextView = findViewById(R.id.resultText)

        button.setOnClickListener {
            var guessedNum = Integer.valueOf(userGuess.text.toString())
            var result: String = guessNumber(guessedNum, actualNum)
            feedbackText.text = result
            userGuess.setText("")
        }
    }

    private fun guessNumber(guessedNum: Int, num: Int): String {
        return when {
            guessedNum == num -> "Guessed it!"
            guessedNum < num -> "Too low"
            else -> "Too high"
        }
    }
}