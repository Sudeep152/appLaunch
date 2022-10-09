package com.shashank.todoapp

import android.app.Application
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shashank.applaunch.Entity.User
import com.shashank.applaunch.R
import kotlinx.android.synthetic.main.single_user.view.*

class UserAdapter() : RecyclerView.Adapter<UserAdapter.viewHolder>() {

    val list:ArrayList<User> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {

        val view =LayoutInflater.from(parent.context).inflate(R.layout.single_user,parent,false)
        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {

        val current =list[position]
        holder.Vtitle.text=current.firstName
        holder.Vsubtitle.text=current.lastName
        holder.Vdate.text=current.email


    }

    fun update(newTod:List<User>){
        list.clear()
        list.addAll(newTod)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class viewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val Vtitle =itemView.titleTxt
        val Vsubtitle =itemView.subTitleTxt
        val Vdate =itemView.datatxt

    }


    fun getNodeAt( position: Int):User{
        return list.get(position)
    }

}