package com.muhasib.chatgptapp

import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.ai.client.generativeai.GenerativeModel
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val etPrompt=findViewById<TextInputEditText>(R.id.prompt)
        val btnSubmit=findViewById<Button>(R.id.btnSend)
        val result= findViewById<TextView>(R.id.output)
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        btnSubmit.setOnClickListener {
            val prompt= etPrompt.text.toString()
            val generativeModel = GenerativeModel(
                modelName = "gemini-1.5-flash",
                // Access your API key as a Build Configuration variable (see "Set up your API key" above)
                apiKey = "Attach your Api"
            )
           runBlocking {

               val response = generativeModel.generateContent(prompt)
               result.text= buildString {
                   append(" ~")
                   append(response.text)
               }
               etPrompt.text?.clear()
           }





        }



    }
}