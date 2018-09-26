package tbs.thinkbiz.solutions.itshades.CorpCustomer.SubmissionLink.MarkEvents;

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

import tbs.thinkbiz.solutions.itshades.CorpCustomer.SubmissionLink.ArtifactsB.AnalysReprtActivity;
import tbs.thinkbiz.solutions.itshades.CorpCustomer.SubmissionLink.ArtifactsB.ArtEditActivity;
import tbs.thinkbiz.solutions.itshades.CorpCustomer.SubmissionLink.ArtifactsB.CustScsStoriesActivity;
import tbs.thinkbiz.solutions.itshades.CorpCustomer.SubmissionLink.ArtifactsB.WhtPapersActivity;
import tbs.thinkbiz.solutions.itshades.R;

public class EvntEditActivity extends AppCompatActivity {

    WebView mywebview;
    ProgressDialog progressDialog;

    String editurl ,CatId,uid;
    String Actname;
    TextView textname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evnt_edit);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.backbar);
        View view =getSupportActionBar().getCustomView();

        SharedPreferences pref = this.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        Actname=pref.getString("Actvname","");
        CatId = pref.getString("CatId", "");
        uid=pref.getString("userid","");
        editurl=pref.getString("EditableUrl","");


        //editurl+"&cat_id="+CatId+"&uid="+uid;


        //Log.e("url",EditUrl);

        textname=(TextView)findViewById(R.id.textname);
        textname.setText(Actname);

        ImageButton imageButton= (ImageButton)view.findViewById(R.id.action_bar_back);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (CatId.equalsIgnoreCase("1")){
                    String actname="Online Events";

                    SharedPreferences pref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                    SharedPreferences.Editor edit = pref.edit();

                    edit.putString("Actvname",actname);
                    edit.commit();

                    Intent intent=new Intent(EvntEditActivity.this, OnlinEvntsActivity.class);
                    startActivity(intent);

                }
                else if (CatId.equalsIgnoreCase("2")){

                    String actname="Conferences & Summits";

                    SharedPreferences pref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                    SharedPreferences.Editor edit = pref.edit();

                    edit.putString("Actvname",actname);
                    edit.commit();

                    Intent intent=new Intent(EvntEditActivity.this, ConfAndSummtsActivity.class);
                    startActivity(intent);

                }

            }
        });


        mywebview = (WebView) findViewById(R.id.webView1);
        mywebview.setWebViewClient(new MyWebViewClient());

        //String EditUrl="https://www.itshades.com/appdata/emp-addnewonlinetraining.php?editkey=2434&cat_id=1&uid=329";

        String Edit_URL=editurl+"&cat_id="+CatId+"&uid="+uid;

        Log.e("url",Edit_URL);

        mywebview.getSettings().setJavaScriptEnabled(true);
        mywebview.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        mywebview.loadUrl(Edit_URL);
        
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
            progressDialog = new ProgressDialog(EvntEditActivity.this);
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
