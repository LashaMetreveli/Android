package com.example.application

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


     val items = ArrayList<ContactModel>()

    private lateinit var adapter: RecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }


    private fun init(){

        addContactButton.setOnClickListener{
            items.add(ContactModel(R.drawable.contact,"contact new","description","11/07/2021"))
            adapter.notifyItemInserted(items.size-1)
            recyclerView.scrollToPosition(items.size-1)
        }


        addData()

        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = RecyclerViewAdapter(items, this)
        recyclerView.adapter = adapter
    }

    private fun addData(){
        items.add(ContactModel(R.drawable.contact,"contact 1","description","11/07/2019"))
        items.add(ContactModel(R.drawable.contact,"contact 2","description","22/03/2018"))
        items.add(ContactModel(R.drawable.contact,"contact 3","description","4/05/2018"))
        items.add(ContactModel(R.drawable.contact,"contact 4","description","7/05/2018"))
        items.add(ContactModel(R.drawable.contact,"contact 5","description","3/05/2018"))
        items.add(ContactModel(R.drawable.contact,"contact 6","description","1/05/2017"))

    }
}
