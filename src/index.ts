import { registerPlugin } from '@capacitor/core';

import type { SamsungIAPPlugin } from './definitions';

const SamsungIAP = registerPlugin<SamsungIAPPlugin>('SamsungIAP', {
  web: () => import('./web').then(m => new m.SamsungIAPWeb()),
});

export * from './definitions';
export { SamsungIAP };
