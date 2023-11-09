### Development
Files to be edited are located in:
- 'android/src/main/java/expo/modules/smsmodule/'
- 'src/'

### Running
within `example/` run 
```
npx expo run:android --device <Device-Name>
```

### Debugging:
Assuming:
```.kt
import android.util.Log
Log.d("ExpoSmsModule", "Hello world")
```

Dislpay logs
```
adb logcat -s ExpoSmsModule:V
```
