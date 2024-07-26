package com.example.adaptertask1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.adaptertask1.databinding.ActivityMainBinding
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var listofitems= arrayListOf<Modelclass>()
    var db = Firebase.firestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.addbutton.setOnClickListener()
            {

            val modelUser=Modelclass()
                modelUser.text1=binding.title.text.toString()
                modelUser.text2=binding.sparepart.text.toString()

//                val modelUser = Modelclass( "https://th.bing.com/th/id/OIP.9TQYfdRPOE7MmFRvBIDufgHaEK?rs=1&pid=ImgDetMain ", "Mustang ","CLUTCH AND gears" )
                db.collection("User").add(modelUser)
                    .addOnSuccessListener { documentreference ->
                        modelUser.docId = documentreference.id
                        db.collection("User").document(documentreference.id).set(modelUser)
                            .addOnSuccessListener() {
                                Toast.makeText(this@MainActivity,"item added ", Toast.LENGTH_SHORT).show()
                            }
                            .addOnFailureListener()
                            { e ->
                                Toast.makeText(this@MainActivity, e.message.toString(), Toast.LENGTH_SHORT).show()
                              }


                    }
            }
        binding.showbutton.setOnClickListener {
            var listspare=ArrayList<Modelclass>()
            db.collection("User").get()
                .addOnSuccessListener { querySnapshot ->
                    for (document in querySnapshot) {
                        val modelUser = document.toObject(Modelclass::class.java)
                        listspare.add(modelUser)
                    }
                    binding.recycularView.layoutManager=
                        GridLayoutManager(this@MainActivity,2)
                    binding.recycularView.adapter=AdapterClass(this@MainActivity,listspare)
                }
                .addOnFailureListener {
                    Toast.makeText(this@MainActivity, it.message.toString(), Toast.LENGTH_SHORT).show()
                }





        }


    }
    fun deleteModelUser(modelUser: Modelclass) {
        db.collection("User").document(modelUser.docId).delete()
            .addOnSuccessListener {
                Toast.makeText(this@MainActivity, "Deleted", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener()
            {
                Toast.makeText(this@MainActivity, "Something went wrong", Toast.LENGTH_SHORT).show()
            }
    }


    fun Editmodeluser(modelUser: Modelclass){
        modelUser.image = "https://th.bing.com/th/id/OIP.XEANi73-BaVJHgI4i6pnAwHaEK?rs=1&pid=ImgDetMain"
        modelUser.text1="Kawasaki"
        modelUser.text2="Crankset"
        db.collection("User").document(modelUser.docId).set(modelUser)
            .addOnSuccessListener {
                Toast.makeText(this@MainActivity, "Item Updated", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener()
            {
                Toast.makeText(this@MainActivity, "Something went wrong", Toast.LENGTH_SHORT).show()
            }

    }

}