package tbs.thinkbiz.solutions.itshades.ITByteDetailsRecy;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import tbs.thinkbiz.solutions.itshades.ITBytes.ITbytdetailsAdapter;
import tbs.thinkbiz.solutions.itshades.ITBytes.ITbytdetalsmodel;
import tbs.thinkbiz.solutions.itshades.PrevayActivity;
import tbs.thinkbiz.solutions.itshades.R;
import tbs.thinkbiz.solutions.itshades.TermsActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MarktAndEventsActivity extends AppCompatActivity {

    private ITbytdetailsAdapter mExampleAdapter1;
    private ArrayList<ITbytdetalsmodel> mExampleList1;
    private RequestQueue mRequestQueue1;
    private RecyclerView mRecyclerview1;

    String Actname;
    TextView textname;
    String year,month_edition , pos;
    TextView discla,termsndcond,prvynspolcy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_markt_and_events);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.backbar);
        View view =getSupportActionBar().getCustomView();

        SharedPreferences pref = this.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        year=pref.getString("year","");
        month_edition=pref.getString("month_edition","");
        pos=pref.getString("position","");

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

        discla=(TextView)findViewById(tbs.thinkbiz.solutions.itshades.R.id.textdesc);
        termsndcond=(TextView)findViewById(tbs.thinkbiz.solutions.itshades.R.id.texttnc);
        prvynspolcy=(TextView)findViewById(tbs.thinkbiz.solutions.itshades.R.id.textpnp);

//        discla.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(ITBytDetailsActivity.this,Disc.class));
//            }
//        });

        termsndcond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MarktAndEventsActivity.this,TermsActivity.class));
            }
        });

        prvynspolcy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MarktAndEventsActivity.this,PrevayActivity.class));
            }
        });


        // Jobs Title names

        mExampleList1 = new ArrayList<>();
        mRequestQueue1 = Volley.newRequestQueue(this);

        mRecyclerview1=(RecyclerView)findViewById(R.id.my_recycler_jobs);
        mRecyclerview1.setNestedScrollingEnabled(false);
        mRecyclerview1.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        mRecyclerview1.setHasFixedSize(true);

        parseJSON1();

    }
    private void parseJSON1() {

        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);

        String rurl ="https://www.itshades.com/appwebservices/industry-update.php?year=2018&month_edition=Previous&catid="+pos+"";
       // String rurl = "https://www.itshades.com/appwebservices/industry-update.php?year="+year+"&month_edition="+month_edition+"&catid="+pos+"";
        // Log.e("Url",rurl);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, rurl,
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

                                mExampleList1.add(new ITbytdetalsmodel(object.optString("id"),
                                        object.optString("news_title"),
                                        object.optString("description")));

                            }

                            Log.e("rootJsonArray",mExampleList1.size()+"");

                            mExampleAdapter1 = new ITbytdetailsAdapter(MarktAndEventsActivity.this, mExampleList1);
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



