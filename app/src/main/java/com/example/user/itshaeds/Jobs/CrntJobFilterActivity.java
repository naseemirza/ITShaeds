package com.example.user.itshaeds.Jobs;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.user.itshaeds.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class CrntJobFilterActivity extends AppCompatActivity  {


    String Actname;
    TextView textname;
    private Spinner spinerFE,spinerInd,spinerExp,spinerCntry,spinerRL;
    ImageButton imageButton;

    private ArrayList<String> FuncExprt =new ArrayList<String>();
    private ArrayList<String> Indst =new ArrayList<String>();
    private ArrayList<String> YrExp =new ArrayList<String>();
    private ArrayList<String> Country =new ArrayList<String>();
    private ArrayList<String> Rolvl =new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crnt_job_filter);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.backbar);
        View view =getSupportActionBar().getCustomView();

        SharedPreferences pref = this.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        Actname=pref.getString("Actvname","");
        textname=(TextView)findViewById(R.id.textname);
        textname.setText(Actname);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        imageButton=(ImageButton)findViewById(R.id.action_bar_back);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        spinerFE = (Spinner) findViewById(R.id.spinnerFE);

        getDataFE();
//        spinerFE.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                String country=   spinerFE.getItemAtPosition(spinerFE.getSelectedItemPosition()).toString();
//                Toast.makeText(getApplicationContext(),country,Toast.LENGTH_LONG).show();
//            }
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//                // DO Nothing here
//            }
//        });


        spinerInd = (Spinner) findViewById(R.id.spinnerInd);
        getDataInd();

        spinerExp = (Spinner) findViewById(R.id.spinnerExp);
        getDataExp();

        spinerCntry = (Spinner) findViewById(R.id.spinnerCntry);
        getDataCountry();


        spinerRL = (Spinner) findViewById(R.id.spinnerRlllvl);
        getDataRolvl();

    }

    private void  getDataFE() {

        StringRequest stringRequest=new StringRequest(Request.Method.GET, "https://www.itshades.com/appwebservices/functional-expertise.php",
                new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
               // Log.e("rootJsonArray",response);
                try{
                    JSONArray rootJsonArray = new JSONArray(response);

                        for(int i=0;i<rootJsonArray.length();i++){
                            JSONObject jsonObject1=rootJsonArray.getJSONObject(i);
                            String country=jsonObject1.getString("expertise_name");
                            FuncExprt.add(country);
                        }

                    spinerFE.setAdapter(new ArrayAdapter<String>(CrntJobFilterActivity.this, R.layout.spinneritems, FuncExprt));

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



    private void  getDataInd() {

        StringRequest stringRequest=new StringRequest(Request.Method.GET, "https://www.itshades.com/appwebservices/industry.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Log.e("rootJsonArray",response);
                        try{
                            JSONArray rootJsonArray = new JSONArray(response);

                            for(int i=0;i<rootJsonArray.length();i++){
                                JSONObject jsonObject1=rootJsonArray.getJSONObject(i);
                                String country=jsonObject1.getString("industry_name");
                                Indst.add(country);
                            }

                            spinerInd.setAdapter(new ArrayAdapter<String>(CrntJobFilterActivity.this, R.layout.spinneritems, Indst));

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

    private void  getDataExp() {

        StringRequest stringRequest=new StringRequest(Request.Method.GET, "https://www.itshades.com/appwebservices/experience-year.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Log.e("rootJsonArray",response);
                        try{
                            JSONArray rootJsonArray = new JSONArray(response);

                            for(int i=0;i<rootJsonArray.length();i++){
                                JSONObject jsonObject1=rootJsonArray.getJSONObject(i);
                                String country=jsonObject1.getString("exp_name");
                                YrExp.add(country+" Years");
                            }

                            spinerExp.setAdapter(new ArrayAdapter<String>(CrntJobFilterActivity.this, R.layout.spinneritems, YrExp));

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



    private void  getDataCountry() {

        StringRequest stringRequest=new StringRequest(Request.Method.GET, "https://www.itshades.com/appwebservices/country.php",
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

                            spinerCntry.setAdapter(new ArrayAdapter<String>(CrntJobFilterActivity.this, R.layout.spinneritems, Country));

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

        StringRequest stringRequest=new StringRequest(Request.Method.GET, "https://www.itshades.com/appwebservices/role-level.php",
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

                            spinerRL.setAdapter(new ArrayAdapter<String>(CrntJobFilterActivity.this, R.layout.spinneritems, Rolvl));

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
