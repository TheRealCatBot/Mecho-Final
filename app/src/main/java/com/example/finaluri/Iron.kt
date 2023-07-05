package com.example.finaluri

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager

class Iron : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.vitamin_c)

        recyclerView = findViewById(R.id.recyclerView)

        val photoList = ArrayList<Photos>()
        photoList.add(Photos(1, "ირმის ხორცი", "რკინა - 4.5 mg", R.drawable.iremi_96000))
        photoList.add(Photos(2, "ძროხის ხორცი", "რკინა - 2.6 mg", R.drawable.dzroxa_94000))
        photoList.add(Photos(3, "ატამი", "რკინა - 2.1 mg", R.drawable.atami))
        photoList.add(Photos(4, "ვაშლი", "რკინა - 2 mg", R.drawable.vashli))
        photoList.add(Photos(5, "ცხვრის ხორცი", "რკინა - 1.9 mg", R.drawable.cxvari_66200))
        photoList.add(Photos(1, "ალუბალი", "რკინა - 1.37 mg", R.drawable.alubali))
        photoList.add(Photos(2, "ქათმის ხორცი", "რკინა - 1.3 mg", R.drawable.qatami))
        photoList.add(Photos(3, "ჟოლო", "რკინა - 1.08 mg", R.drawable.jolo))
        photoList.add(Photos(4, "ღორი", "რკინა - 0.9 mg", R.drawable.gori))
        photoList.add(Photos(5, "კვერცხი", "რკინა - 1.4 mg", R.drawable.kvercxi_10_4))


        val photoAdapter = PhotoAdapter(photoList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = photoAdapter
    }


}