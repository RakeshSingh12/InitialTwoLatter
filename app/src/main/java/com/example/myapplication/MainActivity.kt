package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.Adapter.CustomAdapter
import com.example.myapplication.Model.User
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager =LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        val  users = ArrayList<User>()
        users.add(User("Rakesh kumar Singh","Gopalganj Bihar",false))
        users.add(User("Rekha kumari","Gopalganj2 Bihar2",true))
        users.add(User("Niraj","Gopalganj3 Bihar3",true))
        users.add(User("Trishika Singh","Gopalganj1 Bihar1",true))
        users.add(User("Testing","siwan Bihar",false))
        val  adapter = CustomAdapter(users)
        recyclerView.adapter = adapter
    }
}