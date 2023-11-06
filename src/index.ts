// import { ExpoSmsModuleInterface } from './types';
//
// import
// // const ExpoSmsModule: ExpoSmsModuleInterface = require('./ExpoSmsModule');
//
// export function hello(): string {
//   return ExpoSmsModule.helloWorld();
// }
// //
// // export function sendSms(phone, body): void {
// //   ExpoSmsModule.sendSms(phone, body);
// // }
// //
// // export function requestSmsPermissions(): boolean {
// //   return ExpoSmsModule.requestSmsPermissions();
// // }

import ExpoSmsModule from './ExpoSmsModule';

export function hello(): string {
  return ExpoSmsModule.hello();
}