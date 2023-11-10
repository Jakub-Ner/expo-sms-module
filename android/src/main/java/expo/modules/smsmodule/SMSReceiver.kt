package expo.modules.smsmodule

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Telephony
import android.util.Log

class SMSReceiver(expoSmsModule: ExpoSmsModule) : BroadcastReceiver() {
    private val _expoSmsModule = expoSmsModule

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == Telephony.Sms.Intents.SMS_RECEIVED_ACTION) {
            for (smsMessage in Telephony.Sms.Intents.getMessagesFromIntent(intent)) {
                val messageBody = smsMessage.messageBody
                val sender = smsMessage.displayOriginatingAddress
                Log.d("ExpoSmsModule", "OnReceive(): $sender: $messageBody")
                _expoSmsModule.triggerEvent(sender, messageBody)
            }
        }
    }
}