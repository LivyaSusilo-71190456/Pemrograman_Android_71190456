package id.ac.ukdw.pertemuan5_71190456

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val username = intent.getStringExtra("username")
        val tvgreetings = findViewById<TextView>(R.id.greetings)
        tvgreetings.text = "S e l a m a t  D a t a n g $username . . ."
    }
}