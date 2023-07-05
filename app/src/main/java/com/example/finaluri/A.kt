package com.example.finaluri

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager

class A : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.vitamin_c)

        recyclerView = findViewById(R.id.recyclerView)

        val photoList = ArrayList<Photos>()
        photoList.add(Photos(1, "God of War", "Action", R.drawable.img))
        photoList.add(Photos(2, "Red Dead Redemption 2", "Action", R.drawable.img_1))
        photoList.add(Photos(3, "Star Wars Jedi", "Action", R.drawable.img_2))
        photoList.add(Photos(4, "Marvel's Spider-Man", "Action", R.drawable.img_3))
        photoList.add(Photos(5, "Elden Ring", "Action", R.drawable.img_4))
        photoList.add(Photos(1, "The Witcher 3", "Action", R.drawable.img_5))
        photoList.add(Photos(2, "The Last of Us Part II", "Action", R.drawable.img_6))
        photoList.add(Photos(3, "Marvel's Spider-Man", "Action", R.drawable.img_7))
        photoList.add(Photos(4, "Grand Theft Auto V", "Action", R.drawable.img_8))
        photoList.add(Photos(5, "Death Stranding", "Action", R.drawable.img_9))


        val photoAdapter = PhotoAdapter(photoList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = photoAdapter
    }


}