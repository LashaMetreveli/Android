package com.example.application

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.user_recycler_view.view.*

class UserRecyclerViewAdapter(
    private val users: ArrayList<UserListModel.Data>,
    private val activity: MainActivity
) :
    RecyclerView.Adapter<UserRecyclerViewAdapter.ViewHolder>() {

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.user_recycler_view, parent,
                false
            )
        )
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private lateinit var userModel:UserListModel.Data

        fun onBind(){

            userModel = users[adapterPosition]

            Glide.with(activity).load(userModel.avatar)
                .into(itemView.imageView)

            itemView.userIdTextView.text = " id: "+userModel.id.toString()
            itemView.userFirstNameTextView.text = " first name: "+userModel.firstName
            itemView.userLastNameTextView.text = " last name: "+userModel.lastName
            itemView.userEmailTextView.text = " email: "+userModel.email
        }
    }


}