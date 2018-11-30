package tbs.thinkbiz.solutions.itshades.MainPageTab.BusinessCorner;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import tbs.thinkbiz.solutions.itshades.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BusnsRevsFrag extends Fragment {

    WebView mywebview;
    ProgressDialog progressDialog;
    String uid;

    public BusnsRevsFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_busns_revs, container, false);


        SharedPreferences pref = getActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        uid = pref.getString("userId", "");

        mywebview = (WebView) rootView.findViewById(R.id.webView1);
        mywebview.setWebViewClient(new MyWebViewClient());
        String url= "https://www.itshades.com/appwebservices/company-reviews.php?uid="+uid;
        mywebview.getSettings().setJavaScriptEnabled(true);
        mywebview.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        mywebview.loadUrl(url);

        return rootView;
    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            progressDialog = new ProgressDialog(getActivity());
            progressDialog.setMessage("Please wait ...");
            progressDialog.setProgressStyle(90);
            progressDialog.show();
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            if (progressDialog != null) {
                progressDialog.dismiss();
            }
        }
    }
}

