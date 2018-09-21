package tbs.thinkbiz.solutions.itshades.CorpCustomer.SubmissionLink.JobSubmission;

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

import tbs.thinkbiz.solutions.itshades.AllUrls;
import tbs.thinkbiz.solutions.itshades.CorpCustomer.SubmissionLink.ParentActivity;
import tbs.thinkbiz.solutions.itshades.LearningAndDevelopment.ClassroomTraingActivity;
import tbs.thinkbiz.solutions.itshades.LearningAndDevelopment.LnDAdapter;
import tbs.thinkbiz.solutions.itshades.LearningAndDevelopment.LnDModel;
import tbs.thinkbiz.solutions.itshades.R;

public class JobSubmiActivity extends AppCompatActivity {


    Button jobadd;

    String Actname;
    TextView textname;

    private JobSubAdapter mExampleAdapter1;
    private ArrayList<JobSubModel> mExampleList1;
    private RequestQueue mRequestQueue1;
    private RecyclerView mRecyclerview1;

//    WebView mywebview;
//    ProgressDialog progressDialog;

    String uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_submi);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.backbar);
        View view =getSupportActionBar().getCustomView();

        SharedPreferences pref = this.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        Actname=pref.getString("Actvname","");
        uid=pref.getString("userid","");
         Log.e("rootJsonArray",uid);

        textname=(TextView)findViewById(R.id.textname);
        textname.setText(Actname);

        ImageButton imageButton= (ImageButton)view.findViewById(R.id.action_bar_back);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // finish();

                String actname="Submission Links";

                SharedPreferences pref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = pref.edit();

                edit.putString("Actvname",actname);
                edit.commit();

                Intent intent=new Intent(JobSubmiActivity.this, ParentActivity.class);
                startActivity(intent);

            }
        });

        jobadd=(Button)findViewById(R.id.addnewjob);
        jobadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String actname="Add New Job";
                SharedPreferences pref = v.getContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = pref.edit();

                edit.putString("Actvname",actname);
                edit.commit();

               Intent intent=  new Intent(JobSubmiActivity.this,AddnewJobActivity.class);
                startActivity(intent);
            }
        });

//        mywebview = (WebView) findViewById(R.id.webView1);
//        mywebview.setWebViewClient(new JobSubmiActivity.MyWebViewClient());
//
//        String url="https://www.itshades.com/appdata/employer-job.php?uid="+uid;
//        mywebview.getSettings().setJavaScriptEnabled(true);
//        mywebview.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
//        mywebview.loadUrl(url);

        mExampleList1 = new ArrayList<>();
        mRequestQueue1 = Volley.newRequestQueue(this);

        mRecyclerview1=(RecyclerView)findViewById(R.id.my_recycler_jobs);
        mRecyclerview1.setNestedScrollingEnabled(false);
        mRecyclerview1.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        mRecyclerview1.setHasFixedSize(true);

        parseJSON1();
    }

//    private class MyWebViewClient extends WebViewClient {
//        @Override
//        public boolean shouldOverrideUrlLoading(WebView view, String url) {
//            view.loadUrl(url);
//            return true;
//        }
//
//        @Override
//        public void onPageStarted(WebView view, String url, Bitmap favicon) {
//            super.onPageStarted(view, url, favicon);
//            progressDialog = new ProgressDialog(JobSubmiActivity.this);
//            progressDialog.setMessage("Please wait ...");
//            progressDialog.setProgressStyle(90);
//            progressDialog.show();
//        }
//        @Override
//        public void onPageFinished(WebView view, String url) {
//            super.onPageFinished(view, url);
//            if (progressDialog != null) {
//                progressDialog.dismiss();
//            }
//        }
//    }



    private void parseJSON1() {

        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);


        StringRequest stringRequest = new StringRequest(Request.Method.GET, "https://www.itshades.com/appdata/employer-job.php?uid="+uid,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        progressBar.setVisibility(View.INVISIBLE);

                        try {
                            Log.e("rootJsonArray",response);
                            JSONArray rootJsonArray = new JSONArray(response);

                            Log.e("rootJsonArrayLength",rootJsonArray.length()+"");

                            for (int i = 0; i < rootJsonArray.length(); i++) {
                                JSONObject object = rootJsonArray.getJSONObject(i);

                                mExampleList1.add(new JobSubModel(object.optString("id"),
                                        object.optString("job_title"),
                                        object.optString("job_keyskill"),
                                        object.optString("job_description"),
                                        object.optString("editdata")));

                            }

                            Log.e("rootJsonArray",mExampleList1.size()+"");

                            mExampleAdapter1 = new JobSubAdapter(JobSubmiActivity.this, mExampleList1);
                            mRecyclerview1.setAdapter(mExampleAdapter1);
                            mExampleAdapter1.notifyDataSetChanged();
                            mRecyclerview1.setHasFixedSize(true);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                        Log.e("TAg",error.getMessage());
                    }
                });

        mRequestQueue1 = Volley.newRequestQueue(this);
        mRequestQueue1.add(stringRequest);
    }
}
