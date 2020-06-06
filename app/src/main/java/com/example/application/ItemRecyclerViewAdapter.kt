package com.example.application


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_edit_layout.view.*
import kotlinx.android.synthetic.main.item_recyclerview_layout.view.*


class ItemRecyclerViewAdapter(private val items : ArrayList<ItemModel> ) : RecyclerView.Adapter<ItemRecyclerViewAdapter.ViewHolder>() {

    override fun getItemCount() = items.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private lateinit var item : ItemModel
        fun onBind() {
            item = items[adapterPosition]

            itemView.titleTextView.text = itemView.titleEditText.text
            itemView.descriptionTextView.text = itemView.descriptionEditText.text
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_recyclerview_layout,parent,false))
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.onBind()
    }


}

