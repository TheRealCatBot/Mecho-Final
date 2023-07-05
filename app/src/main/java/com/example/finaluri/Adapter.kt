package com.example.finaluri


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PhotoAdapter(private val photos:List<Photos> ):
       RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>(){
    class PhotoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val imageView:ImageView=itemView.findViewById(R.id.imageView3)
        val textView:TextView=itemView.findViewById(R.id.textView2)
        val textView2:TextView=itemView.findViewById(R.id.textView3)

    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.product_c,parent,false)
        return PhotoViewHolder(view)
    }

    override fun getItemCount(): Int =photos.size

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val p = photos[position]

        holder.imageView.setImageResource(p.image)
        holder.textView.text=p.title
        holder.textView2.text=p.description
    }

}