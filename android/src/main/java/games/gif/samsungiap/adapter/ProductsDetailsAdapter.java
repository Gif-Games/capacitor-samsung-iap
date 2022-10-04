package games.gif.samsungiap.adapter;


import com.getcapacitor.JSArray;
import com.getcapacitor.JSObject;
import com.getcapacitor.Logger;
import com.getcapacitor.PluginCall;
import com.samsung.android.sdk.iap.lib.helper.IapHelper;
import com.samsung.android.sdk.iap.lib.listener.OnGetProductsDetailsListener;
import com.samsung.android.sdk.iap.lib.vo.ErrorVo;
import com.samsung.android.sdk.iap.lib.vo.ProductVo;

import org.json.JSONException;

import java.util.ArrayList;


public class ProductsDetailsAdapter implements OnGetProductsDetailsListener {
    private final String TAG = PaymentAdapter.class.getSimpleName();
    private PluginCall call = null;

    public ProductsDetailsAdapter(PluginCall _call) {
        call = _call;
    }

    @Override
    public void onGetProducts(ErrorVo _errorVo, ArrayList<ProductVo> _productList) {
        if (_errorVo != null) {
            if (_errorVo.getErrorCode() == IapHelper.IAP_ERROR_NONE) {
                if (_productList != null) {
                    JSArray list = new JSArray();
                    for (ProductVo item : _productList) {
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
                String errorMsg = "onGetProducts > Error " + _errorVo.getErrorString();
                Logger.error(TAG, errorMsg, null);
                call.reject(errorMsg);
            }
        }
    }
}
