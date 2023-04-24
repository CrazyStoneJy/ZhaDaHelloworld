package me.crazystone.study.zhadahelloworld.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import me.crazystone.study.zhadahelloworld.R

class ListActivity: AppCompatActivity() {

    var recycler_list: RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        recycler_list = findViewById(R.id.recycler_list)
        recycler_list?.adapter = CustomAdapter(generateList())
        recycler_list?.layoutManager = LinearLayoutManager(this)
//        recycler_list.no

    }

    fun generateList(): MutableList<String> {
        val account = intent.getStringExtra("account")
        val time = intent.getIntExtra("time", 0)
        var list: MutableList<String> = mutableListOf()
        for (i in 1..time) {
            list.add(account!!)
        }
        Log.d("wtf", "list:" + list)
        return list
    }




}