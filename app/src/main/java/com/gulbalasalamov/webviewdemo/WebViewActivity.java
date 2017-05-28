package com.gulbalasalamov.webviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class WebViewActivity extends AppCompatActivity {

    WebView webView;
    Button button;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        webView = (WebView) findViewById(R.id.webview);
        button = (Button) findViewById(R.id.button);
        editText = (EditText) findViewById(R.id.edittext);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WebSettings webSettings = webView.getSettings();
                webSettings.setBuiltInZoomControls(true);
                webSettings.setJavaScriptEnabled(true);
                webView.setWebViewClient(new Callback());
                webView.loadUrl("http://" + editText.getText().toString());
            }

            class Callback extends WebViewClient {
                //WebView içeriğinin widget içerisinde açılmasını sağlar
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    return (false);
                }
            }
        });
    }
}
