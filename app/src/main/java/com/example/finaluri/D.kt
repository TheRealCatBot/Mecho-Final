package com.example.finaluri

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager

class D : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.vitamin_c)

        recyclerView = findViewById(R.id.recyclerView)

        val photoList = ArrayList<Photos>()
        photoList.add(Photos(1, "თევზის ქონი", "Vitamin D - 250 mcg", R.drawable.tevzis_qoni_250mcg))
        photoList.add(Photos(2, "ორაგული", "Vitamin D - 34 mcg", R.drawable.oraguli_34_1))
        photoList.add(Photos(3, "სოკო", "Vitamin D - 32 mcg", R.drawable.soko_32))
        photoList.add(Photos(4, "მარგარინი", "Vitamin D - 17.5 mcg", R.drawable.margarini_17_5))
        photoList.add(Photos(5, "რძე", "Vitamin D - 11 mcg", R.drawable.rdze_11))
        photoList.add(Photos(1, "კვერცხი", "Vitamin D - 10.4 mcg", R.drawable.kvercxi_10_4))
        photoList.add(Photos(2, "ბრინჯი", "Vitamin D - 7.6 mcg", R.drawable.brinji_7_6))
        photoList.add(Photos(3, "მარცვლეული", "Vitamin D - 7.6 mcg", R.drawable.marcvleulis_fanteli_7_6))
        photoList.add(Photos(4, "ყველი", "Vitamin D - 7.5 mcg", R.drawable.yveli_7_5))
        photoList.add(Photos(5, "კაკაო", "Vitamin D - 4.8 mcg", R.drawable.kakao_4_8))

        val photoAdapter = PhotoAdapter(photoList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = photoAdapter
    }


}