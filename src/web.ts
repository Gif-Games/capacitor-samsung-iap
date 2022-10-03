import { WebPlugin } from '@capacitor/core';

import type { SamsungIAPPlugin } from './definitions';

export class SamsungIAPWeb extends WebPlugin implements SamsungIAPPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }

  async add(options: { x: number; y: number }): Promise<{ value: number }> {
    console.log('ADD', options);
    return { value: options.x * options.y };
  }
}
