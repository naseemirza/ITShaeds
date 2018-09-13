package tbs.thinkbiz.solutions.itshades.Jobs;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import tbs.thinkbiz.solutions.itshades.AllUrls;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JobsFilterActivity extends AppCompatActivity {

    private Spinner spinerCntry,spinerConfCntry,spinerRL;
    private ArrayList<String> Country =new ArrayList<String>();
    private ArrayList<String> ConfCountry =new ArrayList<String>();
    private ArrayList<String> Rolvl =new ArrayList<String>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(tbs.thinkbiz.solutions.itshades.R.layout.activity_jobs_filter);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(tbs.thinkbiz.solutions.itshades.R.layout.jobsfilterbar);
        View view =getSupportActionBar().getCustomView();

        ImageButton imageButton= (ImageButton)view.findViewById(tbs.thinkbiz.solutions.itshades.R.id.action_bar_back);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ImageButton imageButton2= (ImageButton)view.findViewById(tbs.thinkbiz.solutions.itshades.R.id.action_bar_forward);

        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(JobsFilterActivity.this,CmpProfFilterActivity.class));
            }
        });

        spinerRL = (Spinner) findViewById(tbs.thinkbiz.solutions.itshades.R.id.spinnerRolllevel);
        getDataRolvl();

        spinerCntry = (Spinner) findViewById(tbs.thinkbiz.solutions.itshades.R.id.spinnercntry);
        getDataCountry();

        spinerConfCntry = (Spinner) findViewById(tbs.thinkbiz.solutions.itshades.R.id.spinnercrntcntry);
        getDataConfCountry();

    }

    private void  getDataCountry() {

        StringRequest stringRequest=new StringRequest(Request.Method.GET, AllUrls.COUNTRY,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Log.e("rootJsonArray",response);
                        try{
                            JSONArray rootJsonArray = new JSONArray(response);

                            for(int i=0;i<rootJsonArray.length();i++){
                                JSONObject jsonObject1=rootJsonArray.getJSONObject(i);
                                String country=jsonObject1.getString("name");
                                Country.add(country);
                            }

                            spinerCntry.setAdapter(new ArrayAdapter<String>(JobsFilterActivity.this, tbs.thinkbiz.solutions.itshades.R.layout.spinneritems, Country));

                        }catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        int socketTimeout = 30000;
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        stringRequest.setRetryPolicy(policy);
        requestQueue.add(stringRequest);
    }

    private void  getDataConfCountry() {

        StringRequest stringRequest=new StringRequest(Request.Method.GET, AllUrls.COUNTRY,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Log.e("rootJsonArray",response);
                        try{
                            JSONArray rootJsonArray = new JSONArray(response);

                            for(int i=0;i<rootJsonArray.length();i++){
                                JSONObject jsonObject1=rootJsonArray.getJSONObject(i);
                                String country=jsonObject1.getString("name");
                                ConfCountry.add(country);
                            }

                            spinerConfCntry.setAdapter(new ArrayAdapter<String>(JobsFilterActivity.this, tbs.thinkbiz.solutions.itshades.R.layout.spinneritems, ConfCountry));

                        }catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        int socketTimeout = 30000;
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        stringRequest.setRetryPolicy(policy);
        requestQueue.add(stringRequest);
    }

    private void  getDataRolvl() {

        StringRequest stringRequest=new StringRequest(Request.Method.GET, AllUrls.ROLL_LEVEL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Log.e("rootJsonArray",response);
                        try{
                            JSONArray rootJsonArray = new JSONArray(response);

                            for(int i=0;i<rootJsonArray.length();i++){
                                JSONObject jsonObject1=rootJsonArray.getJSONObject(i);
                                String country=jsonObject1.getString("name");
                                Rolvl.add(country);
                            }

                            spinerRL.setAdapter(new ArrayAdapter<String>(JobsFilterActivity.this, tbs.thinkbiz.solutions.itshades.R.layout.spinneritems, Rolvl));

                        }catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        int socketTimeout = 30000;
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        stringRequest.setRetryPolicy(policy);
        requestQueue.add(stringRequest);
    }
}
