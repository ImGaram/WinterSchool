package com.example.winterschool.diet_memo

import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.DatePicker
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.example.winterschool.R
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.util.*

class MainPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page)

        val writeBtn = findViewById<ImageView>(R.id.writeBtn)
        writeBtn.setOnClickListener {
            val mDialogView  = LayoutInflater.from(this).inflate(R.layout.custom_dialog, null)
            val mBuilder = AlertDialog.Builder(this)
                .setView(mDialogView)
                .setTitle("운동 메모 다이얼로그")

            val mAlertDialog = mBuilder.show()
            val dateSetBtn = mAlertDialog.findViewById<AppCompatButton>(R.id.data_select_btn)
            var dateText = ""

            dateSetBtn?.setOnClickListener {
                val today = GregorianCalendar()
                val year: Int = today.get(Calendar.YEAR)
                val month: Int = today.get(Calendar.MONTH)
                val date: Int = today.get(Calendar.DATE)
                val dlg = DatePickerDialog(this, object : DatePickerDialog.OnDateSetListener {
                    override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
                        Log.d("tag", "$p1 / ${p2 + 1} / $p3")
                        dateSetBtn.text = "$p1, ${p2 + 1}, $p3"
                        dateText = "$p1, ${p2 + 1}, $p3"
                    }
                }, year, month, date)
                dlg.show()
            }

            val saveBtn = mAlertDialog.findViewById<AppCompatButton>(R.id.save_btn)
            saveBtn?.setOnClickListener {
                val healthMemo = mAlertDialog.findViewById<EditText>(R.id.health_memo)?.text.toString()

                val database = Firebase.database
                val myRef = database.getReference("myMemo")

                val model = dataModel(dateText, healthMemo)

                myRef.setValue(model)
            }
        }
    }
}