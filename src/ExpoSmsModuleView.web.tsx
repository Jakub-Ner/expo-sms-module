import * as React from 'react';

import { ExpoSmsModuleViewProps } from './ExpoSmsModule.types';

export default function ExpoSmsModuleView(props: ExpoSmsModuleViewProps) {
  return (
    <div>
      <span>{props.name}</span>
    </div>
  );
}
