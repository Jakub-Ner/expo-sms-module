package com.jakubner.exposmsmodule

//import android.Manifest
//import android.content.BroadcastReceiver
//import android.content.Context
//import android.content.Intent
//import android.content.IntentFilter
//import android.content.pm.PackageManager
//import android.os.Bundle
//import android.provider.Telephony
//import android.telephony.SmsManager
//import android.util.Log
//import androidx.appcompat.app.AppCompatActivity
//import androidx.core.app.ActivityCompat
//import androidx.core.content.ContextCompat

import expo.modules.kotlin.modules.Module
import expo.modules.kotlin.modules.ModuleDefinition

class ExpoSmsModule: Module() {

    override fun definition() = ModuleDefinition {
        Name = "ExpoSmsModule"
//        constants {
//            put("name", "ExpoSmsModule")
//        }
        Function("helloWorld"){
            "Hello World!"
        }
//    class SMSReceiver : BroadcastReceiver() {
//        override fun onReceive(context: Context, intent: Intent) {
//            Log.d("SMSReceiver", "onReceive")
//            if (intent.action == Telephony.Sms.Intents.SMS_RECEIVED_ACTION) {
//                for (smsMessage in Telephony.Sms.Intents.getMessagesFromIntent(intent)) {
//                    val messageBody = smsMessage.messageBody
//                    val sender = smsMessage.displayOriginatingAddress
//                    Log.d("SMSReceiver", "$sender: $messageBody")
//                }
//            }
//        }
//    }
//    lateinit var smsReceiver: SMSReceiver
//    companion object {
//        private const val PERMISSIONS_REQUEST_CODE = 1111
//    }
//
//
//    fun sendSms(phoneNumber: String, message: String) {
//        val smsManager = SmsManager.getDefault()
//        smsManager.sendTextMessage(phoneNumber, null, message, null, null)
//    }
//
//
//    fun requestSmsPermissions(): Boolean {
//        val permissionsNeeded = mutableListOf<String>()
//
//        if (ContextCompat.checkSelfPermission(
//                this,
//                Manifest.permission.READ_SMS
//            ) != PackageManager.PERMISSION_GRANTED
//        ) {
//            permissionsNeeded.add(Manifest.permission.READ_SMS)
//        }
//
//        if (ContextCompat.checkSelfPermission(
//                this,
//                Manifest.permission.RECEIVE_SMS
//            ) != PackageManager.PERMISSION_GRANTED
//        ) {
//            permissionsNeeded.add(Manifest.permission.RECEIVE_SMS)
//        }
//
//        if (ContextCompat.checkSelfPermission(
//                this,
//                Manifest.permission.SEND_SMS
//            ) != PackageManager.PERMISSION_GRANTED
//        ) {
//            permissionsNeeded.add(Manifest.permission.SEND_SMS)
//        }
//
//        if (permissionsNeeded.isNotEmpty()) {
//            ActivityCompat.requestPermissions(
//                this,
//                permissionsNeeded.toTypedArray(),
//                PERMISSIONS_REQUEST_CODE
//            )
//            return false
//        }
//        setupSmsReceiver()
//        return true
//    }
//
//    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//        if (requestCode == PERMISSIONS_REQUEST_CODE) {
//            if (grantResults.isEmpty() || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
//                Log.d("SMSReceiver", "Permission denied by user")
//            }
//        }
//    }
//
//    private fun setupSmsReceiver() {
//        Log.d("SMSReceiver", "Permission granted, setting up receiver.")
//        smsReceiver = SMSReceiver()
//        val intentFilter = IntentFilter(Telephony.Sms.Intents.SMS_RECEIVED_ACTION)
//        registerReceiver(smsReceiver, intentFilter)
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        unregisterReceiver(smsReceiver)
//    }

}
