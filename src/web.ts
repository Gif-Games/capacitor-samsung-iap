/* eslint-disable @typescript-eslint/no-unused-vars */
import { WebPlugin } from '@capacitor/core';

import type {
  ConsumePurchasedItemsOptions,
  GetOwnedListOptions,
  GetProductsDetailsOptions,
  SamsungIAPPlugin,
  SetOperationModeOptions,
  StartPaymentOptions,
} from './definitions';

export class SamsungIAPWeb extends WebPlugin implements SamsungIAPPlugin {
  setOperationMode(_options: SetOperationModeOptions): Promise<void> {
    throw new Error('Method not implemented.');
  }
  getOwnedList(_options: GetOwnedListOptions): Promise<any> {
    throw new Error('Method not implemented.');
  }
  getProductsDetails(_options: GetProductsDetailsOptions): Promise<any> {
    throw new Error('Method not implemented.');
  }
  startPayment(_options: StartPaymentOptions): Promise<any> {
    throw new Error('Method not implemented.');
  }
  consumePurchasedItems(_options: ConsumePurchasedItemsOptions): Promise<any> {
    throw new Error('Method not implemented.');
  }
}
