package com.example.user.itshaeds.Jobs;

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
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.user.itshaeds.PrevayActivity;
import com.example.user.itshaeds.R;
import com.example.user.itshaeds.TermsActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DetailsActivity extends AppCompatActivity {

    TextView discla,termsndcond,prvynspolcy;

    private DetailsAdapter mExampleAdapter;
    private ArrayList<DetailsModel> mExampleList;
    private RequestQueue mRequestQueue;
    private RecyclerView mRecyclerview;
    String Jid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.jobdetailsbar);
        View view =getSupportActionBar().getCustomView();

        ImageButton imageButton= (ImageButton)view.findViewById(R.id.action_bar_back);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        SharedPreferences pref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        Jid = pref.getString("JobID", "");


        discla=(TextView)findViewById(R.id.textdesc);
        termsndcond=(TextView)findViewById(R.id.texttnc);
        prvynspolcy=(TextView)findViewById(R.id.textpnp);

        mExampleList = new ArrayList<>();
        mRequestQueue = Volley.newRequestQueue(DetailsActivity.this);

        mRecyclerview = (RecyclerView)findViewById(R.id.my_recycler_jobs);
        mRecyclerview.setNestedScrollingEnabled(false);
        mRecyclerview.setLayoutManager(new LinearLayoutManager(DetailsActivity.this, LinearLayoutManager.VERTICAL, false));
        mRecyclerview.setHasFixedSize(true);
        parseJSON();

//        discla.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(Main2Activity.this,DisclaierActivity.class));
//            }
//        });

//        termsndcond.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(DetailsActivity.this,TermsActivity.class));
//            }
//        });

//        prvynspolcy.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(DetailsActivity.this,PrevayActivity.class));
//            }
//        });
//

//        SharedPreferences pref = this.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
//
//        textpost=pref.getString("Title","");
//        textexp=pref.getString("Exp","");
//       // textloc=pref.getString("Loc","");
//
//
//        textViewpost.setText(textpost);
//        textViewexp.setText(textexp);
        //textViewloc.setText(textloc);
    }

    private void parseJSON() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, "https://www.itshades.com/appwebservices/job-search-single.php?id="+Jid,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject rootJsonObject = new JSONObject(response);
                            JSONArray subCategoryArray = rootJsonObject.getJSONArray("jobdetailbyid");
                            Log.e("subCategoryArray", subCategoryArray.length() + "");

                            for (int i = 0; i < subCategoryArray.length(); i++) {
                                JSONObject object = subCategoryArray.getJSONObject(i);

                                mExampleList.add(new DetailsModel(object.optString("id"),
                                        object.optString("job_title"),
                                        object.optString("expirence"),
                                        object.optString("country"),
                                        object.optString("work_city"),
                                        object.optString("company_name"),
                                        object.optString("job_keyskill"),
                                        object.optString("job_description"),
                                        object.optString("job_postion")));
                            }

                            Log.e("rootJsonArray",mExampleList.size()+"");

                            mExampleAdapter = new DetailsAdapter(DetailsActivity.this, mExampleList);
                            mRecyclerview.setAdapter(mExampleAdapter);
                            mExampleAdapter.notifyDataSetChanged();
                            mRecyclerview.setHasFixedSize(true);

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

        mRequestQueue = Volley.newRequestQueue(DetailsActivity.this);
        mRequestQueue.add(stringRequest);
    }
}
