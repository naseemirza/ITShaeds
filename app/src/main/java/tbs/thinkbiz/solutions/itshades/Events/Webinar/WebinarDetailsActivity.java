package tbs.thinkbiz.solutions.itshades.Events.Webinar;

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

import tbs.thinkbiz.solutions.itshades.LearningAndDevelopment.ContactForm;
import tbs.thinkbiz.solutions.itshades.LearningAndDevelopment.LnDRltdAdapter;
import tbs.thinkbiz.solutions.itshades.LearningAndDevelopment.LnDRltdModel;
import tbs.thinkbiz.solutions.itshades.LearningAndDevelopment.TableAdapter;
import tbs.thinkbiz.solutions.itshades.LearningAndDevelopment.TableModel;
import tbs.thinkbiz.solutions.itshades.R;

public class WebinarDetailsActivity extends AppCompatActivity {

    String Actname;
    TextView textname;

    //Table Data

    private TableAdapter mExampleAdapter;
    private ArrayList<TableModel> mExampleList;
    private RequestQueue mRequestQueue;
    private RecyclerView mRecyclerview;

    TextView textViewTitle;
    TextView indstry;
    TextView focus;
    TextView desc;
    TextView desc1;

    String title, indst, fcsar, des;
    String id, CatId;

    Button Contactbtn;
    TextView Clicktext;

    //Related Data

    private LnDRltdAdapter mExampleAdapter1;
    private ArrayList<LnDRltdModel> mExampleList1;
    private RequestQueue mRequestQueue1;
    private RecyclerView mRecyclerview1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webinar_details);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.backbar);
        View view = getSupportActionBar().getCustomView();

        SharedPreferences pref = this.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);


        Actname = pref.getString("Actvname", "");
        id = pref.getString("Id", "");
        CatId = pref.getString("CatId", "");


        textname = (TextView) findViewById(R.id.textname);
        textname.setText(Actname + " Detail");

        ImageButton imageButton = (ImageButton) view.findViewById(R.id.action_bar_back);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        textViewTitle = (TextView) findViewById(R.id.textvpost);
        indstry = (TextView) findViewById(R.id.indrel);
        focus = (TextView) findViewById(R.id.fcsar1);
        desc = (TextView) findViewById(R.id.desc);
        desc1 = (TextView) findViewById(R.id.desc1);

        title = pref.getString("Title", "");
        indst = pref.getString("Inds", "");
        fcsar = pref.getString("Focus", "");
        des = pref.getString("DESC", "");

        textViewTitle.setText(title);
        indstry.setText(indst);
        focus.setText(fcsar);
        desc.setText(des);
        desc1.setText(des);

        Contactbtn = (Button) findViewById(R.id.buttonContact);

        Contactbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = pref.edit();
                String actname = "Contact Corporate";

                edit.putString("Actvname", actname);

                edit.commit();

                Intent intent = new Intent(WebinarDetailsActivity.this, ContactForm.class);
                startActivity(intent);
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


        //Related

        mExampleList1 = new ArrayList<>();
        mRequestQueue1 = Volley.newRequestQueue(this);

        mRecyclerview1 = (RecyclerView) findViewById(R.id.my_recycler_jobs);
        mRecyclerview1.setNestedScrollingEnabled(false);
        mRecyclerview1.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerview1.setHasFixedSize(true);
        parseJSON1();

    }


    //Related

    private void parseJSON1() {

        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);

        String url = "https://www.itshades.com/appwebservices/webinar-related.php?id="+id;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        progressBar.setVisibility(View.INVISIBLE);

                        try {
                            Log.e("rootJsonArray", response);
                            JSONArray rootJsonArray = new JSONArray(response);


                            Log.e("rootJsonArrayLength", rootJsonArray.length() + "");

                            for (int i = 0; i < rootJsonArray.length(); i++) {
                                JSONObject object = rootJsonArray.getJSONObject(i);

                                mExampleList1.add(new LnDRltdModel(object.optString("id"),
                                        object.optString("title_name"),
                                        object.optString("breif_desc"),
                                        object.optString("industry_relevance"),
                                        object.optString("focus_area"),
                                        object.optString("telecon_bridge"),
                                        object.optString("posted_by")));

                            }

                            Log.e("rootJsonArray", mExampleList1.size() + "");

                            mExampleAdapter1 = new LnDRltdAdapter(WebinarDetailsActivity.this, mExampleList1);
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
                        Log.e("TAg", error.getMessage());
                    }
                });

        mRequestQueue1 = Volley.newRequestQueue(this);
        mRequestQueue1.add(stringRequest);
    }


    //TableData

    private void parseJSON() {

        final ProgressBar progressBar1 = (ProgressBar) findViewById(R.id.progressBar1);
        progressBar1.setVisibility(View.VISIBLE);

        String Tab_Url = "https://www.itshades.com/appwebservices/webinar-detail.php?id="+id;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, Tab_Url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        progressBar1.setVisibility(View.INVISIBLE);

                        try {
                            Log.e("rootJsonArray", response);
                            JSONArray rootJsonArray = new JSONArray(response);


                            Log.e("rootJsonArrayLength", rootJsonArray.length() + "");

                            for (int i = 0; i < rootJsonArray.length(); i++) {
                                JSONObject object = rootJsonArray.getJSONObject(i);


                                mExampleList.add(new TableModel(object.optString("id"),
                                        object.optString("srnu"),
                                        object.optString("address"),
                                        object.optString("country"),
                                        object.optString("telecon_bridge"),
                                        object.optString("city"),
                                        object.optString("user_price_per_unit"),
                                        object.optString("reg_link"),
                                        object.optString("posted_by"),
                                        object.optString("added_date"),
                                        object.optString("expiry_date"),
                                        object.optString("sourse_url")));

                            }

                            Log.e("rootJsonArray", mExampleList.size() + "");

                            mExampleAdapter = new TableAdapter(WebinarDetailsActivity.this, mExampleList);
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
                        Log.e("TAg", error.getMessage());
                    }
                });

        mRequestQueue = Volley.newRequestQueue(this);
        mRequestQueue.add(stringRequest);
    }

}
