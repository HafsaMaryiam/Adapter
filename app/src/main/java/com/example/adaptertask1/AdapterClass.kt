package com.example.adaptertask1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class AdapterClass (  var listener: MainActivity,private val itemDetails: ArrayList<Modelclass>) :
    RecyclerView.Adapter<Viewholder>(){
        interface onclickfunctions{
            fun deletemodeluser(modelclass: Modelclass)
            fun editmodeluser(modelclass: Modelclass)
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.recylaritems, parent, false
        )
        return Viewholder(view)
    }

    override fun getItemCount(): Int {
        return itemDetails.size
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        holder.text1.text = itemDetails[position].text1
        holder.text2.text = itemDetails[position].text2
        holder.deletebutton.setOnClickListener{

         listener.deleteModelUser(itemDetails[position])

        }
        holder.editbutton.setOnClickListener(){
            listener.Editmodeluser(itemDetails[position])
        }

        Glide.with(holder.itemView.context)
            .load(itemDetails[position].image)
            .into(holder.image)

    }
}

class Viewholder (itemView: View) : RecyclerView.ViewHolder(itemView){
    val image: ImageView = itemView.findViewById(R.id.image1)
    val text1: TextView = itemView.findViewById(R.id.tv1)
    val text2: TextView = itemView.findViewById(R.id.tv2)
    val editbutton: TextView = itemView.findViewById(R.id.editbtn)
    val deletebutton: TextView = itemView.findViewById(R.id.del_button)

}
