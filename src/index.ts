import ExpoSmsModule from './ExpoSmsModule';

export function hello(): string {
  return ExpoSmsModule.hello();
}

export async function requestSendSmsPermissionsAsync(){
  return ExpoSmsModule.requestSendSmsPermissionsAsync();
}

export function sendSms(
    phoneNumber: string,
    message: string
  ): void {
  ExpoSmsModule.sendSms(phoneNumber, message);
}
