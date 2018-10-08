package tbs.thinkbiz.solutions.itshades.CorpCustomer.SubmissionLink.LearnAndDevlp.Filteration;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import tbs.thinkbiz.solutions.itshades.AllUrls;
import tbs.thinkbiz.solutions.itshades.CorpCustomer.SubmissionLink.LearnAndDevlp.CertifictinActivity;
import tbs.thinkbiz.solutions.itshades.CorpCustomer.SubmissionLink.LearnAndDevlp.ClassRmTrngActivity;
import tbs.thinkbiz.solutions.itshades.CorpCustomer.SubmissionLink.LearnAndDevlp.LnDCorpEditActivity;
import tbs.thinkbiz.solutions.itshades.CorpCustomer.SubmissionLink.LearnAndDevlp.OnDemndTrngActivity;
import tbs.thinkbiz.solutions.itshades.CorpCustomer.SubmissionLink.LearnAndDevlp.OnlnTrangActivity;
import tbs.thinkbiz.solutions.itshades.R;
import tbs.thinkbiz.solutions.itshades.Solutions.FilterAllActivity;

public class LnDFilterActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinerFA,spinerInd;
    String Actname,spInd,spFA,Edttext,CatId;
    TextView textname;
    EditText EdtSrch;
    Button btnSrch;

    private ArrayList<String> FocusArea =new ArrayList<String>();
     private ArrayList<String> idsfa = new ArrayList<String>();
    private ArrayList<String> Indst =new ArrayList<String>();
    private ArrayList<String> idsind = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ln_dfilter);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.backbar);
        View view =getSupportActionBar().getCustomView();

        SharedPreferences pref = this.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        Actname=pref.getString("Actvname","");
        CatId = pref.getString("CatId", "");

        textname=(TextView)findViewById(tbs.thinkbiz.solutions.itshades.R.id.textname);
        textname.setText("View "+Actname);

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

                    Intent intent=new Intent(LnDFilterActivity.this, OnlnTrangActivity.class);
                    startActivity(intent);
                }
                else if (CatId.equalsIgnoreCase("2"))
                {
                    String actname="Classroom Trainng";

                    SharedPreferences pref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                    SharedPreferences.Editor edit = pref.edit();

                    edit.putString("Actvname",actname);
                    edit.commit();

                    Intent intent=new Intent(LnDFilterActivity.this, ClassRmTrngActivity.class);
                    startActivity(intent);
                }

                else if (CatId.equalsIgnoreCase("3"))
                {
                    String actname="Certification";

                    SharedPreferences pref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                    SharedPreferences.Editor edit = pref.edit();

                    edit.putString("Actvname",actname);
                    edit.commit();

                    Intent intent=new Intent(LnDFilterActivity.this, CertifictinActivity.class);
                    startActivity(intent);
                }
                else if (CatId.equalsIgnoreCase("4"))
                {
                    String actname="On Demand Trainng";

                    SharedPreferences pref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                    SharedPreferences.Editor edit = pref.edit();

                    edit.putString("Actvname",actname);
                    edit.commit();

                    Intent intent=new Intent(LnDFilterActivity.this, OnDemndTrngActivity.class);
                    startActivity(intent);
                }
            }
        });


        spinerInd = (Spinner) findViewById(R.id.spinnerInd);
        spinerInd.setOnItemSelectedListener(this);
        getDataInd();

        spinerFA = (Spinner) findViewById(R.id.spinnerFA);
        spinerFA.setOnItemSelectedListener(this);
        getDataFA();

        btnSrch=(Button)findViewById(R.id.buttonSrch);
        btnSrch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EdtSrch=(EditText)findViewById(R.id.editTextsrch);
                Edttext=EdtSrch.getText().toString();
                String actname="Filtration";

                SharedPreferences pref = v.getContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = pref.edit();

                edit.putString("Actvname",actname);
                edit.putString("SPInd",spInd);
                edit.putString("SPFA",spFA);
                edit.putString("EditSearch",Edttext);

                edit.commit();
                Intent intent = new Intent(v.getContext(), LnDFiltrationActivity.class);
                startActivity(intent);

                Log.e("spind",spInd);
                Log.e("spfa",spFA);
//                Log.e("edts",Edttext);

            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        Spinner spinner = (Spinner) parent;

        if(spinner.getId() == R.id.spinnerInd)
        {
            spInd=idsind.get(position);
        }
        else if(spinner.getId() == R.id.spinnerFA)
        {
            spFA=idsfa.get(position);
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

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
                                String spInd1 = jsonObject1.getString("id");
                                String country=jsonObject1.getString("industry_name");
                                idsind.add(spInd1);
                                Indst.add(country);
                                //Log.e("spind",spInd1);
                            }

                            spinerInd.setAdapter(new ArrayAdapter<String>(LnDFilterActivity.this,R.layout.spinneritems, Indst));

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

    private void  getDataFA() {

        StringRequest stringRequest=new StringRequest(Request.Method.GET, AllUrls.FOCUS_AREA,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Log.e("rootJsonArray",response);
                        try{
                            JSONArray rootJsonArray = new JSONArray(response);

                            for(int i=0;i<rootJsonArray.length();i++){
                                JSONObject jsonObject1=rootJsonArray.getJSONObject(i);
                                String spFA1 =jsonObject1.getString("id");
                                String country=jsonObject1.getString("item_name");
                                idsfa.add(spFA1);
                                FocusArea.add(country);
                               // Log.e("spfa",spFA1);

                            }

                            spinerFA.setAdapter(new ArrayAdapter<String>(LnDFilterActivity.this, R.layout.spinneritems, FocusArea));

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
