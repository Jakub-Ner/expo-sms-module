import { NativeModulesProxy, EventEmitter, Subscription } from 'expo-modules-core';

// Import the native module. On web, it will be resolved to ExpoSmsModule.web.ts
// and on native platforms to ExpoSmsModule.ts
import ExpoSmsModule from './ExpoSmsModule';
import ExpoSmsModuleView from './ExpoSmsModuleView';
import { ChangeEventPayload, ExpoSmsModuleViewProps } from './ExpoSmsModule.types';

// Get the native constant value.
export const PI = ExpoSmsModule.PI;

export function hello(): string {
  return ExpoSmsModule.hello();
}

export async function setValueAsync(value: string) {
  return await ExpoSmsModule.setValueAsync(value);
}

const emitter = new EventEmitter(ExpoSmsModule ?? NativeModulesProxy.ExpoSmsModule);

export function addChangeListener(listener: (event: ChangeEventPayload) => void): Subscription {
  return emitter.addListener<ChangeEventPayload>('onChange', listener);
}

export { ExpoSmsModuleView, ExpoSmsModuleViewProps, ChangeEventPayload };
