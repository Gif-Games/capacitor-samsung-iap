export interface SamsungIAPPlugin {
  // todo add type using getJSONString();

  /**
   * IAP supports three operational modes. One is for enabling billing for item purchases and the other two are for testing IAP functions without billing app users for item purchases.
   */
  setOperationMode(options: SetOperationModeOptions): Promise<void>;

  /**
   * returns a list of in-app items that the app user currently has from previous purchases:
   * - Consumable items that have not yet been used and not yet reported as consumed
   * - Non-consumable items
   * - Subscription items currently in a free trial or an active subscription period (this includes canceled subscription items until their active subscription period has ended)
   */
  getOwnedList(options: GetOwnedListOptions): Promise<any>;

  /**
   * returns information for one, more, or all in-app items registered to the app.
   */
  getProductsDetails(options: GetProductsDetailsOptions): Promise<any>;

  /**
   * initiates the purchase and payment transaction of the specified in-app item and can notify the end user if the purchase succeeded or failed.
   */
  startPayment(options: StartPaymentOptions): Promise<any>;

  /**
   * reports one or more purchased consumable items as consumed, which makes the items available for another purchase.
   */
  consumePurchasedItems(options: ConsumePurchasedItemsOptions): Promise<any>;
}

export interface SetOperationModeOptions {
  /**
   * - `production` : startPayment() requests are processed as specified, financial transactions do occur for successful requests, and actual results are returned (successful or failed).
   *
   *   Note: For all other IAP Helper requests:
   *
   *   Only items purchased in OPERATION_MODE_PRODUCTION mode are considered owned items.
   *
   * - `test` : startPayment() requests are processed as specified, except financial transactions do not occur (licensed testers are not billed for item purchases), and successful results are always returned.
   *   For details of the payment window shown in OPERATION_MODE_TEST mode, see below.
   *
   *   Note: For all other IAP Helper requests:
   *
   *   - Only items purchased in OPERATION_MODE_TEST mode are considered owned items.
   *   - In order to purchase in-app items, testers must be registered as a License Tester in the seller's Seller Portal profile. In this mode, licensed testers always get your in-app items for free. All other users see an error message if they try to purchase an in-app item.
   *
   * - `test_fail` : All IAP Helper requests fail.
   *   It is meant to be a negative testing to ensure that your app can handle errors such as improper input and user actions.
   */
  mode: 'production' | 'test' | 'test_fail';
}

export interface GetOwnedListOptions {
  /**
   * (Required) Type of in-app items to be returned:
   * - `item` : Both consumable and non-consumable items
   * - `subscription` : Auto-recurring subscription items
   * - `all` : Consumable, non-consumable, and auto-recurring subscription items
   */
  productType: 'item' | 'subscription' | 'all';
}

export interface GetProductsDetailsOptions {
  /**
   * (Required) One or more in-app item IDs specified by either:
   * Empty array [] that designates all in-app items or
   * One or more unique in-app item ID values
   *
   * You can get the IDs from Seller Portal (Applications page > Click status of the app > In App Purchase tab > Item ID).
   */
  productIds: string[];
}

export interface StartPaymentOptions {
  /**
   * (Required) Unique identifier value of the in-app item to be purchased.
   */
  itemId: string;

  /**
   *  Optional Unique identifier (maximum: 255 bytes) assigned by your Android app to the purchase and payment transaction.
   *
   * When specified, the value will be returned by OnPaymentListener interface.
   *
   * When the iap/v6/receipt is called from the Samsung IAP Server API to verify a purchase, the value will be returned by the pathThroughParam field.
   *
   */
  passThroughParam: string;
}

export interface ConsumePurchasedItemsOptions {
  /**
   * (Required) One or more unique identifier values of the purchase and payment transactions of consumable in-app items that are to be reported as consumed
   */
  purchaseIds: string[];
}
