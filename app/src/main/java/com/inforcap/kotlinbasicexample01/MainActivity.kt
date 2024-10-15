package com.inforcap.kotlinbasicexample01

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.inforcap.kotlinbasicexample01.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        binding.fabHome.visibility = View.GONE
        var fabVisibles: Boolean = false

        binding.textviewHelloWord1.setText("Hola Mundo!!!!")

        binding.textviewHelloWord1.setOnClickListener {
            binding.textviewHelloWord1.setText("Por qué me habeís presionado????")
        }

        binding.textInputEditTextNombre.addTextChangedListener(object :  TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                var texto : String? = p0.toString()
                mostrarTexto(texto)
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })

        binding.fabAdd.setOnClickListener {
            if (!fabVisibles) {
                binding.fabHome.show()
                fabVisibles = true
            }
            else {
                binding.fabHome.hide()
                fabVisibles = false
            }

            var nombre :String? = binding.textInputEditTextNombre.text.toString()
            Toast.makeText(this,nombre,Toast.LENGTH_SHORT).show()
        }


        binding.fabHome.setOnClickListener {
            Toast.makeText(this,"Presionaste el boton HOME",Toast.LENGTH_SHORT).show()
        }





        enableEdgeToEdge()



        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(p0: View?) {

    }

    fun mostrarTexto(texto:String?){
        Toast.makeText(this,texto,Toast.LENGTH_SHORT).show()
    }
}