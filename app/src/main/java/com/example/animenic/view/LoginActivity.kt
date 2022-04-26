package com.example.animenic.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import com.example.animenic.R
import com.example.animenic.databinding.ActivityLoginBinding
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.etName.addTextChangedListener { validateFields(binding.tilUsername) }
        binding.etPass.addTextChangedListener { validateFields(binding.tilPassword) }

        binding.btnLogin.setOnClickListener {
            if(validateFields(binding.tilPassword,binding.tilUsername)) {
                val intent = Intent(this, MenuActivity::class.java)
                startActivity(intent)
            }
        }

        binding.tvCrearcuenta.setOnClickListener{
            val intent = Intent(this, CrearCuentaActivity::class.java)
            startActivity(intent)
        }

    }

    private fun validateFields(vararg textFields: TextInputLayout): Boolean {
        var isValid = true

        for(textField in textFields) {
            if (textField.editText?.text.toString().trim().isEmpty()) {
                textField.error = getString(R.string.helper_text_require)
                isValid = false
            } else textField.error = null
        }

        if(!isValid) Snackbar.make(binding.root,
            R.string.login_activity_message_valid,
            Snackbar.LENGTH_SHORT).show()


        return isValid
    }
}