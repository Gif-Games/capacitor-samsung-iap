package games.gif.samsungiap;

import android.content.Context;

import com.getcapacitor.PluginCall;
import com.samsung.android.sdk.iap.lib.helper.HelperDefine.OperationMode;
import com.samsung.android.sdk.iap.lib.helper.IapHelper;

import java.util.List;

import games.gif.samsungiap.adapter.ConsumeItemsAdapter;
import games.gif.samsungiap.adapter.OwnedListAdapter;
import games.gif.samsungiap.adapter.PaymentAdapter;
import games.gif.samsungiap.adapter.ProductsDetailsAdapter;

public class SamsungIAP {

    private IapHelper iapHelper = null;

    SamsungIAP(Context context) {
        iapHelper = IapHelper.getInstance(context);
    }

    public void setOperationMode(OperationModeType mode) {
        switch (mode) {

            case PRODUCTION:
                iapHelper.setOperationMode(OperationMode.OPERATION_MODE_PRODUCTION);
                break;
            case TEST:
                iapHelper.setOperationMode(OperationMode.OPERATION_MODE_TEST);
                break;
            case TEST_FAIL:
                iapHelper.setOperationMode(OperationMode.OPERATION_MODE_TEST_FAILURE);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + mode);
        }
    }

    public void getOwnedList(PluginCall call, String productType) {
        iapHelper.getOwnedList(productType, new OwnedListAdapter(call));
    }

    public void getProductsDetails(PluginCall call, List<String> _productIds) {
        String productIds = String.join(",", _productIds);
        iapHelper.getProductsDetails(productIds, new ProductsDetailsAdapter(call));
    }

    public void startPayment(PluginCall call, String itemId, String passThroughParam) {
        iapHelper.startPayment(itemId, passThroughParam, new PaymentAdapter(call, passThroughParam));
    }
    public void consumePurchasedItems(PluginCall call, List<String> _purchaseIds) {
        String purchaseIds = String.join(",", _purchaseIds);
        iapHelper.consumePurchasedItems(purchaseIds, new ConsumeItemsAdapter(call));
    }

    public enum OperationModeType {
        PRODUCTION("production"), TEST("test"), TEST_FAIL("test_fail");

        final private String value;

        OperationModeType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

}
