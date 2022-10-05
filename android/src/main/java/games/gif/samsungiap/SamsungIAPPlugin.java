package games.gif.samsungiap;

import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

import org.json.JSONException;

import java.util.List;

@CapacitorPlugin(name = "SamsungIAP")
public class SamsungIAPPlugin extends Plugin {

    private SamsungIAP iap;

    @Override
    public void load() {
        iap = new SamsungIAP(getContext());
    }

    @PluginMethod
    public void setOperationMode(PluginCall call) {
        String mode = call.getString("mode");
        iap.setOperationMode(mode);
        call.resolve();
    }

    @PluginMethod
    public void getOwnedList(PluginCall call) {
        String productType = call.getString("productType");
        iap.getOwnedList(call, productType);
    }

    @PluginMethod
    public void getProductsDetails(PluginCall call) {
        try {
            List<String> productIds = call.getArray("productIds").toList();
            iap.getProductsDetails(call, productIds);
        } catch (JSONException e) {
            call.reject(e.toString());
        }
    }

    @PluginMethod
    public void startPayment(PluginCall call) {
        String itemId = call.getString("itemId");
        String passThroughParam = call.getString("passThroughParam");
        iap.startPayment(call, itemId, passThroughParam);
    }

    @PluginMethod
    public void consumePurchasedItems(PluginCall call) {
        try {
            List<String> purchaseIds = call.getArray("purchaseIds").toList();
            iap.consumePurchasedItems(call, purchaseIds);
        } catch (JSONException e) {
            call.reject(e.toString());
        }
    }

}
