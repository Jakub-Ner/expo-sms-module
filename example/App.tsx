import { StyleSheet, Text, View } from 'react-native';

// import {hello} from 'expo-sms-module';
import * as ExpoSmsModule from 'expo-sms-module';

export default function App() {
//    requestSmsPermissions();
//     sendSms('+48690585369', 'Hello from Expo');
  return (
    <View style={styles.container}>
      <Text>{ExpoSmsModule.hello()}</Text>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
});
