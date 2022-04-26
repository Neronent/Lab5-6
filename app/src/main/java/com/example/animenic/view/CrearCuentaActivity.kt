package com.example.animenic.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.example.animenic.R
import com.example.animenic.databinding.ActivityCrearCuentaBinding
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout

class CrearCuentaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCrearCuentaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCrearCuentaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar: androidx.appcompat.widget.Toolbar = binding.toolCrearCuenta
        setSupportActionBar(toolbar)
        supportActionBar!!.title = "Crear cuenta"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        binding.etEmail.addTextChangedListener { validateFields(binding.tilEmail) }
        binding.etName.addTextChangedListener { validateFields(binding.tilName) }
        binding.etPass.addTextChangedListener { validateFields(binding.tilpass) }
        binding.etConfirmPass.addTextChangedListener { validateFields(binding.tilConfirmPass) }

        binding.btnCrearCuenta.setOnClickListener {
            if(validateFields(binding.tilConfirmPass, binding.tilpass, binding.tilName,binding.tilEmail) && validatePass(binding.etPass.text.toString().trim(),binding.etConfirmPass.text.toString().trim())) {
                Toast.makeText(this, "El usuario ha sido creado exitosamente", Toast.LENGTH_SHORT)
                    .show()
                val intent = Intent(this, MenuActivity::class.java)
                startActivity(intent)
            }
        }
        //findViewById<TextView>() = binding.etName.text.toString()
    }

    private fun validatePass(pass1: String, pass2: String): Boolean {
        var isValid = false

        if(pass1 == pass2) {
            isValid = true
        }

        if(!isValid) Snackbar.make(binding.root,
            R.string.login_activity_message_valid,
            Snackbar.LENGTH_SHORT).show()


        return isValid
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