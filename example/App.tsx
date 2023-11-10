import { StyleSheet, Text, View } from 'react-native';

// import {hello} from 'expo-sms-module';
import * as ExpoSmsModule from 'expo-sms-module';
import { useEffect, useState } from "react";

export default function App() {
  console.log("App testing");
  ExpoSmsModule.requestSendSmsPermissionsAsync().then((result) => {
      console.log(result);
      // ExpoSmsModule.sendSms('+12 345 678 999', 'Hello from Expo'); // uncomment and change phone number 
  }).catch(
    (error) => {
      console.log(error);
    }
  )

  const [message, setMessage] = useState("");
  const [phoneNumber, setPhoneNumber] = useState("");
  useEffect(() => {
    const sub = ExpoSmsModule.addSmsListener(({ message, phoneNumber }) => {
      setMessage(message);
      setPhoneNumber(phoneNumber);
    });

    return () => sub.remove();
  }, []);

  return (
    <View style={styles.container}>
      <Text>{ExpoSmsModule.hello()}</Text>
      <Text>Mess: {message}</Text>
      <Text>From: {phoneNumber}</Text>
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
