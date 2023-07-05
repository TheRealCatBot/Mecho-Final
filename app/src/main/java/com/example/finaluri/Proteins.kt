package com.example.finaluri

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager

class Proteins : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.vitamin_c)

        recyclerView = findViewById(R.id.recyclerView)

        val photoList = ArrayList<Photos>()
        photoList.add(Photos(1, "ღორის ხორცი", "პროტეინი - 27 g", R.drawable.gori))
        photoList.add(Photos(2, "ქათამი", "პროტეინი - 27 g", R.drawable.qatami))
        photoList.add(Photos(3, "ძროხის ხორცი", "პროტეინი - 26 g", R.drawable.dzroxa_94000))
        photoList.add(Photos(4, "ცხვრის ხორცი", "პროტეინი - 25 g", R.drawable.cxvari_66200))
        photoList.add(Photos(5, "ყველი", "პროტეინი - 25 g", R.drawable.yveli_7_5))
        photoList.add(Photos(1, "ირმის ხორცი", "პროტეინი - 22.3 g", R.drawable.iremi_96000))
        photoList.add(Photos(2, "ლობიო", "პროტეინი - 21 g", R.drawable.lobionagdi_30))
        photoList.add(Photos(3, "ორაგული", "პროტეინი - 20 g", R.drawable.oraguli_34_1))
        photoList.add(Photos(4, "კვერცხი", "პროტეინი - 14 g", R.drawable.kvercxi_10_4))
        photoList.add(Photos(5, "ავოკადო", "პროტეინი - 2 g", R.drawable.avokado))


        val photoAdapter = PhotoAdapter(photoList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = photoAdapter
    }


}