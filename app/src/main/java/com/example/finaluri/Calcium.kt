package com.example.finaluri

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager

class Calcium : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.vitamin_c)

        recyclerView = findViewById(R.id.recyclerView)

        val photoList = ArrayList<Photos>()
        photoList.add(Photos(1, "ყველი", "კალცი - 1360 mg", R.drawable.yveli_7_5))
        photoList.add(Photos(2, "რძე", "კალცი - 1257 mg", R.drawable.rdze_11))
        photoList.add(Photos(3, "პური", "კალცი - 800 mg", R.drawable.puri_41))
        photoList.add(Photos(4, "კარტოფილი", "კალცი - 758 mg", R.drawable.kartofili_85_51))
        photoList.add(Photos(5, "ლობიო", "კალცი - 504 mg", R.drawable.lobionagdi_30))
        photoList.add(Photos(1, "კვერცხი", "კალცი - 50 mg", R.drawable.kvercxi_10_4))
        photoList.add(Photos(2, "მზესუმზირა", "კალცი - 73 mg", R.drawable.mzesumzira_36_33))
        photoList.add(Photos(3, "არაქისის კარაქი", "კალცი - 43 mg", R.drawable.araqisis_karaqi_43_4))
        photoList.add(Photos(4, "ხორბალი", "კალცი - 17 mg", R.drawable.xorbali_150))
        photoList.add(Photos(5, "ბანანი", "კალცი - 5 mg", R.drawable.banani_0_36))



        val photoAdapter = PhotoAdapter(photoList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = photoAdapter
    }


}