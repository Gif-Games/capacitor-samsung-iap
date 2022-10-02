import { WebPlugin } from '@capacitor/core';

import type { SamsungIAPPlugin } from './definitions';

export class SamsungIAPWeb extends WebPlugin implements SamsungIAPPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
