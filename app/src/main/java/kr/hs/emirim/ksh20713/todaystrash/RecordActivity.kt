package kr.hs.emirim.ksh20713.todaystrash

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_record.*
import java.io.FileNotFoundException
import java.text.SimpleDateFormat
import java.util.*

class RecordActivity : Activity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        setContentView(R.layout.activity_record)

        gotoMonthly.setOnClickListener {
            startActivity(Intent(this@RecordActivity, monthlyRecordActivity::class.java))
        }
        try {
            loadText.setText(loadFromInnerStorage(filename="data.txt"))
        }catch (e: FileNotFoundException){
            Toast.makeText(applicationContext,"저장된 쓰레기가 없습니다.",Toast.LENGTH_LONG).show()
        }
    }
    fun loadFromInnerStorage(filename:String): String{
        val fileInputStream= openFileInput(filename)
        return fileInputStream.reader().readText()
    }
}