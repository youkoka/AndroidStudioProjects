package com.example.yenhenchia.projectpractice.WebView;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.yenhenchia.projectpractice.R;

public class WebViewActivity extends AppCompatActivity {

    private EditText editUrl;
    private Button btnOpenUrl, btnWebBack, btnWebForward, btnWebReload, btnWebStop;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        editUrl = (EditText)findViewById(R.id.editUrl);

        btnOpenUrl = (Button)findViewById(R.id.btnOpenUrl);
        btnOpenUrl.setOnClickListener(onClickListener);

        btnWebBack = (Button)findViewById(R.id.btnWebBack);
        btnWebBack.setOnClickListener(onClickListener);
        btnWebBack.setEnabled(false);

        btnWebForward = (Button)findViewById(R.id.btnWebForward);
        btnWebForward.setOnClickListener(onClickListener);
        btnWebForward.setEnabled(false);

        btnWebReload = (Button)findViewById(R.id.btnWebReload);
        btnWebReload.setOnClickListener(onClickListener);
        btnWebReload.setEnabled(false);

        btnWebStop = (Button)findViewById(R.id.btnWebStop);
        btnWebStop.setOnClickListener(onClickListener);
        btnWebStop.setEnabled(false);

        webView = (WebView)findViewById(R.id.webView);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);

        webView.setWebViewClient(new MyWebViewClient().setViewComponent(this, btnWebBack, btnWebForward, btnWebReload, btnWebStop));
        webView.setWebChromeClient(new WebChromeClient() {

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);

                if (newProgress >= 100) {

                    Toast.makeText(WebViewActivity.this, "網頁下載完成", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private Button.OnClickListener onClickListener = new Button.OnClickListener() {

        @Override
        public void onClick(View v) {

            switch (v.getId()) {

                case R.id.btnOpenUrl : {

                    String url = editUrl.getText().toString();

                    webView.loadUrl(url);
                }
                    break;
                case R.id.btnWebBack: {

                    if (webView.canGoBack()) {

                        webView.goBack();

                        editUrl.setText(webView.getUrl());
                    }
                }
                    break;
                case R.id.btnWebForward: {

                    if (webView.canGoForward()) {

                        webView.goForward();

                        editUrl.setText(webView.getUrl());
                    }
                }
                    break;
                case R.id.btnWebReload: {

                    webView.reload();
                }
                    break;
                case R.id.btnWebStop: {

                    webView.stopLoading();

                    btnWebReload.setEnabled(true);
                    btnWebStop.setEnabled(false);
                }
                    break;
            }
        }
    };
}
