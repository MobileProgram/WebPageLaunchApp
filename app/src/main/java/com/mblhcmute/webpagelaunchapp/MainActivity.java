package com.mblhcmute.webpagelaunchapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.mblhcmute.webpagelaunchapp.databinding.ActivityMainBinding;

import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent receivedIntent = getIntent();
        Uri uri = receivedIntent.getData();
        URL webPageUrl = null;
        if(uri != null){
            try {
                webPageUrl = new URL(uri.getScheme(), uri.getHost(), uri.getPath());
            }catch (Exception e){
                Toast.makeText(this, "Intent exception occured", Toast.LENGTH_SHORT).show();
            }

            WebView webview = binding.webview;
            webview.setWebViewClient(new WebViewClient());
            webview.loadUrl(webPageUrl.toString());
        }
    }
}