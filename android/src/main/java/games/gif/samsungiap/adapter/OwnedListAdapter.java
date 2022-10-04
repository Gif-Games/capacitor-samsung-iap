package games.gif.samsungiap.adapter;


import com.getcapacitor.JSArray;
import com.getcapacitor.JSObject;
import com.getcapacitor.Logger;
import com.getcapacitor.PluginCall;
import com.samsung.android.sdk.iap.lib.helper.IapHelper;
import com.samsung.android.sdk.iap.lib.listener.OnGetOwnedListListener;
import com.samsung.android.sdk.iap.lib.vo.ErrorVo;
import com.samsung.android.sdk.iap.lib.vo.OwnedProductVo;

import org.json.JSONException;

import java.util.ArrayList;


public class OwnedListAdapter implements OnGetOwnedListListener {
    private final String TAG = PaymentAdapter.class.getSimpleName();
    private PluginCall call = null;

    public OwnedListAdapter(PluginCall _call) {
        call = _call;
    }

    @Override
    public void onGetOwnedProducts(ErrorVo _errorVo, ArrayList<OwnedProductVo> _ownedList) {
        if (_errorVo != null) {
            if (_errorVo.getErrorCode() == IapHelper.IAP_ERROR_NONE) {
                if (_ownedList != null) {
                    JSArray list = new JSArray();
                    for (OwnedProductVo item : _ownedList) {
                        try {
                            list.put(new JSObject(item.getJsonString()));
                        } catch (JSONException e) {
                            e.printStackTrace();
                            call.reject(e.toString());
                        }
                    }
                    JSObject ret = new JSObject();
                    ret.put("data", list);
                    call.resolve(ret);
                }
            } else {
                String errorMsg = "onGetOwnedProducts > Error " + _errorVo.getErrorString();
                Logger.error(TAG, errorMsg, null);
                call.reject(errorMsg);
            }
        }
    }

}
