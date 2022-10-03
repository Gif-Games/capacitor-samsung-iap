package com.tezotopia.app.samsungiap;

import android.util.Log;

public class SamsungIAP {

    public String echo(String value) {
        Log.i("Echo", value);
        return value;
    }

    public int add(int x, int y) {
        int z = x + y;
        return z;
    }
}
