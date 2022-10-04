package games.gif.samsungiap;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "SamsungIAP")
public class SamsungIAPPlugin extends Plugin {

    // private SamsungIAP iap = new SamsungIAP(getContext());

    @PluginMethod
    public void setOperationMode(PluginCall call) {
        // TODO
        call.unimplemented();
    }

    @PluginMethod
    public void getOwnedList(PluginCall call) {
        // TODO
        call.unimplemented();
    }

    @PluginMethod
    public void getProductsDetails(PluginCall call) {
        // TODO
        call.unimplemented();
    }

    @PluginMethod
    public void startPayment(PluginCall call) {
        // TODO
        call.unimplemented();
    }

    @PluginMethod
    public void consumePurchasedItems(PluginCall call) {
        // TODO
        call.unimplemented();
    }

}
