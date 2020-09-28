package com.alejoestrada.conversor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        conversion_botton.setOnClickListener {
            val primermoneda = argent_spinner.selectedItem
            val segmoneda = argent2_spinner.selectedItem
            val inputvalue = rfinal_edit_text.text.toString().toDouble()
            var valor_convertido=0.0
            var vfin= ""

            if (primermoneda == "Peso" && segmoneda == "Euro"){

                valor_convertido= inputvalue/4460
                vfin= "€" + valor_convertido.toString()
            }else if (primermoneda == "Peso" && (segmoneda == "Libra" || segmoneda == "Pound")){

                valor_convertido= inputvalue/4856
                vfin= "£" + valor_convertido.toString()
            }else if (primermoneda == "Euro" && (segmoneda == "Libra" || segmoneda == "Pound")){

                valor_convertido= inputvalue*0.92
                vfin= "£" + valor_convertido.toString()
            }else if (primermoneda == "Euro" && segmoneda == "Peso"){

                valor_convertido= inputvalue*4460
                vfin= "$" + valor_convertido.toString()

            }else if ((primermoneda == "Libra" || primermoneda == "Pound") && segmoneda == "Euro"){

                valor_convertido= inputvalue*1.09
                vfin= "€" + valor_convertido.toString()

            }else if ((primermoneda == "Libra" || primermoneda == "Pound") && segmoneda == "Peso"){

                val valor_convertido= inputvalue*4856
                vfin= "$" + valor_convertido.toString()
            }

            resultadoreal_textview.setText(vfin)
         }
    }
}