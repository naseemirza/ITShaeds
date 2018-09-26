package tbs.thinkbiz.solutions.itshades.CorpCustomer.SubmissionLink.LearnAndDevlp;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.TextView;

import tbs.thinkbiz.solutions.itshades.CorpCustomer.SubmissionLink.WebinarB.AddNewWebinarActivity;
import tbs.thinkbiz.solutions.itshades.CorpCustomer.SubmissionLink.WebinarB.WebinarBActivity;
import tbs.thinkbiz.solutions.itshades.R;

public class AddNewLnDActivity extends AppCompatActivity {

    WebView mywebview;
    ProgressDialog progressDialog;
    String uid,CatId;

    String Actname;
    TextView textname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_ln_d);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.backbar);
        View view =getSupportActionBar().getCustomView();

        SharedPreferences pref = this.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        Actname=pref.getString("Actvname","");
        uid=pref.getString("userid","");
        CatId = pref.getString("CatId", "");
        Log.e("rootJsonArray",uid);


        textname=(TextView)findViewById(R.id.textname);
        textname.setText(Actname);

        ImageButton imageButton= (ImageButton)view.findViewById(R.id.action_bar_back);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //finish();
                if (CatId.equalsIgnoreCase("1"))
                {
                    String actname="Online Trainng";

                    SharedPreferences pref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                    SharedPreferences.Editor edit = pref.edit();

                    edit.putString("Actvname",actname);
                    edit.commit();

                    Intent intent=new Intent(AddNewLnDActivity.this, OnlnTrangActivity.class);
                    startActivity(intent);
                }
                else if (CatId.equalsIgnoreCase("2"))
                {
                    String actname="Classroom Trainng";

                    SharedPreferences pref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                    SharedPreferences.Editor edit = pref.edit();

                    edit.putString("Actvname",actname);
                    edit.commit();

                    Intent intent=new Intent(AddNewLnDActivity.this, ClassRmTrngActivity.class);
                    startActivity(intent);
                }

                else if (CatId.equalsIgnoreCase("3"))
                {
                    String actname="Certification";

                    SharedPreferences pref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                    SharedPreferences.Editor edit = pref.edit();

                    edit.putString("Actvname",actname);
                    edit.commit();

                    Intent intent=new Intent(AddNewLnDActivity.this, CertifictinActivity.class);
                    startActivity(intent);
                }
                else if (CatId.equalsIgnoreCase("4"))
                {
                    String actname="On Demand Trainng";

                    SharedPreferences pref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                    SharedPreferences.Editor edit = pref.edit();

                    edit.putString("Actvname",actname);
                    edit.commit();

                    Intent intent=new Intent(AddNewLnDActivity.this, OnDemndTrngActivity.class);
                    startActivity(intent);
                }

            }
        });


        mywebview = (WebView) findViewById(R.id.webView1);
        mywebview.setWebViewClient(new MyWebViewClient());

        //editkey=2434

        String url="https://www.itshades.com/appdata/emp-addnewonlinetraining.php?&cat_id="+CatId+"&uid="+uid;

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
            progressDialog = new ProgressDialog(AddNewLnDActivity.this);
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