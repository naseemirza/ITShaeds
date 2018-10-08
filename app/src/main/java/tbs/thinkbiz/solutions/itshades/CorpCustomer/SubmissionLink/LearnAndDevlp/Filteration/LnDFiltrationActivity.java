package tbs.thinkbiz.solutions.itshades.CorpCustomer.SubmissionLink.LearnAndDevlp.Filteration;

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

import tbs.thinkbiz.solutions.itshades.CorpCustomer.SubmissionLink.LearnAndDevlp.AddNewLnDActivity;
import tbs.thinkbiz.solutions.itshades.CorpCustomer.SubmissionLink.LearnAndDevlp.CertifictinActivity;
import tbs.thinkbiz.solutions.itshades.CorpCustomer.SubmissionLink.LearnAndDevlp.ClassRmTrngActivity;
import tbs.thinkbiz.solutions.itshades.CorpCustomer.SubmissionLink.LearnAndDevlp.LearngAndDevActivity;
import tbs.thinkbiz.solutions.itshades.CorpCustomer.SubmissionLink.LearnAndDevlp.ListAdapterB;
import tbs.thinkbiz.solutions.itshades.CorpCustomer.SubmissionLink.LearnAndDevlp.ListModelB;
import tbs.thinkbiz.solutions.itshades.CorpCustomer.SubmissionLink.LearnAndDevlp.LnDCorpEditActivity;
import tbs.thinkbiz.solutions.itshades.CorpCustomer.SubmissionLink.LearnAndDevlp.OnDemndTrngActivity;
import tbs.thinkbiz.solutions.itshades.CorpCustomer.SubmissionLink.LearnAndDevlp.OnlnTrangActivity;
import tbs.thinkbiz.solutions.itshades.R;

public class LnDFiltrationActivity extends AppCompatActivity {

    String Actname,SpInd,SpFA,EdtSrch;
    TextView textname;
    String uid, CatId;
    Button addonlntrng;

    //Table Data

    private LnDFiltrAdapter mExampleAdapter;
    private ArrayList<LnDFiltrModel> mExampleList;
    private RequestQueue mRequestQueue;
    private RecyclerView mRecyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ln_dfiltration);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.backbar);
        View view = getSupportActionBar().getCustomView();

        SharedPreferences pref = this.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);


        Actname = pref.getString("Actvname", "");
        uid = pref.getString("userid", "");
        CatId = pref.getString("CatId", "");

        SpInd = pref.getString("SPInd", "");
        SpFA = pref.getString("SPFA", "");
        EdtSrch = pref.getString("EditSearch", "");

        Log.e("rootJsonArray",SpInd);
        Log.e("rootJsonArray1",SpFA);

        textname = (TextView) findViewById(R.id.textname);
        textname.setText(Actname);

        ImageButton imageButton = (ImageButton) view.findViewById(R.id.action_bar_back);
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

                    Intent intent=new Intent(LnDFiltrationActivity.this, LnDFilterActivity.class);
                    startActivity(intent);
                }
                else if (CatId.equalsIgnoreCase("2"))
                {
                    String actname="Classroom Trainng";

                    SharedPreferences pref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                    SharedPreferences.Editor edit = pref.edit();

                    edit.putString("Actvname",actname);
                    edit.commit();

                    Intent intent=new Intent(LnDFiltrationActivity.this, LnDFilterActivity.class);
                    startActivity(intent);
                }

                else if (CatId.equalsIgnoreCase("3"))
                {
                    String actname="Certification";

                    SharedPreferences pref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                    SharedPreferences.Editor edit = pref.edit();

                    edit.putString("Actvname",actname);
                    edit.commit();

                    Intent intent=new Intent(LnDFiltrationActivity.this, LnDFilterActivity.class);
                    startActivity(intent);
                }
                else if (CatId.equalsIgnoreCase("4"))
                {
                    String actname="On Demand Trainng";

                    SharedPreferences pref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                    SharedPreferences.Editor edit = pref.edit();

                    edit.putString("Actvname",actname);
                    edit.commit();

                    Intent intent=new Intent(LnDFiltrationActivity.this, LnDFilterActivity.class);
                    startActivity(intent);
                }
            }
        });

        //TableData

        mExampleList = new ArrayList<>();
        mRequestQueue = Volley.newRequestQueue(this);

        mRecyclerview = (RecyclerView) findViewById(R.id.my_recycler_jobs1);
        mRecyclerview.setNestedScrollingEnabled(false);
        mRecyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerview.setHasFixedSize(true);

        parseJSON();
    }

    private void parseJSON() {

        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);

        //String Tab_Url=" https://www.itshades.com/appdata/emp-onlinetraining.php?cat_id=1&uid=329&industry=&item=&title_search=";

      String Tab_Url="https://www.itshades.com/appdata/emp-onlinetraining.php?cat_id="+CatId+"&uid="+uid+"&industry="+SpInd+"&item="+SpFA+"&title_search="+EdtSrch;

        Log.e("rootJsonArray",Tab_Url);

        StringRequest stringRequest = new StringRequest(Request.Method.GET,Tab_Url,
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

                                mExampleList.add(new LnDFiltrModel(object.optString("id"),
                                        object.optString("title_name"),
                                        object.optString("industry_relevance"),
                                        object.optString("focus_area"),
                                        object.optString("user_price_per_unit"),
                                        object.optString("added_date"),
                                        object.optString("status"),
                                        object.optString("editdata")));

                            }

                            Log.e("rootJsonArray",mExampleList.size()+"");

                            mExampleAdapter = new LnDFiltrAdapter(LnDFiltrationActivity.this, mExampleList);
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

        mRequestQueue = Volley.newRequestQueue(this);
        mRequestQueue.add(stringRequest);
    }

    @Override
    public void onBackPressed() {

        finish();

    }
}
