package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.ListView
import android.widget.SimpleAdapter


import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar


import com.google.android.material.textfield.TextInputEditText
import com.wolfram.alpha.WAEngine

class MainActivity : AppCompatActivity() {
    val TAG: String = "MainActivity"


    //lateinit - отложенная инициализация
    lateinit var requestInput: TextInputEditText
    lateinit var podsAdapter: SimpleAdapter

    lateinit var waEngine: WAEngine

    val pods = mutableListOf<HashMap<String, String>>(
        HashMap<String, String>().apply {
            put("Title", "Title 1")
            put("Content", "Content 1")
        },
        HashMap<String, String>().apply {
            put("Title", "Title 2")
            put("Content", "Content 2")
        },
        HashMap<String, String>().apply {
            put("Title", "Title 3")
            put("Content", "Content 3")
        }
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        initWolframEngine()


    }

    fun initViews() {
        val toolbar: MaterialToolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        requestInput = findViewById(R.id.text_input_edit)

        val podsList: ListView = findViewById(R.id.pods_list)

        podsAdapter = SimpleAdapter(
            applicationContext,
            pods,
            R.layout.item_pod,
            arrayOf("Title", "Content"),
            intArrayOf(R.id.title, R.id.content)
        )

        podsList.adapter = podsAdapter

        val voiceInputButton: FloatingActionButton = findViewById(R.id.voice_input_button)

        voiceInputButton.setOnClickListener {
            Log.d(TAG, "FAB")
        }
    }

    //переопределяем системный метод, который отрисовывает меню
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    //переопределяем системный метод, который что бы кнопка при нажатии что-то делала
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_stop -> {
                Log.d(TAG, "action_stop")
                return true
            }
            R.id.action_clear -> {
                Log.d(TAG, "action_clear")
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    fun initWolframEngine() {
        waEngine = WAEngine().apply {
            appID = "3TG2VH-AA37Y739P5"
            addFormat("plaintext")
        }
    }

    //errors
    fun showSnackbar(message: String) {
        Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_INDEFINITE)
            .apply {
                setAction(android.R.string.ok) {
                    dismiss()
                }
                show()
            }
    }
}