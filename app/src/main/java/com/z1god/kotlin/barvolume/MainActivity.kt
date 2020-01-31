package com.z1god.kotlin.barvolume

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_calculate.setOnClickListener {
            val inputLength = edt_length.text.toString().trim()
            val inputHeight = edt_height.text.toString().trim()
            val inputWidth  = edt_width.text.toString().trim()

            var isEmpty = false

            if (inputLength.isEmpty()){
                isEmpty = true
                til_length.error = resources.getString(R.string.no_empty_field)
                YoYo.with(Techniques.Shake)
                    .duration(1000)
                    .playOn(edt_length)
            }else{
                til_length.error = null
            }

            if (inputWidth.isEmpty()){
                isEmpty = true
                til_width.error = resources.getString(R.string.no_empty_field)
                YoYo.with(Techniques.Shake)
                    .duration(1000)
                    .playOn(edt_width)
            }else{
                til_width.error = null
            }

            if (inputHeight.isEmpty()){
                isEmpty = true
                til_height.error = resources.getString(R.string.no_empty_field)
                YoYo.with(Techniques.Shake)
                    .duration(1000)
                    .playOn(edt_height)
            }else{
                til_height.error = null
            }

            if (!isEmpty){
                val volume = inputHeight.toDouble() * inputWidth.toDouble() * inputLength.toDouble()
                tv_result.text = volume.toString()
                YoYo.with(Techniques.FadeIn)
                    .duration(1500)
                    .playOn(tv_result)
            }
        }
    }
}
