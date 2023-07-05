package com.example.finaluri

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class B : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.vitamin_c)

        recyclerView = findViewById(R.id.recyclerView)

        val photoList = ArrayList<Photos>()
        photoList.add(Photos(1, "King's Quest", "Adventure", R.drawable.img_10))
        photoList.add(Photos(2, "Amber: Journeys Beyond", "Adventure", R.drawable.img_11))
        photoList.add(Photos(3, "Stray", "Adventure", R.drawable.img_12))
        photoList.add(Photos(4, "Maniac Mansion", "Adventure", R.drawable.img_13))
        photoList.add(Photos(5, "The Dig", "Adventure", R.drawable.img_14))
        photoList.add(Photos(1, "The Black Mirror", "Adventure", R.drawable.img_15))
        photoList.add(Photos(2, "Loom", "Adventure", R.drawable.img_16))
        photoList.add(Photos(3, "Beneath a Steel Sky", "Adventure", R.drawable.img_17))
        photoList.add(Photos(4, "Day of the Tentacle", "Adventure", R.drawable.img_18))
        photoList.add(Photos(5, "Discworld II", "Adventure", R.drawable.img_19))
        photoList.add(Photos(6, "The Book of Unwritten Tales", "Adventure", R.drawable.img_20))


        val photoAdapter = PhotoAdapter(photoList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = photoAdapter
    }


}