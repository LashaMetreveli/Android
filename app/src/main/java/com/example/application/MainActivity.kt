package com.example.application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import com.example.application.databinding.ItemRecyclerViewBindingImpl

class MainActivity : AppCompatActivity() {


    private lateinit var adapter: ItemRecyclerViewAdapter
    private var items = ArrayList<ItemModel>()

    public val binding : com.example.application.databinding.ItemRecyclerViewBinding = DataBindingUtil.setContentView(this,R.layout.item_recycler_view)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getAllItems()
    }

    private fun getAllItems(){

        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = ItemRecyclerViewAdapter(items,this)
        recyclerView.adapter = adapter

        ItemDataLoader.getRequest("",object : CustomCallback{
            override fun onSuccess(result: String) {

                //parse JSON
                var itemModel = Gson().fromJson(result,ItemModel::class.java)

                val model = ItemModel(itemModel.titleEN,itemModel.descriptionEN,itemModel.cover)
                binding.setItemView(model)

                //add item to list
                items.add(itemModel)

                adapter.notifyDataSetChanged()

                //log url of cover image
                d("item cover url", "${itemModel.cover }")

            }
        })

    }
}