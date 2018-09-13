package tbs.thinkbiz.solutions.itshades.CompnyDrctry;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
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
import tbs.thinkbiz.solutions.itshades.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class CmpProfFilterActivity extends AppCompatActivity {

    String Actname;
    TextView textname;
    private Spinner spinerFA,spinerInd,spinerOffrng,spinerCntry;

    private ArrayList<String> FocusArea =new ArrayList<String>();
    private ArrayList<String> Indst =new ArrayList<String>();
    //private ArrayList<String> Offrings =new ArrayList<String>();
    private ArrayList<String> Country =new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cmp_prof_filter);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.backbar);
        View view =getSupportActionBar().getCustomView();

        SharedPreferences pref = this.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        Actname=pref.getString("Actvname","");
        textname=(TextView)findViewById(R.id.textname);
        textname.setText(Actname);

        ImageButton imageButton= (ImageButton)view.findViewById(R.id.action_bar_back);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



        spinerCntry = (Spinner) findViewById(R.id.spinnerCntry);
        getDataCountry();

        spinerInd = (Spinner) findViewById(R.id.spinnerInd);
        getDataInd();

        spinerFA = (Spinner) findViewById(R.id.spinnerFA);
        getDataFA();

        spinerOffrng = (Spinner) findViewById(R.id.spinnerOffrings);
        //getDataOffrng();
        String[] users = new String[]{
                "IT Services",
                "IT Projects",
                "Platforms",
                "Applications",
                "Software",
                "Hardware",
                "Training",
                "Marketing",
                "Content Writing",
                "Recruitment",
                "Immigration",
                "Event"
        };

        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
                this, R.layout.spinneritems, users
        );
        spinnerArrayAdapter.setDropDownViewResource(R.layout.spinneritems);
        spinerOffrng.setAdapter(spinnerArrayAdapter);




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

                            spinerCntry.setAdapter(new ArrayAdapter<String>(CmpProfFilterActivity.this, R.layout.spinneritems, Country));

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
                                String country=jsonObject1.getString("industry_name");
                                Indst.add(country);
                            }

                            spinerInd.setAdapter(new ArrayAdapter<String>(CmpProfFilterActivity.this, R.layout.spinneritems, Indst));

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
                                String country=jsonObject1.getString("item_name");
                                FocusArea.add(country);
                            }

                            spinerFA.setAdapter(new ArrayAdapter<String>(CmpProfFilterActivity.this, R.layout.spinneritems, FocusArea));

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
