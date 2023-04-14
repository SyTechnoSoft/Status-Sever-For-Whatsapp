package com.statusseverforwhatsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WhatsappWeb extends AppCompatActivity {
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whatsapp_web);
        webView = findViewById(R.id.web);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setBuiltInZoomControls(true);

        webView.loadUrl("https://web.whatsapp.com/");

        String userAgent = webView.getSettings().getUserAgentString();

        try {
            String androidString = webView.getSettings().getUserAgentString().
                    substring(userAgent.indexOf("("),userAgent.indexOf(")")+ 1);

            userAgent = webView.getSettings().getUserAgentString().replace(androidString,"X11; Linux x86_64");

        }catch (Exception e){
            e.printStackTrace();
        }

        webView.getSettings().setUserAgentString(userAgent);
        webView.reload();
    }
}