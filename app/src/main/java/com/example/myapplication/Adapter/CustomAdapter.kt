package com.example.myapplication.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amulyakhare.textdrawable.TextDrawable
import com.amulyakhare.textdrawable.util.ColorGenerator.MATERIAL
import com.example.myapplication.Model.User
import com.example.myapplication.R
import kotlinx.android.synthetic.main.list_layout.view.*


class CustomAdapter(private val userList: ArrayList<User>) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    var mSelectedItem = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_layout, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return userList.size;
    }

    fun getSelectedItem(): Int {
        return mSelectedItem
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(userList[position])
        holder.itemView.radioButtonCheck.setChecked(position == mSelectedItem);
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(user: User) {
            val textViewName = itemView.textViewUsername
            val textViewAddress = itemView.textViewAddress
            val itemImage = itemView.itemImage
            val radioButtonCheck = itemView.radioButtonCheck
            textViewName.text = user.name
            textViewAddress.text = user.address


            //*******************initial two latter taken string********************
            val generator = MATERIAL
            val color = generator.randomColor
            val arr: List<String> = user.name.split(" ")
            if (!arr.isNullOrEmpty() && arr.size > 0 && !arr.equals(" ")) {
                var initials = arr[0].substring(0, 1)
                if (arr.size > 1) {
                   // initials += arr[1].substring(0, 1).capitalize()
                    initials +=  arr.last()[0]
                }
                val drawable = TextDrawable.builder()
                    .beginConfig()
                    .toUpperCase()
                    .bold()
                    .endConfig()
                    .buildRound(initials, MATERIAL.getColor(user.name))
                itemImage.setImageDrawable(drawable)
            }

            //*******************initial two latter taken string********************


            itemView.radioButtonCheck.setOnClickListener {
                mSelectedItem = getAdapterPosition()
                notifyDataSetChanged();
            }

        }
    }
}