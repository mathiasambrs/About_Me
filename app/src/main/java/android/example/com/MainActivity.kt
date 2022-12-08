package android.example.com

import android.app.Activity
import android.content.Context
import android.databinding.DataBindingUtil
import android.example.com.databinding.ActivityMainBinding
import android.inputmethodservice.InputMethodService
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.webkit.WebView
import android.widget.Button
import android.widget.EditText
import android.widget.TextView



//Mathias AMBROSI
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val  myName: MyName = MyName("Mathias Ambrosi")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myName = myName
        //findViewById<Button>(R.id.done_button).setOnClickListener{
        //    addNickname(it)
        binding.doneButton.setOnClickListener {
            addNickname(it)
        }
    }

    private fun addNickname(view:View){

        binding.apply {
            //nicknameText.text = binding.nicknameEdit.text
            myName?.nickname = nicknameEdit.text.toString()
            invalidateAll()
            nicknameEdit.visibility = View.GONE
            doneButton.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }
        //binding.apply {
        //binding.nicknameText.text = binding.nicknameEdit.text
        //invalidateAll()
        //binding.nicknameEdit.visibility = View.GONE
        //binding.doneButton.visibility = View.GONE
        //binding.nicknameText.visibility = View.VISIBLE
        //}

        //val editText = findViewById<EditText>(R.id.nickname_edit)
        //val nicknameTextView = findViewById<TextView>(R.id.nickname_text)

        //nicknameTextView.text = editText.text
        //editText.visibility = View.GONE
        //view.visibility = View.GONE
        //nicknameTextView.visibility = View.VISIBLE



        //Hide the Keyboard.
        val imn = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imn.hideSoftInputFromWindow(view.windowToken,0)


    }
}

