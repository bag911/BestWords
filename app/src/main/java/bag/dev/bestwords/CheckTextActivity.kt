package bag.dev.bestwords

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import bag.dev.bestwords.databinding.ActivityCheckTextBinding

class CheckTextActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_text)

        init()
    }

    private fun init() {
        val i = intent
        val fullText:TextView = findViewById(R.id.fullText)
        fullText.text = i.getStringExtra("text")
    }
}