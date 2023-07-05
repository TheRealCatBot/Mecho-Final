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
        photoList.add(Photos(1, "ირმის ხორცი", "Vitamin A - 96000 IU", R.drawable.iremi_96000))
        photoList.add(Photos(2, "ძროხის ხორცი", "Vitamin A - 94000 IU", R.drawable.dzroxa_94000))
        photoList.add(Photos(3, "ბულგარული წიწაკა", "Vitamin A - 77200 IU", R.drawable.bulgaruli_77200))
        photoList.add(Photos(4, "სტაფილო", "Vitamin A - 68400 IU", R.drawable.stafilo_68400))
        photoList.add(Photos(5, "მწვანე ხახვი", "Vitamin A - 68300 IU", R.drawable.mwvane_68300))
        photoList.add(Photos(1, "ცხვრის ხორცი", "Vitamin A - 66200 IU", R.drawable.cxvari_66200))
        photoList.add(Photos(2, "ქინძი", "Vitamin A - 63200 IU", R.drawable.qindzi_63200))
        photoList.add(Photos(3, "პაპრიკა", "Vitamin A - 49200 IU", R.drawable.paprika_49200))
        photoList.add(Photos(4, "ჩიფსები", "Vitamin A - 23600 IU", R.drawable.chifsebi_23600))
        photoList.add(Photos(5, "ბროკოლი", "Vitamin A - 16000 IU", R.drawable.brokoli_16000))


        val photoAdapter = PhotoAdapter(photoList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = photoAdapter
    }


}