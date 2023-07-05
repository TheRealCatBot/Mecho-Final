package com.example.finaluri

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager

class Fats : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.vitamin_c)

        recyclerView = findViewById(R.id.recyclerView)

        val photoList = ArrayList<Photos>()
        photoList.add(Photos(1, "მარგარინი", "ცხიმები - 81 g", R.drawable.margarini_17_5))
        photoList.add(Photos(2, "ცხვარი", "ცხიმები - 21 g", R.drawable.cxvari_66200))
        photoList.add(Photos(3, "ძროხა", "ცხიმები - 15 g", R.drawable.dzroxa_94000))
        photoList.add(Photos(4, "ავოკადო", "ცხიმები - 15 g", R.drawable.avokado))
        photoList.add(Photos(5, "ზეთისხილი", "ცხიმები - 14 g", R.drawable.zetis))
        photoList.add(Photos(1, "ქათამი", "ცხიმები - 14 g", R.drawable.qatami))
        photoList.add(Photos(2, "ქორი", "ცხიმები - 14 g", R.drawable.gori))
        photoList.add(Photos(3, "მზესუმზირა", "ცხიმები - 14 g", R.drawable.mzesumzira_36_33))
        photoList.add(Photos(4, "ლობიანი", "ცხიმები - 2.1 g", R.drawable.lobionagdi_30))
        photoList.add(Photos(5, "არაქისის კარაქი", "ცხიმები - 50 g", R.drawable.araqisis_karaqi_43_4))


        val photoAdapter = PhotoAdapter(photoList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = photoAdapter
    }


}