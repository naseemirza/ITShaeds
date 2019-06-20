package tbs.thinkbiz.solutions.itshades.ITBytes;

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
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import tbs.thinkbiz.solutions.itshades.Jobs.ModelJobs;
import tbs.thinkbiz.solutions.itshades.PrevayActivity;
import tbs.thinkbiz.solutions.itshades.R;
import tbs.thinkbiz.solutions.itshades.TermsActivity;



import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class ITBytDetailsActivity extends AppCompatActivity {

    List<ITbytdetalsmodel> productList1;

    List<ModelJobs> productList;
    RecyclerView recyclerView,recyclerViewtitle;
    //CheckBox checkBox;
    TextView discla,termsndcond,prvynspolcy;

    private ITbytdetailsAdapter11 mExampleAdapter1;
    private ArrayList<ITbytdetalsmodel> mExampleList1;
    private RequestQueue mRequestQueue1;
    private RecyclerView mRecyclerview1;

    ImageView imageViewadd,imageViewminus;

    String actvtyname,acttyname1;
    String yeard,month_edition , pos,url;

    TextView textname;
    TextView jsonotfound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itbyt_details);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(tbs.thinkbiz.solutions.itshades.R.layout.backbar);
        View view =getSupportActionBar().getCustomView();

        SharedPreferences pref = this.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        url=pref.getString("url","");
        month_edition=pref.getString("monthedi","");

        yeard=pref.getString("yeardisp","");
        pos=pref.getString("position","");

        textname=(TextView)findViewById(R.id.textname);
        textname.setText(yeard);


      ///  month_edition=pref.getString("month_edition","");


       // Log.e("yr",month_edition);


//        activitynametext=(TextView)findViewById(R.id.actname);
//        SharedPreferences pref = this.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
//
//        actvtyname=pref.getString("Month","");
//        acttyname1=pref.getString("Edition","");
//
//        activitynametext.setText(actvtyname+" "+acttyname1);
        jsonotfound=(TextView)findViewById(R.id.jsondata);

        ImageButton imageButton= (ImageButton)view.findViewById(tbs.thinkbiz.solutions.itshades.R.id.action_bar_back);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        discla=(TextView)findViewById(R.id.textdesc);
        termsndcond=(TextView)findViewById(R.id.texttnc);
        prvynspolcy=(TextView)findViewById(R.id.textpnp);

//        discla.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(ITBytDetailsActivity.this,Disc.class));
//            }
//        });

        termsndcond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ITBytDetailsActivity.this,TermsActivity.class));
            }
        });

        prvynspolcy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ITBytDetailsActivity.this,PrevayActivity.class));
            }
        });

        //category name with icon

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        productList = new ArrayList<>();

        productList.add(new ModelJobs("Financial", R.drawable.financial));
        productList.add(new ModelJobs("IT Solutions", R.drawable.solutions));
        productList.add(new ModelJobs("Reward & Ricognition", R.drawable.reward));
        productList.add(new ModelJobs("Customer Success", R.drawable.customer_reviews));
        productList.add(new ModelJobs("Marketing & Events", R.drawable.marketing));
        productList.add(new ModelJobs("M & A Partnership", R.drawable.partnership));
        productList.add(new ModelJobs("Miscellaneous", R.drawable.misclenious));
        productList.add(new ModelJobs("Announcements", R.drawable.anouncment));

        ITBytRecycAdapter adapter = new ITBytRecycAdapter(this, productList);
        recyclerView.setAdapter(adapter);

        imageViewadd=(ImageView)findViewById(R.id.imgadd);
        imageViewminus=(ImageView)findViewById(R.id.imgminus);


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

       // String url="https://www.itshades.com/appwebservices/industry-update.php?year="+year+"&catid="+pos;
       // String url= "https://www.itshades.com/appwebservices/industry-update.php?year=2018"+"&month_edition="+month_edition+"&catid="+pos;
       // String rurl = "https://www.itshades.com/appwebservices/industry-update.php?year="+year+"&month_edition="+month_edition+"&catid="+pos+"";
        // Log.e("Url",rurl);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        progressBar.setVisibility(View.INVISIBLE);

                        if (response!=null) {

                            try {
                                Log.e("rootJsonArray", response);
                                JSONArray rootJsonArray = new JSONArray(response);

                                Log.e("rootJsonArrayLength", rootJsonArray.length() + "");

                                if (rootJsonArray.length()==0)
                                {
                                    jsonotfound.setVisibility(View.VISIBLE);
                                }

                                for (int i = 0; i < rootJsonArray.length(); i++) {
                                    JSONObject object = rootJsonArray.getJSONObject(i);

                                    mExampleList1.add(new ITbytdetalsmodel(object.optString("id"),
                                            object.optString("news_title"),
                                            object.optString("description")));

                                }

                                Log.e("rootJsonArray", mExampleList1.size() + "");

                                mExampleAdapter1 = new ITbytdetailsAdapter11(ITBytDetailsActivity.this, mExampleList1);
                                mRecyclerview1.setAdapter(mExampleAdapter1);
                                mExampleAdapter1.notifyDataSetChanged();
                                mRecyclerview1.setHasFixedSize(true);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                        else {
                            Toast.makeText(ITBytDetailsActivity.this,"There is No Data to show",Toast.LENGTH_LONG).show();
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
