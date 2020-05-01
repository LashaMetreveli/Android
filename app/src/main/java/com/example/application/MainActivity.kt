package com.example.application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    private lateinit var adapter: UserRecyclerViewAdapter
    private var users = ArrayList<UserListModel.Data>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //call method
         getAllUsers()
    }


    private fun getAllUsers(){


        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = UserRecyclerViewAdapter(users,this)
        recyclerView.adapter = adapter

        //getRequest with path users
        DataLoader.getRequest("users",object : CustomCallback{
            override fun onSuccess(result: String) {


                //parse JSON
                var userModel = Gson().fromJson(result,UserListModel::class.java)

                //add users to list
                users.addAll(userModel.data)

                adapter.notifyDataSetChanged()

                // see count of users
                d("userCount", "${userModel.data.size }")

                //see avatar of second user
                d("userCount", "${userModel.data[1].avatar }")

            }
        })



    }



}
