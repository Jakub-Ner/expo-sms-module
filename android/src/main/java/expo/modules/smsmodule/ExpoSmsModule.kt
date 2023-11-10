package expo.modules.smsmodule

import android.Manifest
import android.Manifest.permission.RECEIVE_SMS
import android.Manifest.permission.READ_SMS
import android.Manifest.permission.SEND_SMS
import android.content.Context
import expo.modules.kotlin.Promise
import expo.modules.interfaces.permissions.Permissions
import expo.modules.interfaces.permissions.PermissionsStatus
import android.telephony.SmsManager
import android.util.Log
import android.content.IntentFilter
import android.provider.Telephony
import androidx.core.os.bundleOf
import expo.modules.kotlin.modules.Module
import expo.modules.kotlin.modules.ModuleDefinition

private const val moduleName = "ExpoSmsModule"
private const val RECEIVE_SMS_EVENT_NAME = "onSMSReceived"


class ExpoSmsModule : Module() {
    override fun definition() = ModuleDefinition {
        Name(moduleName)
        Events(RECEIVE_SMS_EVENT_NAME)

        OnStartObserving {
            context.registerReceiver(
                smsReceiver,
                IntentFilter(Telephony.Sms.Intents.SMS_RECEIVED_ACTION)
            )
        }
        OnStopObserving {
            context.unregisterReceiver(smsReceiver)
        }

        Function("hello") {
            "Hello siema lol! 👋"
        }

        AsyncFunction("requestSendSmsPermissionsAsync") { promise: Promise ->
            Permissions.askForPermissionsWithPermissionsManager(appContext.permissions, promise, *listOfNotNull(RECEIVE_SMS, READ_SMS, SEND_SMS).toTypedArray())
          }

        Function("sendSms") { phoneNumber: String, message: String ->
            val smsManager = SmsManager.getDefault()
            try {
                Log.d("ExpoSmsModule", "Sending SMS to $phoneNumber: $message")
                smsManager.sendTextMessage(phoneNumber, null, message, null, null)
            }
            catch (e: Exception) {
                Log.d("ExpoSmsModule", "Error during sendSMS(): $e")
            }
        }

    }

    val context: Context
    get() = requireNotNull(appContext.reactContext) { "React Application Context is null" }

  private val currentActivity
    get() = appContext.activityProvider?.currentActivity ?: throw MissingCurrentActivityException()


    private val smsReceiver: SMSReceiver = SMSReceiver(this)


    fun triggerEvent(phoneNumber: String, message: String) {
        Log.d("ExpoSmsModule", "triggerEvent(): $phoneNumber: $message")
        this@ExpoSmsModule.sendEvent(RECEIVE_SMS_EVENT_NAME, bundleOf("message" to message, "phoneNumber" to phoneNumber))
    }

}

