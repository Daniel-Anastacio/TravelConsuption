package com.danielanastacio.travelconsuption

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.danielanastacio.travelconsuption.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonCalculate.setOnClickListener(this)


    }
    override fun onClick(view: View) {
        if (view.id == R.id.buttonCalculate){
            calculate()
        }
    }
    private fun isValid():Boolean{
        return( binding.editDistance.text.toString() != ""
                && binding.editFuel.text.toString() != ""
                && binding.editAutonomy.text.toString() != ""
                && binding.editAutonomy.text.toString().toFloat() == 0f)
    }
    private fun calculate(){
        if(isValid()){
            val distance =  binding.editDistance.text.toString().toFloat()
            val fuel =  binding.editFuel.text.toString().toFloat()
            val autonomy =  binding.editAutonomy.text.toString().toFloat()

            val result = (distance*fuel)/autonomy
            val resultStr = "R$ ${"%.2f".format(result)}"

            binding.textResultPrice.text = resultStr
        }else{
            Toast.makeText(this, R.string.fill_in_all_fields, Toast.LENGTH_LONG).show()
        }


    }


}