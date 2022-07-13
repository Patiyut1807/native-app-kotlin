package com.example.starter_app
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
typealias Arraylist<E> = java.util.ArrayList<E>
class MainActivity : AppCompatActivity() {

    private lateinit var text_input: String
    private val list: Arraylist<String> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener({
            text_input = editText.text.toString()
            Toast.makeText(applicationContext, "Added " + text_input , Toast.LENGTH_LONG).show()
        })
    }
}