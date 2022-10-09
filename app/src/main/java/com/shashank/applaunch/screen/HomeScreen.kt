package com.shashank.applaunch.screen

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.shashank.applaunch.Entity.User
import com.shashank.applaunch.R
import com.shashank.applaunch.viewmodel.UserViewModel
import com.shashank.todoapp.UserAdapter
import kotlinx.android.synthetic.main.home_screen.*


class HomeScreen : Fragment(R.layout.home_screen) {

    lateinit var viewMmodel: UserViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val adapter = UserAdapter()
        rv.adapter = adapter
        rv.layoutManager = LinearLayoutManager(activity)



        viewMmodel = ViewModelProviders.of(requireActivity()).get(UserViewModel::class.java)

        viewMmodel.allUser.observe(requireActivity(), Observer {

            adapter.update(it)

        })


        val simpleCallback = object : ItemTouchHelper.SimpleCallback(
            0, ItemTouchHelper.LEFT
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder,
            ): Boolean {
                TODO("Not yet implemented")
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

                val position = viewHolder.adapterPosition
                when (direction) {
                    ItemTouchHelper.LEFT -> {
                        viewMmodel.deleteNote(adapter.getNodeAt(position))
                        Toast.makeText(activity, "User Deleted Successful", Toast.LENGTH_SHORT)
                            .show()
                    }


                }
            }

        }


        val itemTouchHelper = ItemTouchHelper(simpleCallback)
        itemTouchHelper.attachToRecyclerView(rv)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.top_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_home -> {
                // navigate to settings screen
                findNavController().navigate(R.id.action_homeScreen_to_addUserScreen)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}