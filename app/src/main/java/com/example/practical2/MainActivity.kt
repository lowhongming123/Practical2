package com.example.practical2

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener {
            CalculateBMI()
        }

        buttonReset.setOnClickListener{
            Reset()
        }
    }



    private fun CalculateBMI(){

        if(editTextWeight.text.isEmpty()){
            editTextWeight.setError(getString(R.string.input_error))
            return
        }

        if(editTextHeight.text.isEmpty()){
            editTextHeight.setError(getString(R.string.input_error))
            return
        }

        val weight=editTextWeight.text.toString().toFloat()
        val height=editTextHeight.text.toString().toFloat()
        val bmi= weight/ (height/100).pow(2)

        if(bmi < 18.5){
            textViewBMI.text=String.format("%s %.2f (%s)",getString(R.string.bmi),bmi,getString(R.string.under))
            imageViewProfilePicture.setImageResource(R.drawable.under)
        }else if(bmi < 25 && bmi>=18.5){
            textViewBMI.text=String.format("%s %.2f (%s)",getString(R.string.bmi),bmi,getString(R.string.normal))
            imageViewProfilePicture.setImageResource(R.drawable.normal)
        }else if(bmi >=25){
            textViewBMI.text=String.format("%s %.2f (%s)",getString(R.string.bmi),bmi,getString(R.string.over))
            imageViewProfilePicture.setImageResource(R.drawable.over)
        }
    }

    private fun Reset() {
        editTextWeight.text.clear()
        editTextHeight.text.clear()
        imageViewProfilePicture.setImageResource(Activity.RESULT_CANCELED)


    }
}
