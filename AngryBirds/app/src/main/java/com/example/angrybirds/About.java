package com.example.angrybirds;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class About extends AppCompatActivity {

    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        webView=(WebView) findViewById(R.id.WebView);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://linktr.ee/ngoctien.TNT");
    }
}