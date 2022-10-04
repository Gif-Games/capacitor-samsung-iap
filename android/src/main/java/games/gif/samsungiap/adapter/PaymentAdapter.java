package games.gif.samsungiap.adapter;

import com.getcapacitor.JSObject;
import com.getcapacitor.PluginCall;
import com.samsung.android.sdk.iap.lib.helper.IapHelper;
import com.samsung.android.sdk.iap.lib.listener.OnPaymentListener;
import com.samsung.android.sdk.iap.lib.vo.ErrorVo;
import com.samsung.android.sdk.iap.lib.vo.PurchaseVo;

import org.json.JSONException;

public class PaymentAdapter implements OnPaymentListener {

    private PluginCall call = null;
    private String passThroughParam = null;

    public PaymentAdapter(PluginCall _call, String _passThroughParam) {
        call = _call;
        passThroughParam = _passThroughParam;
    }

    @Override
    public void onPayment(ErrorVo _errorVo, PurchaseVo _purchaseVo) {
        if (_errorVo != null) {
            if (_errorVo.getErrorCode() == IapHelper.IAP_ERROR_NONE) {
                if (_purchaseVo != null) {
                    String _passThroughParam = _purchaseVo.getPassThroughParam();
                    if (passThroughParam.equals(_passThroughParam)) {
                        try {
                            JSObject ret = new JSObject(_purchaseVo.getJsonString());
                            call.resolve(ret);
                        } catch (JSONException e) {
                            e.printStackTrace();
                            call.reject(e.toString());
                        }
                    } else {
                        call.reject("passThroughParam Mismatched");
                    }

                } else {
                    call.reject("Something went Wrong.");
                }
            }
        }
    }
}