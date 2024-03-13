package com.hw11

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hw11.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var repository = Repository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textView.text = repository.getText(this)

        binding.buttonSaveText.setOnClickListener {
            repository.saveText(this, binding.editText.text.toString())
            binding.textView.text = repository.getText(this)
        }

        binding.buttonClearText.setOnClickListener {
            repository.clearText(this)
            binding.textView.text = repository.getText(this)
        }
    }
}