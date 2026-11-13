package com.sanctuary.pranayama3d;
import android.app.Activity;
import android.os.Bundle;
import android.view.WindowManager;
import android.webkit.*;
import android.content.Intent;
import android.net.Uri;
public class MainActivity extends Activity {
 private WebView webView;
 @Override public void onCreate(Bundle b) {
  super.onCreate(b);
  getWindow().setStatusBarColor(android.graphics.Color.rgb(6,4,13));
  getWindow().setNavigationBarColor(android.graphics.Color.rgb(6,4,13));
  getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
  webView=new WebView(this); webView.setBackgroundColor(android.graphics.Color.rgb(6,4,13));
  WebSettings s=webView.getSettings(); s.setJavaScriptEnabled(true); s.setDomStorageEnabled(true);
  s.setDatabaseEnabled(true); s.setMediaPlaybackRequiresUserGesture(false); s.setLoadsImagesAutomatically(true);
  s.setMixedContentMode(WebSettings.MIXED_CONTENT_NEVER_ALLOW); s.setAllowFileAccess(true);
  webView.setWebViewClient(new WebViewClient(){
   @Override public boolean shouldOverrideUrlLoading(WebView v, WebResourceRequest r){
    Uri u=r.getUrl(); String scheme=u.getScheme()==null?"":u.getScheme();
    if("http".equals(scheme)||"https".equals(scheme)||"mailto".equals(scheme)||"tel".equals(scheme)){
     try { startActivity(new Intent(Intent.ACTION_VIEW,u)); } catch(Exception ignored){}
     return true;
    } return false;
   }
  });
  webView.setWebChromeClient(new WebChromeClient());
  setContentView(webView); webView.loadUrl("file:///android_asset/index.html");
 }
 @Override public void onBackPressed(){ if(webView!=null&&webView.canGoBack())webView.goBack(); else super.onBackPressed(); }
 @Override protected void onDestroy(){ if(webView!=null){webView.loadUrl("about:blank");webView.destroy();} super.onDestroy(); }
}
