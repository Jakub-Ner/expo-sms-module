import {
  requestSendSmsPermissionsAsync,
  sendSms,
  addSmsListener,
} from "expo-sms-module";
import * as ExpoSmsModule from "expo-sms-module";
import { useEffect, useState } from "react";
import { StyleSheet, Text, View } from "react-native";

export default function App() {
  const [message, setMessage] = useState("");
  const [phoneNumber, setPhoneNumber] = useState("");

  useEffect(() => {
    requestSendSmsPermissionsAsync()
      .then((result) => {
        console.log(result);
        // sendSms("+12 345 678 900", "Hello from Expo"); // uncomment and change phone number
      })
      .catch((error) => {
        console.log(error);
      });

    const sub = addSmsListener(({message, phoneNumber}) => {
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
    backgroundColor: "#fff",
    alignItems: "center",
    justifyContent: "center",
  },
});
