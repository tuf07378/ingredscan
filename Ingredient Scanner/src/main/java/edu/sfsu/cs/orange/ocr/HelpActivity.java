/*
 * Copyright 2008 ZXing authors
 * Copyright 2011 Robert Theis
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package edu.sfsu.cs.orange.ocr;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.MailTo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

/**
 * Activity to display informational pages to the user in a WebView.
 * 
 * The code for this class was adapted from the ZXing project: http://code.google.com/p/zxing
 */
public final class HelpActivity extends Activity {

  private static final String TAG = HelpActivity.class.getSimpleName();

  // Use this key and one of the values below when launching this activity via intent. If not
  // present, the default page will be loaded.
  public static final String REQUESTED_PAGE_KEY = "requested_page_key";
  public static final String DEFAULT_PAGE = "whatsnew.html";
  public static final String ABOUT_PAGE = "about.html";
  public static final String TERMS_PAGE = "terms.html";
  public static final String WHATS_NEW_PAGE = "whatsnew.html";

  private static final String BASE_URL = "file:///android_asset/html/";
  private static final String WEBVIEW_STATE_PRESENT = "webview_state_present";

  private WebView webView;

  private final Button.OnClickListener doneListener = new Button.OnClickListener() {
    @Override
    public void onClick(View view) {
      finish();
    }
  };

  @Override
  protected void onCreate(Bundle icicle) {
    super.onCreate(icicle);
    setContentView(R.layout.help);

    WebView webView=(WebView)findViewById(R.id.webView);
    webView.loadUrl("file:///android_asset/html/help.html");
    webView.getSettings().setJavaScriptEnabled(true);
    webView.getSettings().setSaveFormData(true);
    webView.setWebViewClient(new MyWebViewClient());

    // Show an OK button.
    View doneButton = findViewById(R.id.done_button);
    doneButton.setOnClickListener(doneListener);
  }
   private class MyWebViewClient extends WebViewClient {
     @Override
      //show the web page in webview but not in web browser
      public boolean shouldOverrideUrlLoading(WebView view, String url) {
      view.loadUrl (url);
      return true;
    }
  }
}