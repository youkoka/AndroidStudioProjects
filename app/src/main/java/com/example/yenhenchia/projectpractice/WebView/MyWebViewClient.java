package com.example.yenhenchia.projectpractice.WebView;

import android.app.Activity;
import android.graphics.Bitmap;
import android.util.Log;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

/**
 * Created by yenhenchia on 2017/3/29.
 */

public class MyWebViewClient extends WebViewClient {

    static final String LOG = "MyWebViewClient";

    Button btnWebBack, btnWebFroward, btnWebReload, btnStop;

    public MyWebViewClient setViewComponent(Activity activity, Button btnWebBack, Button btnWebFroward, Button btnUpdate, Button btnStop) {

        this.btnWebBack = btnWebBack;
        this.btnWebFroward = btnWebFroward;
        this.btnWebReload = btnUpdate;
        this.btnStop = btnStop;

        return this;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {

        Log.d(LOG, "shouldOverrideUrlLoading : " + view.getUrl());

        return super.shouldOverrideUrlLoading(view, request);
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);

        Log.d(LOG, "onPageStarted : " + url);
        btnWebReload.setEnabled(false);
        btnStop.setEnabled(true);
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);

        Log.d(LOG, "onPageFinished : " + url);

        btnWebReload.setEnabled(true);
        btnStop.setEnabled(false);
        if (view.canGoForward()) {

            btnWebFroward.setEnabled(true);
        }
        else {

            btnWebFroward.setEnabled(false);
        }

        if (view.canGoBack()) {

            btnWebBack.setEnabled(true);
        }
        else {

            btnWebBack.setEnabled(false);
        }
    }

    @Override
    public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
        super.onReceivedError(view, request, error);

        Log.d(LOG, "onReceivedError : " + view.getUrl());

        btnWebReload.setEnabled(true);
        btnStop.setEnabled(false);
    }
}
