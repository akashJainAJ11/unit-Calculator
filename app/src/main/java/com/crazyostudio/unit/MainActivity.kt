package com.crazyostudio.unit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.AdapterView

import android.widget.ArrayAdapter
import com.crazyostudio.unit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    lateinit var binding: ActivityMainBinding
    var unit = arrayOf("kg-pound","pound-kg","m-cm","cm-m")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.Spinner.onItemSelectedListener = this
        val aa:ArrayAdapter<*> = ArrayAdapter<Any?>(this,android.R.layout.simple_spinner_item,unit)
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.Spinner.adapter = aa
        binding.input.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (binding.input.text.toString().isNotEmpty())
                {
                    if (binding.Spinner.selectedItemPosition.toString().equals("0")){
                        val ans : Double = binding.input.text.toString().toDouble() * 2.20462262
                        binding.answer.text = ans.toFloat().toString()
                        }else if (binding.Spinner.selectedItemPosition.toString().equals("1")){
                            val ans : Double = binding.input.text.toString().toDouble() * 0.45359237
                            binding.answer.text = ans.toFloat().toString()
                        }
                    else if (binding.Spinner.selectedItemPosition.toString().equals("2")){
                        val ans : Double = binding.input.text.toString().toDouble() * 100
                        binding.answer.text = ans.toFloat().toString()
                    }
                    else if (binding.Spinner.selectedItemPosition.toString().equals("3")){
                        val ans : Double = binding.input.text.toString().toDouble() / 100
                        binding.answer.text = ans.toFloat().toString()
                    }
                 }
                }



            override fun afterTextChanged(p0: Editable?) {
            }
        });

        }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
    }
}
