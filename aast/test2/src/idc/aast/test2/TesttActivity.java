package idc.aast.test2;


import com.bugsense.trace.BugSenseHandler;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;

import android.view.Menu;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class TesttActivity extends Activity {
	static WebView mWebView;
	static String rslt;
	static String data;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		BugSenseHandler.initAndStartSession(getApplicationContext(),"1fd17091");

		setContentView(R.layout.testt);
		
		mWebView = (WebView) findViewById(R.id.mWebView);
		Intent intent= getIntent();
		WebSettings ws= mWebView.getSettings();
		//ws.setJavaScriptEnabled(true);
		ws.setSupportZoom(true);
	ws.setBuiltInZoomControls(true);
//	ws.setDisplayZoomControls(true);
	ws.setUseWideViewPort(true);
	TesttActivity.mWebView.setWebViewClient(new WebViewClient(){

	    @Override
	    public boolean shouldOverrideUrlLoading(WebView view, String url){
	      view.loadUrl(url);
	      return true;
	    }
	});
		mWebView.loadUrl(intent.getStringExtra("url"));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.testt, menu);

		return true;
	}

}
