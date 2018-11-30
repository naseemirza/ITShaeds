package tbs.thinkbiz.solutions.itshades.Events.OnlineEvent;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import tbs.thinkbiz.solutions.itshades.LearningAndDevelopment.ContactForm;
import tbs.thinkbiz.solutions.itshades.LearningAndDevelopment.LandDetailsActivity;
import tbs.thinkbiz.solutions.itshades.LearningAndDevelopment.LnDRltdAdapter;
import tbs.thinkbiz.solutions.itshades.LearningAndDevelopment.LnDRltdModel;
import tbs.thinkbiz.solutions.itshades.LearningAndDevelopment.TableAdapter;
import tbs.thinkbiz.solutions.itshades.LearningAndDevelopment.TableModel;
import tbs.thinkbiz.solutions.itshades.R;

public class OnlineEventDetailsActivity extends AppCompatActivity {

    String Actname;
    TextView textname;
    WebView mywebview;
    ProgressDialog progressDialog;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_event_details);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.backbar);
        View view = getSupportActionBar().getCustomView();

        SharedPreferences pref = this.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        Actname = pref.getString("Actvname", "");
         url = pref.getString("url", "");
//        //CatId = pref.getString("CatId", "");
//        id = pref.getString("Id", "");
//        uid = pref.getString("UserId", "");


        textname = (TextView) findViewById(R.id.textname);
        textname.setText(Actname);

        ImageButton imageButton = (ImageButton) view.findViewById(R.id.action_bar_back);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mywebview = (WebView) findViewById(R.id.webView1);
        mywebview.setWebViewClient(new MyWebViewClient());
        //String url= "https://www.itshades.com/appwebservices/company-profile.php?uid="+uid;
        mywebview.getSettings().setJavaScriptEnabled(true);
        mywebview.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        mywebview.loadUrl(url);

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
            progressDialog = new ProgressDialog(OnlineEventDetailsActivity.this);
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
