package com.example.noteappdb.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.noteappdb.R

class UpdateActivity : AppCompatActivity() {

    lateinit var editTextTitle: EditText
    lateinit var editeTextDescription: EditText
    lateinit var buttonCancel: Button
    lateinit var buttonSave: Button

    var currentId = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)

        supportActionBar?.title = "Update Note"

        editTextTitle = findViewById(R.id.editTextTitleUpdate)
        editeTextDescription = findViewById(R.id.editTextDescriptionUpdate)
        buttonCancel = findViewById(R.id.buttonCancelUpdate)
        buttonSave = findViewById(R.id.buttonSaveUpdate)

        getAndSetData()

        buttonSave.setOnClickListener {
            updateNote()
        }
        buttonCancel.setOnClickListener {
            Toast.makeText(applicationContext, "Nothing Updated", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    fun updateNote() {
        val updatedTitle = editTextTitle.text.toString()
        val updatedDescription = editeTextDescription.text.toString()

        val intent = Intent()
        intent.putExtra("updatedTitle", updatedTitle)
        intent.putExtra("updatedDescription", updatedDescription)
        if (currentId != -1) {

            intent.putExtra("noteId", currentId)
            setResult(RESULT_OK, intent)
            finish()
        }
    }

    fun getAndSetData() {
        val currentTitle = intent.getStringExtra("currentTitle")
        val currentDescription = intent.getStringExtra("currentDescription")
        currentId = intent.getIntExtra("currentId", -1)

        editTextTitle.setText(currentTitle)
        editeTextDescription.setText(currentDescription)
    }
}