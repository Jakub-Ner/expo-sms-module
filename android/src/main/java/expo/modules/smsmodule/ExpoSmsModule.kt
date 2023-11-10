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

import expo.modules.kotlin.modules.Module
import expo.modules.kotlin.modules.ModuleDefinition

private const val moduleName = "ExpoSmsModule"

class ExpoSmsModule : Module() {
    override fun definition() = ModuleDefinition {
        Name(moduleName)

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

}

