package tbs.thinkbiz.solutions.itshades.Solutions;

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

public class FilterAllActivity extends AppCompatActivity {

    private Spinner spinerFA,spinerInd;
    String Actname,filter;
    TextView textname,filtext;

    private ArrayList<String> FocusArea =new ArrayList<String>();
    private ArrayList<String> Indst =new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter_all);

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

        spinerInd = (Spinner) findViewById(tbs.thinkbiz.solutions.itshades.R.id.spinnerInd);
        getDataInd();

        spinerFA = (Spinner) findViewById(tbs.thinkbiz.solutions.itshades.R.id.spinnerFA);
        getDataFA();

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

                            spinerInd.setAdapter(new ArrayAdapter<String>(FilterAllActivity.this, tbs.thinkbiz.solutions.itshades.R.layout.spinneritems, Indst));

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

                            spinerFA.setAdapter(new ArrayAdapter<String>(FilterAllActivity.this, tbs.thinkbiz.solutions.itshades.R.layout.spinneritems, FocusArea));

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
