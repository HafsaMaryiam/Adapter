package com.example.adaptertask1

import android.content.IntentFilter
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.adaptertask1.NetworkChangeReceiver
import com.example.adaptertask1.databinding.ActivityNetworkPermissionBinding

class NetworkPermissionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNetworkPermissionBinding



    private lateinit var networkReceiver: NetworkChangeReceiver

    override fun onCreate(savedInstanceState: Bundle?) {      
        super.onCreate(savedInstanceState)
        binding=ActivityNetworkPermissionBinding.inflate((layoutInflater))
        setContentView(binding.root)
            // Initialize the receiver
            networkReceiver = NetworkChangeReceiver()

            // Register the receiver to listen for connectivity changes
            val filter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
            registerReceiver(networkReceiver, filter)
        }

       override  fun onDestroy() {
            super.onDestroy()
            // Unregister the receiver when the activity is destroyed
            unregisterReceiver(networkReceiver)
        }
}
