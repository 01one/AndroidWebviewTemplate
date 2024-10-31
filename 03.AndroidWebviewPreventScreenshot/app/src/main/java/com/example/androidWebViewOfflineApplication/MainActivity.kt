package com.example.androidWebViewOfflineApplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.view.WindowManager
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    private val applicationUrl = "file:///android_asset/index.html"

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Prevent screenshots by setting FLAG_SECURE
        window.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)

        val webView = WebView(this).apply {
            webViewClient = WebViewClient()
            settings.apply {
                javaScriptEnabled = true
                allowFileAccess = true
                domStorageEnabled = true
            }
            loadUrl(applicationUrl)
        }
        setContentView(webView)
    }
}
