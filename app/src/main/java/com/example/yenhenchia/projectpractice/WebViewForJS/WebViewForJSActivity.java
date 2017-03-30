package com.example.yenhenchia.projectpractice.WebViewForJS;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;

import com.example.yenhenchia.projectpractice.R;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;

public class WebViewForJSActivity extends AppCompatActivity {

    private Button btnCallJS;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_for_js);

        btnCallJS = (Button) findViewById(R.id.btnCallJS);
        btnCallJS.setOnClickListener(onClickListener);

        webView = (WebView) findViewById(R.id.webView);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        /*
        try {
            StringBuilder buf = new StringBuilder();
            InputStream is = getAssets().open("Android.html");

            webView.loadUrl(is.toString());

            Log.d("WebJS", is.toString());
        }
        catch (IOException e) {

        }
//        webView.loadUrl(getAssets().toString() + "/Android.html");

//        Log.d("WebJS", getAssets().toString() + "/Android.html");
        */

        webView.addJavascriptInterface(new JavaScriptCallFunction(this), "Android");

        //! 假設網頁有使用alert訊息, 需加上 WebChromeClient
        webView.setWebChromeClient(new WebChromeClient() {

            @Override
            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
                return super.onJsAlert(view, url, message, result);
            }
        });
        
        webView.loadUrl("file:///android_asset/Android.html");
    }

    private Button.OnClickListener onClickListener = new Button.OnClickListener() {

        @Override
        public void onClick(View v) {

            webView.loadUrl("javascript:showWebAlertMsg('由Android呼叫')");
        }
    };
}
