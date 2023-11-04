import { requireNativeViewManager } from 'expo-modules-core';
import * as React from 'react';

import { ExpoSmsModuleViewProps } from './ExpoSmsModule.types';

const NativeView: React.ComponentType<ExpoSmsModuleViewProps> =
  requireNativeViewManager('ExpoSmsModule');

export default function ExpoSmsModuleView(props: ExpoSmsModuleViewProps) {
  return <NativeView {...props} />;
}
