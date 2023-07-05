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
        photoList.add(Photos(1, "მარწყვი", "Vitamin C - 58.8 mg", R.drawable.marwyvi_58_8))
        photoList.add(Photos(2, "ფორთოხალი", "Vitamin C - 53.2 mg", R.drawable.orange))
        photoList.add(Photos(3, "ლიმონი", "Vitamin C - 53 mg", R.drawable.lemon))
        photoList.add(Photos(4, "ლიმონი", "Vitamin C - 48 mg", R.drawable.clementines_48_8))
        photoList.add(Photos(5, "ლიმონი", "Vitamin C - 47.8 mg", R.drawable.ananasi))
        photoList.add(Photos(1, "ლიმონი", "Vitamin C - 38.8 mg", R.drawable.jolo))
        photoList.add(Photos(2, "ლიმონი", "Vitamin C - 37 mg", R.drawable.yurdzeni))
        photoList.add(Photos(3, "ლიმონი", "Vitamin C - 36.4 mg", R.drawable.mango))
        photoList.add(Photos(4, "ლიმონი", "Vitamin C - 36 mg", R.drawable.nesvi))
        photoList.add(Photos(5, "ლიმონი", "Vitamin C - 17 mg", R.drawable.avokado))


        val photoAdapter = PhotoAdapter(photoList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = photoAdapter
    }


}