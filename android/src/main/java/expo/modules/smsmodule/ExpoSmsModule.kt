package expo.modules.smsmodule

import android.Manifest
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

        // Defines a JavaScript synchronous function that runs the native code on the JavaScript thread.
        Function("hello") {
            "Hello siema lol! 👋"
        }

        AsyncFunction("requestSendSmsPermissionsAsync") { promise: Promise ->
            Permissions.askForPermissionsWithPermissionsManager(appContext.permissions, promise, SEND_SMS)
          }

        Function("sendSms") { phoneNumber: String, message: String ->
            val smsManager = SmsManager.getDefault()
            try {
                smsManager.sendTextMessage(phoneNumber, null, message, null, null)
            }
            catch (e: Exception) {
                Log.d("ExpoSmsModule", "dupa: $e")
            }
        }

    }

    val context: Context
    get() = requireNotNull(appContext.reactContext) { "React Application Context is null" }

  private val currentActivity
    get() = appContext.activityProvider?.currentActivity ?: throw MissingCurrentActivityException()

}

