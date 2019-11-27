package kr.hs.emirim.ksh20713.todaystrash

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    //오늘날짜로 업데이트 하기 위한거.
    internal var now = System.currentTimeMillis()
    internal var date = Date(now)
    internal var sdfNow = SimpleDateFormat("yyyy/MM/dd ")
    internal var formatDate = sdfNow.format(date)
    internal lateinit var dateNow: TextView

    override fun onCreate(savedInstanceState: Bundle?) {

        val filename = "data.txt"

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dateNow = findViewById(R.id.dateText) as TextView
        dateNow.setText(formatDate)

        record.setOnClickListener {
            startActivity(Intent(this@MainActivity, RecordActivity::class.java))
        }
        save.setOnClickListener {
            val text = inputTrash1.text.toString()
            when {
                TextUtils.isEmpty(text) -> {
                    Toast.makeText(applicationContext, "입력한게 없습니다...", Toast.LENGTH_LONG).show()
                }
                else -> {
                    saveToInnerStorage(text, filename)
                }
            }
        }
    }

    fun saveToInnerStorage(text: String,filename: String){
        val fileOutputStream = openFileOutput(filename, Context.MODE_PRIVATE)

        fileOutputStream.write(text.toByteArray())

        fileOutputStream.close()
    }
}
