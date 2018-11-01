package tbs.thinkbiz.solutions.itshades.Jobs;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import tbs.thinkbiz.solutions.itshades.AllUrls;
import tbs.thinkbiz.solutions.itshades.CorpCustomer.SubmissionLink.JobSubmission.JobSubmiActivity;
import tbs.thinkbiz.solutions.itshades.CorpCustomer.SubmissionLink.ParentActivity;
import tbs.thinkbiz.solutions.itshades.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class CrntJobFilterActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener  {


    Button btnsrch;
    String Actname;
    TextView textname;
    private Spinner spinerFE,spinerInd,spinerExp,spinerCntry,spinerRL;
    ImageButton imageButton;

    private ArrayList<String> FuncExprt =new ArrayList<String>();
    private ArrayList<String> FuncExprtid =new ArrayList<String>();
    private ArrayList<String> Indst =new ArrayList<String>();
    private ArrayList<String> Indstid =new ArrayList<String>();
    private ArrayList<String> YrExp =new ArrayList<String>();
    private ArrayList<String> YrExpid =new ArrayList<String>();
    private ArrayList<String> Country =new ArrayList<String>();
    private ArrayList<String> Countryid =new ArrayList<String>();
    private ArrayList<String> Rolvl =new ArrayList<String>();
    private ArrayList<String> Rolvlid =new ArrayList<String>();

    String FExp,IndR,yrExp,Contry,Rllvl,Edttext;
    EditText EdtSrch;

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
        spinerFE.setOnItemSelectedListener(this);
        getDataFE();

        spinerInd = (Spinner) findViewById(R.id.spinnerInd);
        spinerInd.setOnItemSelectedListener(this);
        getDataInd();

        spinerExp = (Spinner) findViewById(R.id.spinnerExp);
        spinerExp.setOnItemSelectedListener(this);
        getDataExp();

        spinerCntry = (Spinner) findViewById(R.id.spinnerCntry);
        spinerCntry.setOnItemSelectedListener(this);
        getDataCountry();

        spinerRL = (Spinner) findViewById(R.id.spinnerRlllvl);
        spinerRL.setOnItemSelectedListener(this);
        getDataRolvl();


        btnsrch=(Button)findViewById(R.id.btnjobsrch);
        btnsrch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //yrExp1=spinerExp.getTx
                EdtSrch=(EditText)findViewById(R.id.editTextsrch);
                Edttext=EdtSrch.getText().toString();

                String actname="Current Jobs";
                SharedPreferences pref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = pref.edit();
                edit.putString("Actvname",actname);
                edit.putString("FE",FExp);
                edit.putString("INDR",IndR);
                edit.putString("YREXP",yrExp);
                edit.putString("CONYRY",Contry);
                edit.putString("ROLLVL",Rllvl);
                edit.putString("EditSearch",Edttext);
                edit.apply();

                Intent intent=new Intent(CrntJobFilterActivity.this, CrntJobFilterationActivity.class);
                startActivity(intent);

                Log.e("rootJsonArray",yrExp);
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        Spinner spinner = (Spinner) parent;

        if(spinner.getId() == R.id.spinnerFE)
        {
            FExp=FuncExprtid.get((int) id);
        }
        else if(spinner.getId() == R.id.spinnerInd)
        {
            IndR=Indstid.get((int) id);
        }
        else if(spinner.getId() == R.id.spinnerExp)
        {
            yrExp=YrExpid.get((int) id);
        }
        else if(spinner.getId() == R.id.spinnerCntry)
        {
            Contry= Countryid.get((int) id);
        }
        else if(spinner.getId() == R.id.spinnerRlllvl)
        {
            Rllvl=Rolvlid.get((int) id);
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    private void  getDataFE() {

        StringRequest stringRequest=new StringRequest(Request.Method.GET, AllUrls.FUNC_EXPERTIES,
                new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
               // Log.e("rootJsonArray",response);
                try{
                    JSONArray rootJsonArray = new JSONArray(response);

                        for(int i=0;i<rootJsonArray.length();i++){
                            JSONObject jsonObject1=rootJsonArray.getJSONObject(i);
                            String feid=jsonObject1.getString("id");
                            String country=jsonObject1.getString("expertise_name");
                            FuncExprtid.add(feid);
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

        StringRequest stringRequest=new StringRequest(Request.Method.GET, AllUrls.INDUSTRY,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Log.e("rootJsonArray",response);
                        try{
                            JSONArray rootJsonArray = new JSONArray(response);

                            for(int i=0;i<rootJsonArray.length();i++){
                                JSONObject jsonObject1=rootJsonArray.getJSONObject(i);
                                String Indid=jsonObject1.getString("id");
                                String country=jsonObject1.getString("industry_name");
                                Indstid.add(Indid);
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

        StringRequest stringRequest=new StringRequest(Request.Method.GET, AllUrls.YEAR_EXP,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Log.e("rootJsonArray",response);
                        try{
                            JSONArray rootJsonArray = new JSONArray(response);

                            for(int i=0;i<rootJsonArray.length();i++){
                                JSONObject jsonObject1=rootJsonArray.getJSONObject(i);
                                String yrxp =jsonObject1.getString("id");
                                String country=jsonObject1.getString("exp_name");
                                YrExpid.add(yrxp);
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

        StringRequest stringRequest=new StringRequest(Request.Method.GET, AllUrls.COUNTRY,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Log.e("rootJsonArray",response);
                        try{
                            JSONArray rootJsonArray = new JSONArray(response);

                            for(int i=0;i<rootJsonArray.length();i++){
                                JSONObject jsonObject1=rootJsonArray.getJSONObject(i);
                                String cntrid=jsonObject1.getString("id");
                                String country=jsonObject1.getString("name");
                                Countryid.add(cntrid);
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

        StringRequest stringRequest=new StringRequest(Request.Method.GET, AllUrls.ROLL_LEVEL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Log.e("rootJsonArray",response);
                        try{
                            JSONArray rootJsonArray = new JSONArray(response);

                            for(int i=0;i<rootJsonArray.length();i++){
                                JSONObject jsonObject1=rootJsonArray.getJSONObject(i);
                                String rlvl=jsonObject1.getString("id");
                                String country=jsonObject1.getString("name");
                                Rolvlid.add(rlvl);
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
