package com.tezotopia.app.samsungiap;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "SamsungIAP")
public class SamsungIAPPlugin extends Plugin {

    private SamsungIAP implementation = new SamsungIAP();

    @PluginMethod
    public void echo(PluginCall call) {
        String value = call.getString("value");

        JSObject ret = new JSObject();
        ret.put("value", implementation.echo(value));
        call.resolve(ret);
    }

    @PluginMethod
    public void add(PluginCall call) {
        int x = call.getInt("x");
        int y = call.getInt("y");

        JSObject ret = new JSObject();
        ret.put("value", implementation.add(x, y));
        call.resolve(ret);
    }
}
