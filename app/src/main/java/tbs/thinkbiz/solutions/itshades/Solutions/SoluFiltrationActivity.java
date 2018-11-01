package tbs.thinkbiz.solutions.itshades.Solutions;

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
import tbs.thinkbiz.solutions.itshades.Artifacts.ArtfacFilterActivity;
import tbs.thinkbiz.solutions.itshades.Artifacts.ArtfacFiltrationActivity;
import tbs.thinkbiz.solutions.itshades.R;

public class SoluFiltrationActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinerFA,spinerInd;
    String Actname;
    TextView textname;
    Button btnsrch;
    String IndR,FA,Edttext;
    EditText EdtSrch;

    private ArrayList<String> Indst =new ArrayList<String>();
    private ArrayList<String> Indstid =new ArrayList<String>();
    private ArrayList<String> FocusArea =new ArrayList<String>();
    private ArrayList<String> FocusAreaid =new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solu_filtration);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(tbs.thinkbiz.solutions.itshades.R.layout.backbar);
        View view =getSupportActionBar().getCustomView();

        SharedPreferences pref = this.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        Actname=pref.getString("Actvname","");


        textname=(TextView)findViewById(tbs.thinkbiz.solutions.itshades.R.id.textname);
        textname.setText("View "+Actname);

        ImageButton imageButton= (ImageButton)view.findViewById(tbs.thinkbiz.solutions.itshades.R.id.action_bar_back);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        spinerInd = (Spinner) findViewById(R.id.spinnerInd);
        spinerInd.setOnItemSelectedListener(this);
        getDataInd();

        spinerFA = (Spinner) findViewById(R.id.spinnerFA);
        spinerFA.setOnItemSelectedListener(this);
        getDataFA();

        btnsrch=(Button)findViewById(R.id.btnjobsrch);
        btnsrch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //yrExp1=spinerExp.getTx
                EdtSrch=(EditText)findViewById(R.id.editTextsrch);
                Edttext=EdtSrch.getText().toString();

                SharedPreferences pref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = pref.edit();
                edit.putString("INDR",IndR);
                edit.putString("FA",FA);
                edit.putString("EditSearch",Edttext);
                edit.apply();

                Intent intent=new Intent(SoluFiltrationActivity.this, SoluFilterActivity.class);
                startActivity(intent);

                Log.e("rootJsonArray",IndR);
                Log.e("rootJsonArray",FA);
            }
        });


    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        Spinner spinner = (Spinner) parent;

        if(spinner.getId() == R.id.spinnerInd)
        {
            IndR=Indstid.get((int) id);
        }

        else if(spinner.getId() == R.id.spinnerFA)
        {
            FA=FocusAreaid.get((int) id);
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
                                String Indid=jsonObject1.getString("id");
                                String country=jsonObject1.getString("industry_name");
                                Indstid.add(Indid);
                                Indst.add(country);
                            }

                            spinerInd.setAdapter(new ArrayAdapter<String>(SoluFiltrationActivity.this, R.layout.spinneritems, Indst));

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
                                String faid=jsonObject1.getString("id");
                                String country=jsonObject1.getString("item_name");
                                FocusAreaid.add(faid);
                                FocusArea.add(country);

                            }

                            spinerFA.setAdapter(new ArrayAdapter<String>(SoluFiltrationActivity.this,R.layout.spinneritems, FocusArea));

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
