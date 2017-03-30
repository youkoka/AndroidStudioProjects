package com.example.yenhenchia.projectpractice.WebViewForJS;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

/**
 * Created by yenhenchia on 2017/3/30.
 */

public class JavaScriptCallFunction {

    Context context;

    public JavaScriptCallFunction(Context c) {

        context = c;
    }

    @JavascriptInterface
    public void showToastMsg(String msg) {

        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}
