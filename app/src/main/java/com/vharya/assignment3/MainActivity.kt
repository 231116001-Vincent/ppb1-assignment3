package com.vharya.assignment3

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        enableEdgeToEdge()

        val vContentLayout = findViewById<ConstraintLayout>(R.id.content)
        val vToolbar = findViewById<Toolbar>(R.id.toolbar)

        setSupportActionBar(vToolbar)

        ViewCompat.setOnApplyWindowInsetsListener(vContentLayout) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, 0, systemBars.right, systemBars.bottom)
            insets
        }

        ViewCompat.setOnApplyWindowInsetsListener(vToolbar) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(0, systemBars.top, 0, 0)
            insets
        }
    }

    fun sendMessage(view: View) {
        val vMessageInput = findViewById<EditText>(R.id.messageInput)
        val message = vMessageInput.text.toString();

        val toast = Toast.makeText(applicationContext, "Successfully changed!", Toast.LENGTH_SHORT);
        toast.show();

        val intent = Intent(this, MessageActivity::class.java)
        intent.putExtra("message", message)
        startActivity(intent)
    }
}