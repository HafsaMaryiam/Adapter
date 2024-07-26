package com.example.adaptertask1

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.http.UrlRequest.Status
import android.os.Build
import androidx.annotation.RequiresExtension
import com.google.android.gms.auth.api.phone.SmsRetriever
import com.google.android.gms.auth.api.phone.SmsRetrieverStatusCodes
import com.google.android.gms.common.api.CommonStatusCodes

class SmsBroadcastReciever:BroadcastReceiver (){
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override fun onReceive(context: Context?, intent: Intent?) {

        if(SmsRetriever.SMS_RETRIEVED_ACTION ==intent?.action){
            val extras= intent.extras
            val smsRetrieverStatusCodes=extras?.get(SmsRetriever.EXTRA_STATUS) as Status

                }

            }

        }

