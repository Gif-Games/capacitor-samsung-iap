package games.gif.samsungiap.adapter;

import com.getcapacitor.JSArray;
import com.getcapacitor.JSObject;
import com.getcapacitor.Logger;
import com.getcapacitor.PluginCall;
import com.samsung.android.sdk.iap.lib.helper.IapHelper;
import com.samsung.android.sdk.iap.lib.listener.OnConsumePurchasedItemsListener;
import com.samsung.android.sdk.iap.lib.vo.ConsumeVo;
import com.samsung.android.sdk.iap.lib.vo.ErrorVo;

import org.json.JSONException;

import java.util.ArrayList;

public class ConsumeItemsAdapter implements OnConsumePurchasedItemsListener {
    private final String TAG = PaymentAdapter.class.getSimpleName();
    private PluginCall call = null;

    public ConsumeItemsAdapter(PluginCall _call) {
        call = _call;
    }

    @Override
    public void onConsumePurchasedItems(ErrorVo _errorVo, ArrayList<ConsumeVo> _consumeList) {
        if (_errorVo != null) {
            if (_errorVo.getErrorCode() == IapHelper.IAP_ERROR_NONE) {
                if (_consumeList != null) {
                    JSArray list = new JSArray();
                    for (ConsumeVo item : _consumeList) {
                        try {
                            list.put(new JSObject(item.getJsonString()));
                        } catch (JSONException e) {
                            e.printStackTrace();
                            call.reject(e.toString());
                        }
                        JSObject ret = new JSObject();
                        ret.put("data", list);
                        call.resolve(ret);
                    }
                }
            } else {
                String errorMsg =  _errorVo.getErrorString();
                Logger.error(TAG, errorMsg, null);
                call.reject(errorMsg);
            }
        }
    }
}
