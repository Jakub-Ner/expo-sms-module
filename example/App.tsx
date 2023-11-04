import { StyleSheet, Text, View } from 'react-native';

import * as ExpoSmsModule from 'expo-sms-module';

export default function App() {
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
