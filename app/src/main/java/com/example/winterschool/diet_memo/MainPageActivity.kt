package com.example.winterschool.diet_memo

import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.DatePicker
import android.widget.EditText
import android.widget.ImageView
import android.widget.ListView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.example.winterschool.R
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.util.*

class MainPageActivity : AppCompatActivity() {

    val dataModelList = mutableListOf<dataModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page)
        val database = Firebase.database
        val myRef = database.getReference("myMemo")

        val listView = findViewById<ListView>(R.id.main_listview)
        val adapter = ListViewAdapter(dataModelList)

        Log.d("data", dataModelList.toString())

        listView.adapter = adapter

        myRef.child(Firebase.auth.currentUser!!.uid).addValueEventListener(object :ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                dataModelList.clear()
                for (dataModel in snapshot.children) {
                    Log.d("data", dataModel.toString())
                    dataModelList.add(dataModel.getValue(com.example.winterschool.diet_memo.dataModel::class.java)!!)
                }
                adapter.notifyDataSetChanged()

            }
            override fun onCancelled(error: DatabaseError) {  }
        })

        val writeBtn = findViewById<ImageView>(R.id.writeBtn)
        writeBtn.setOnClickListener {
            val mDialogView  = LayoutInflater.from(this).inflate(R.layout.custom_dialog, null)
            val mBuilder = AlertDialog.Builder(this)
                .setView(mDialogView)
                .setTitle("?????? ?????? ???????????????")

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
                val myRef = database.getReference("myMemo").child(Firebase.auth.currentUser!!.uid)

                val model = dataModel(dateText, healthMemo)
                myRef.push().setValue(model)

                mAlertDialog.dismiss()
            }
        }
    }
}