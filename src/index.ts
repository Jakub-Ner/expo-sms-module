import { EventEmitter, Subscription } from "expo-modules-core";

import ExpoSmsModule from "./ExpoSmsModule";

export function hello(): string {
  return ExpoSmsModule.hello();
}

export async function requestSendSmsPermissionsAsync() {
  return ExpoSmsModule.requestSendSmsPermissionsAsync();
}

export function sendSms(phoneNumber: string, message: string): void {
  ExpoSmsModule.sendSms(phoneNumber, message);
}

const emitter = new EventEmitter(ExpoSmsModule);

export function addSmsListener(
  listener: (event: { message: string; phoneNumber: string }) => void,
): Subscription {
  return emitter.addListener("onSMSReceived", listener);
}
