package com.myapplication.domain.event;


import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.myapplication.BaseFragment;
import com.myapplication.R;
import com.myapplication.utils.LogUtils;

import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;


/**
 * Created by Administrator on 2017/6/9.
 */

public class EventFragment extends BaseFragment {


    private TextView tv_content;
    private WebView webview;
    private String url = "www.baidu.com";

    public static EventFragment newInstance(String content) {
        EventFragment fragment = new EventFragment();
        Bundle bundle = new Bundle();
        bundle.putString(EXTRA_NAME, content);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_event, container, false);
    }


    @Override
    protected void initView(View view) {
        super.initView(view);
        webview = (WebView) view.findViewById(R.id.webview);
        WebSettings webSetting = webview.getSettings();
        String userAgent = webSetting.getUserAgentString();
        webSetting.setUserAgentString(userAgent + " fkls_student");
        LogUtils.e(TAG, "UserAgent=" + webSetting.getUserAgentString());
        //访问的页面中支持Javascript交互，
        webSetting.setJavaScriptEnabled(true);
        //设置插件状态
        webSetting.setPluginState(WebSettings.PluginState.ON);
        //支持插件
//        webSettings.setPluginsEnabled(true);
        //设置界面支持缩放
        webSetting.setSupportZoom(true);
        //支持通过JS打开新窗口
        webSetting.setJavaScriptCanOpenWindowsAutomatically(true);
        // 开启 DOM storage API 功能 :会话级别的存储,关闭就消失,
        webSetting.setDomStorageEnabled(true);
        //开启 database storage API 功能
        webSetting.setDatabaseEnabled(true);
//        String databasePath = getDir("database", Context.MODE_PRIVATE).getPath();
//        webSetting.setDatabasePath(databasePath);
        webSetting.setGeolocationEnabled(true);
//        webSetting.setGeolocationDatabasePath(databasePath);
        // 设置支持打开多个界面
        webSetting.setSupportMultipleWindows(true);
        // 缩放至屏幕的大小
        webSetting.setLoadWithOverviewMode(true);
        // 启用或禁止WebView访问文件数据
        webSetting.setAllowFileAccess(true);
        // 设置缓存模式
        webSetting.setCacheMode(WebSettings.LOAD_DEFAULT);
        //设置编码格式
        webSetting.setDefaultTextEncodingName("UTF-8");
        // add 根据H5界面的viewport字体大小设定显示字体大小
        //将图片调整到适合webview的大小
        webSetting.setUseWideViewPort(true);
        // 设置无边框
        webview.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        //WebView在加载图片的时候会出现白屏的情况:
        //无论硬件加速是否打开，都会有一张Bitmap（software layer），并在上面对WebView进行软渲染。
//      webView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        //触摸焦点起作用.如果不设置，则在点击网页文本输入框时，不能弹出软键盘及不响应其他的一些事件。
//        1.对应的View不支持Focus
//        2.对应的View支持Focus，但是不支持在Touch模式下的Focus。
        webview.requestFocus();
//        解决requestFocus()的第二种不能获得焦点的情况，
// 也就是说即使在Touch模式下不支持焦点，也能够获得焦点。
        webview.requestFocusFromTouch();
        setWebChromeClient();
        setWebViewClient();
        if (!TextUtils.isEmpty(url)) {
            webview.loadUrl(url);
        }


    }


    private void setWebViewClient() {
        webview.setWebViewClient(mWebViewclient);
    }

    /**
     * 简单的WebViewClient，只显示/隐藏进度条
     */
    private WebViewClient mWebViewclient = new WebViewClient() {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            //加载网页,显示进度条
//            baseHelper().showProgressBar();
        }

        // 修复不能拨打电话问题
        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            System.out.println("uri_________"+url);
            if (url.startsWith("tel:")) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse(url));
                startActivity(intent);
                return true;
            } else {
                return super.shouldOverrideUrlLoading(view, url);
            }
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            //加载网页完成,隐藏进度条
//            baseHelper().hideProgressBar();
            //修复WebView.goBack()时Title还显示下一个页面的Title的BUG
            //setNaviHeadTitle(view.getTitle());updatedView
        }
    };

    /**
     * --主要处理解析，渲染网页等浏览器做的事情
     */
    private void setWebChromeClient() {
        webview.setWebChromeClient(mFileChooserWebChromeClient);
    }

    /**
     * file chooser
     */
    private WebChromeClient mFileChooserWebChromeClient = new WebChromeClient() {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
        }

        @Override
        public void onReceivedTitle(WebView view, String title) {
            //setNaviHeadTitle(title);
            //setRightButton(title);
        }

        // <3.0 调用这个方法
        @SuppressWarnings("unused")
        public void openFileChooser(ValueCallback<Uri> uploadMsg) {
            // openFileChooserExe(uploadMsg);
        }

        // 3.0 + 调用这个方法
        @SuppressWarnings("unused")
        public void openFileChooser(ValueCallback<Uri> uploadMsg,
                                    String acceptType) {
            //openFileChooserExe(uploadMsg);
        }

        // Android > 4.1.1 调用这个方法
        @SuppressWarnings("unused")
        public void openFileChooser(ValueCallback<Uri> uploadMsg,
                                    String acceptType, String capture) {
            // openFileChooserExe(uploadMsg);
        }
    };


}
