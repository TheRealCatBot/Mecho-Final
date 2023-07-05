package com.example.finaluri

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager

class C : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.vitamin_c)

        recyclerView = findViewById(R.id.recyclerView)

        val photoList = ArrayList<Photos>()
        photoList.add(Photos(1, "Nintendo Switch Sports", "Sport", R.drawable.img_21))
        photoList.add(Photos(2, "Mario Sports Mix", "Sport", R.drawable.img_22))
        photoList.add(Photos(3, "Mario Tennis Aces", "Sport", R.drawable.img_23))
        photoList.add(Photos(4, "Mario & Sonic", "Sport", R.drawable.img_24))
        photoList.add(Photos(5, "Excitebike", "Sport", R.drawable.img_25))
        photoList.add(Photos(1, "Mario Tennis", "Sport", R.drawable.img_26))
        photoList.add(Photos(2, "Mario Sports Superstars", "Sport", R.drawable.img_27))
        photoList.add(Photos(3, "Mario Hoops", "Sport", R.drawable.img_28))
        photoList.add(Photos(4, "Mario & Sonic", "Sport", R.drawable.img_29))
        photoList.add(Photos(5, "Mario Strikers", "Sport", R.drawable.img_30))


        val photoAdapter = PhotoAdapter(photoList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = photoAdapter
    }


}