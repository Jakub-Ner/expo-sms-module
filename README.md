# Expo SMS Module

Expo module for sending and receiving SMS messages on Android.

### Usage:

#### Available functions:
```ts
async function requestSendSmsPermissionsAsync() {
  return ExpoSmsModule.requestSendSmsPermissionsAsync();
}

function sendSms(phoneNumber: string, message: string): void {
  ExpoSmsModule.sendSms(phoneNumber, message);
}

const emitter = new EventEmitter(ExpoSmsModule);

function addSmsListener(
  listener: (event: { message: string; phoneNumber: string }) => void,
): Subscription {
  return emitter.addListener("onSMSReceived", listener);
}
```

See example usage in [example/App.tsx](example/App.tsx)



### Development
Files to be edited are located in:
- 'android/src/main/java/expo/modules/smsmodule/'
- 'src/'

#### Running Example
within `example/` run 
```
npx expo run:android --device <Device-Name>
```

#### Debugging:
Assuming:
```.kt
import android.util.Log
Log.d("ExpoSmsModule", "Hello world")
```

Dislpay logs
```
adb logcat -s ExpoSmsModule:V
```
