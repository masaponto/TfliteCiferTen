package io.github.masaponto.tflitecifarten

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.Button
import android.widget.Toast
import java.io.File

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.button)
        val classifier = Classifier(this@MainActivity)
        val dir = File(Environment.getExternalStorageDirectory().path + "/DCIM/Camera")

        button.setOnClickListener {
            if (dir.exists()) {
                //val f = "IMG_20180825_095946.jpg" // dark
                val f = "P_20181216_182309_vHDR_On_HP.jpg"  // normal

                val path = dir.absolutePath + "/" + f
                val label = classifier.classifyImageFromPath(path)

                Toast.makeText(this, "result $label", Toast.LENGTH_LONG).show()
            }
        }
    }
}
