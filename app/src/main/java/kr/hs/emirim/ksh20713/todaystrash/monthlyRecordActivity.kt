package kr.hs.emirim.ksh20713.todaystrash

import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_record.*
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.*

class monthlyRecordActivity : AppCompatActivity(){
    //오늘날짜로 업데이트 하기 위한거.
    internal var now = System.currentTimeMillis()
    internal var date = Date(now)
    internal var sdfNow = SimpleDateFormat("yyyy년 MM월 dd일 ")
    internal var formatDate = sdfNow.format(date)
    internal lateinit var dateNow: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.record_monthly)

        dateNow = findViewById(R.id.textView_date) as TextView
        dateNow.setText(formatDate)
    }
}