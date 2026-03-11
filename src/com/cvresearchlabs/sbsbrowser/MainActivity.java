// Copyright (c) 2026 Cedar Valley Research Labs - cvresearchlabs.com

package com.cvresearchlabs.sbsbrowser;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.widget.EditText;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {
//    static {
//        System.loadLibrary("hello");
//    }

//    public native String getMessage();
    public String getMessage() { return "test67"; }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        EditText text = (EditText)findViewById(R.id.my_text);
        text.setText(getMessage());
        
        findViewById(R.id.my_widget).setPadding(100, 0, getWindowWidth()/2+200, 0);
        
        // https://developer.android.com/develop/ui/views/layout/webapps/webview
        WebView myWebView = (WebView)findViewById(R.id.my_webview);
        myWebView.loadUrl("https://www.google.com/");
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.setWebViewClient(new WebViewClient());
    }
    
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // https://developer.android.com/develop/ui/views/layout/webapps/webview
        WebView myWebView = (WebView)findViewById(R.id.my_webview);
        // Check whether the key event is the Back button and if there's history.
        if ((keyCode == KeyEvent.KEYCODE_BACK) && myWebView.canGoBack()) {
            myWebView.goBack();
            return true;
        }
        // If it isn't the Back button or there's no web page history, bubble up to
        // the default system behavior. Probably exit the activity.
        return super.onKeyDown(keyCode, event);
    }
    
    protected int getWindowWidth() {
        // Get the display metrics
        DisplayMetrics displayMetrics = new DisplayMetrics();
    
        //@SuppressWarnings("deprecation")
        // Get the default display metrics
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
    
        // Return the width and height
        //return new Pair<>(displayMetrics.widthPixels, displayMetrics.heightPixels);
        
        return displayMetrics.widthPixels;
    }
}

