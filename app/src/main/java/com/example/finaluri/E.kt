package com.example.finaluri

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager

class E : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.vitamin_c)

        recyclerView = findViewById(R.id.recyclerView)

        val photoList = ArrayList<Photos>()
        photoList.add(Photos(1, "ხორბალი", "Vitamin E - 150 mg", R.drawable.xorbali_150))
        photoList.add(Photos(2, "ფანტელები", "Vitamin E - 80,46mg", R.drawable.fantelebi_80_46))
        photoList.add(Photos(3, "არაქისის კარაქი", "Vitamin E - 43,4 mg", R.drawable.araqisis_karaqi_43_4))
        photoList.add(Photos(4, "ჩილი", "Vitamin E - 38,14 mg", R.drawable.chili_38_14))
        photoList.add(Photos(5, "მზესუმზირა", "Vitamin E - 36,33 mg", R.drawable.mzesumzira_36_33))
        photoList.add(Photos(1, "პაპრიკა", "Vitamin E - 29,1 mg", R.drawable.paprika_29_1))
        photoList.add(Photos(2, "მანგო", "Vitamin E - 4,02 mg", R.drawable.mango))
        photoList.add(Photos(3, "ავოკადო", "Vitamin E - 2,66 mg", R.drawable.avokado))
        photoList.add(Photos(4, "მოცვი(ლურჯი)", "Vitamin E - 2,25 mg", R.drawable.mocvi_2_25))
        photoList.add(Photos(5, "მოცვი(წითელი)", "Vitamin E - 2,1 mg", R.drawable.mocvi_witeli_2_1))



        val photoAdapter = PhotoAdapter(photoList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = photoAdapter
    }


}