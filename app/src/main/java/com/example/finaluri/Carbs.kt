package com.example.finaluri

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager

class Carbs : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.vitamin_c)

        recyclerView = findViewById(R.id.recyclerView)

        val photoList = ArrayList<Photos>()
        photoList.add(Photos(1, "ლობიო", "ნახშირწყლები - 63 g", R.drawable.lobionagdi_30))
        photoList.add(Photos(3, "პური", "ნახშირწყლები- 41 g", R.drawable.puri_41))
        photoList.add(Photos(4, "ბრინჯი", "ნახშირწყლები- 28 g", R.drawable.brinji_7_6))
        photoList.add(Photos(5, "კარტოფილი", "ნახშირწყლები- 17 g", R.drawable.kartofili_85_51))
        photoList.add(Photos(1, "ვაშლი", "ნახშირწყლები- 14 g", R.drawable.vashli))
        photoList.add(Photos(2, "ბანანი", "ნახშირწყლები- 23 g", R.drawable.banani_0_36))
        photoList.add(Photos(3, "ხახვი", "ნახშირწყლები- 7 g", R.drawable.xaxvi_83_28))
        photoList.add(Photos(4, "სტაფილო", "ნახშირწყლები- 7 g", R.drawable.stafilo_68400))
        photoList.add(Photos(5, "ბულგარული", "ნახშირწყლები- 3.5 g", R.drawable.bulgaruli_77200))


        val photoAdapter = PhotoAdapter(photoList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = photoAdapter
    }


}