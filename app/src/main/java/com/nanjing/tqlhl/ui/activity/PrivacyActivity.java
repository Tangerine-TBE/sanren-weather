package com.nanjing.tqlhl.ui.activity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.nanjing.tqlhl.base.BaseMainActivity;
import com.nanjing.tqlhl.utils.PackageUtil;
import com.nanjing.tqlhl.R;

import butterknife.BindView;

public class PrivacyActivity extends BaseMainActivity {


    @Override
    public int getLayoutId() {
        return R.layout.activity_privacy;
    }

    @BindView(R.id.iv_bar_back)
    ImageView iv_bar_back;

    @BindView(R.id.tv_bar_title)
    TextView tv_bar_title;
//    @BindView(R.id.text)
//    TextView mWordAlignTextView;
//    @BindView(R.id.privacy_toolbar)
//    RelativeLayout privacy_toolbar;
    @BindView(R.id.webView)
    WebView webView;


    @Override
    protected void intView() {
        tv_bar_title.setVisibility(View.VISIBLE);
        tv_bar_title.setText(getString(R.string.user_Privacy));
//        mWordAlignTextView.setText(PackageUtil.difPlatformName(this,R.string.privacy));
//        mWordAlignTextView.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//                ClipboardManager clipboardManager=(ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
//                clipboardManager.setPrimaryClip(ClipData.newPlainText("隐私政策",mWordAlignTextView.getText()));
//                Toast.makeText(PrivacyActivity.this,"复制成功",Toast.LENGTH_SHORT).show();
//                return true;
//            }
//        });
        initWebView();
    }

    @Override
    protected void intEvent() {
        iv_bar_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (webView.canGoBack()){
                    webView.goBack();
                }else{
                    finish();
                }
            }
        });
    }

    private void initWebView() {
        webView.setWebChromeClient(new WebChromeClient());
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
//        webSettings.useWideViewPort = true
//        webSettings.loadWithOverviewMode = true

        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.LOLLIPOP){
            webSettings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);

        webSettings.setDomStorageEnabled(true);//不加这句有些h5登陆窗口出不来 H5页面使用DOM storage API导致的页面加载问题
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        webSettings.setAllowFileAccess(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setLoadsImagesAutomatically(true);
        webSettings.setDefaultTextEncodingName("utf-8");
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return false;
            }
        });
//            override fun onPageFinished(view: WebView?, url: String?) {
//                super.onPageFinished(view, url)
//                webView.loadUrl("javascript:androidSetAppName('${packageManager.getApplicationLabel(applicationInfo)}')")
//                webView.loadUrl("javascript:androidSetCompanyName('${com}')")
//                webView.loadUrl("javascript:androidSetEmail('${email}')")
//            }

        //加载网络资源
        webView.loadUrl("https://catapi.aisou.club/android/privacy_policy.html?app_name="+getPackageManager().getApplicationLabel(getApplicationInfo())+"&pack_name="+getPackageName());
    }

    @Override
    protected void onResume() {
        super.onResume();
        webView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        webView.onPause();
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()){
            webView.goBack();
        }else{
            finish();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        webView.destroy();
    }
}