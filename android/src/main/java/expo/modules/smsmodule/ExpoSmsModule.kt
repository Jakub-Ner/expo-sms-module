package expo.modules.smsmodule

import expo.modules.kotlin.modules.Module
import expo.modules.kotlin.modules.ModuleDefinition

class ExpoSmsModule : Module() {
    override fun definition() = ModuleDefinition {
        Name("ExpoSmsModule")

        // Defines a JavaScript synchronous function that runs the native code on the JavaScript thread.
        Function("hello") {
            "Hello siema lol! 👋"
        }

    }
}
