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
        photoList.add(Photos(1, "ბანანი", "Vitamin B - 0.36 mg", R.drawable.banani_0_36))
        photoList.add(Photos(2, "მანგო", "Vitamin B - 0.33 mg", R.drawable.mango))
        photoList.add(Photos(3, "ვაშლი", "Vitamin B - 0.26 mg", R.drawable.vashli))
        photoList.add(Photos(4, "ფორთოხალი", "Vitamin B - 0.28 mg", R.drawable.orange))
        photoList.add(Photos(5, "ჟოლო", "Vitamin B - 0.25 mg", R.drawable.jolo))
        photoList.add(Photos(1, "ანანასი", "Vitamin B - 0.25 mg", R.drawable.ananasi))
        photoList.add(Photos(2, "ნესვი", "Vitamin B - 0.16 mg", R.drawable.nesvi))
        photoList.add(Photos(3, "ატამი", "Vitamin B - 0.15 mg", R.drawable.atami))
        photoList.add(Photos(4, "ყურძენი", "Vitamin B - 0.11mg", R.drawable.yurdzeni))
        photoList.add(Photos(5, "ალუბალი", "Vitamin B - 0.1 mg", R.drawable.alubali))
        photoList.add(Photos(6, "ავოკადო", "Vitamin B - 0.07 mg", R.drawable.avokado))


        val photoAdapter = PhotoAdapter(photoList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = photoAdapter
    }


}