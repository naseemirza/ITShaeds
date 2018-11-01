package tbs.thinkbiz.solutions.itshades.Jobs;

import android.content.Context;
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

import tbs.thinkbiz.solutions.itshades.AllUrls;
import tbs.thinkbiz.solutions.itshades.R;

public class CrntJobFilterationActivity extends AppCompatActivity {

    String Actname;
    TextView textname;
    //String uid;
    ImageButton imageButton;
    String FExp,IndR,yrExp,Contry,Rllvl,Edttext;

    private JobsNameAdapter mExampleAdapter1;
    private ArrayList<JobsModelName> mExampleList1;
    private RequestQueue mRequestQueue1;
    private RecyclerView mRecyclerview1;

    Button applyBtn;
    static int isClicked=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crnt_job_filteration);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.backbar);
        View view =getSupportActionBar().getCustomView();

        SharedPreferences pref = this.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        Actname=pref.getString("Actvname","");
        FExp = pref.getString("FE", "");
        IndR = pref.getString("INDR", "");
        yrExp = pref.getString("YREXP", "");
        Contry = pref.getString("CONYRY", "");
        Rllvl = pref.getString("ROLLVL", "");
        Edttext = pref.getString("EditSearch", "");
       // uid=pref.getString("userid","");
       // Log.e("rootJsonArray",uid);

//                Log.e("fexp",FExp);
//                Log.e("indr",IndR);
                Log.e("yrexp",yrExp);
//                Log.e("cntry",Contry);
//                Log.e("rlvl",Rllvl);
//                Log.e("edt",Edttext);

        textname=(TextView)findViewById(R.id.textname);

        textname.setText(Actname);
        imageButton=(ImageButton)findViewById(R.id.action_bar_back);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        applyBtn =(Button)findViewById(R.id.applybutton);

        mExampleList1 = new ArrayList<>();
        mRequestQueue1 = Volley.newRequestQueue(this);

        mRecyclerview1=(RecyclerView)findViewById(R.id.my_recycler_jobs);
        mRecyclerview1.setNestedScrollingEnabled(false);
        mRecyclerview1.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        mRecyclerview1.setHasFixedSize(true);

        parseJSON1();
    }
    AsyncResult<Integer> asyncResult_addNewConnection = new AsyncResult<Integer>() {
        @Override
        public void success(Integer click) {
            isClicked= isClicked+click;
            if(isClicked>0){
                applyBtn.setVisibility(View.VISIBLE);
            }else{
                applyBtn.setVisibility(View.GONE);
            }
        }

        @Override
        public void error(String error) {

        }
    };

    private void parseJSON1() {

        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);

        //AllUrls.JOBS_URL+"&cmp="+FExp+"&industry="+IndR+"&expirenceyear="+yrExp+
       // "&country="+Contry+"&explevel="+Rllvl+"&title_search="+Edttext,

        String jobUrl=AllUrls.JOBS_URL+"cmp="+FExp+"&industry="+IndR+"&expirenceyear="+yrExp+
                "&country="+Contry+"&explevel="+Rllvl+"&title_search="+Edttext;

        Log.e("rootJsonArray",jobUrl);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, jobUrl,
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

                                mExampleList1.add(new JobsModelName(object.optString("id"),
                                        object.optString("user_id"),
                                        object.optString("job_title"),
                                        object.optString("expirence"),
                                        object.optString("country"),
                                        object.optString("work_city"),
                                        object.optString("company_name"),
                                        object.optString("job_keyskill"),
                                        object.optString("job_description"),
                                        object.optString("job_postion")));
                            }

                            Log.e("rootJsonArray",mExampleList1.size()+"");

                            mExampleAdapter1 = new JobsNameAdapter(CrntJobFilterationActivity.this, mExampleList1,asyncResult_addNewConnection);
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
