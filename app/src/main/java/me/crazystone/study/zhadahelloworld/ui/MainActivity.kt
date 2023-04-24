package me.crazystone.study.zhadahelloworld.ui

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import me.crazystone.study.zhadahelloworld.viewmodel.CityViewModel
import androidx.activity.viewModels
import me.crazystone.study.zhadahelloworld.R

class MainActivity : AppCompatActivity() {

    var etAccount: EditText? = null
    var account: String? = null
    var tvAccount: TextView? = null
    var etTime: EditText? = null
    var tvTime: TextView? = null
    var time: Int? = null
    var btnCommit: Button? = null

    val cityViewModel: CityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etAccount = findViewById(R.id.et_account)
        tvAccount = findViewById(R.id.tv_account)
        etTime = findViewById(R.id.et_time)
        tvTime = findViewById(R.id.tv_time)

        cityViewModel.getMessageData().observe(this, { message ->
            Log.d("wtf", "update data:" + message)
            tvAccount?.text = message
        })

        cityViewModel.getList().observe(this, { messages ->
            Log.d("wtf", "update list:" + messages.toString())
        })


        etAccount?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//                account = s.toString()
//                Log.d("wtf", "text:" + account)
//                tvAccount?.text = account
//                cityViewModel.update(s.toString())
                cityViewModel.add(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })

        etTime?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val str = s.toString()
                if (!str.equals("")) {
                    time = str.toInt()
                    Log.d("wtf", "time:" + str)
                    tvTime?.text = formatTime(time!!)
                } else {
                    tvTime?.text = ""
                }
            }

            override fun afterTextChanged(s: Editable?) {
            }

        })

        btnCommit = findViewById(R.id.bt_commit)
        btnCommit?.setOnClickListener {
            val intent = Intent()
            intent.putExtra("account", account)
            intent.putExtra("time", time)
            intent.setClass(this@MainActivity, ListActivity::class.java)
            startActivity(intent)
        }

    }

    fun formatTime(time: Int): String {
        var sb: StringBuilder = StringBuilder()
        if ((time / 60) == 0) {
            sb.append(time)
            sb.append("s")
        } else if ((time / (60 * 60)) == 0) {
            sb.append(time / 60)
            sb.append("m")
            sb.append(time % 60)
            sb.append("s")
        }
        Log.d("wtf", "sb:" + sb.toString())
        return sb.toString()
    }

}