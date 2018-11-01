package tbs.thinkbiz.solutions.itshades.Jobs;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
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
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import tbs.thinkbiz.solutions.itshades.AllUrls;
import tbs.thinkbiz.solutions.itshades.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class CurrentJobActivity extends AppCompatActivity {

    private JobsNameAdapter mExampleAdapter1;
    private ArrayList<JobsModelName> mExampleList1;
    private RequestQueue mRequestQueue1;
    private RecyclerView mRecyclerview1;

    String Actname;
    TextView textname;
    String jobid,uid;

    Button applyBtn;
    static int isClicked=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_job);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.backandfilterbar);
        View view =getSupportActionBar().getCustomView();

        SharedPreferences pref = this.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        Actname=pref.getString("Actvname","");
        jobid = pref.getString("ID", "");
        uid = pref.getString("UserId", "");
        textname=(TextView)findViewById(R.id.textname);
        textname.setText(Actname);

        ImageButton imageButton= (ImageButton)view.findViewById(R.id.action_bar_back);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ImageButton imageButton2= (ImageButton)view.findViewById(R.id.action_bar_forward);

        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String actname ="Current Job Filter";
                SharedPreferences pref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = pref.edit();

                edit.putString("Actvname",actname);

                edit.commit();
                Intent intent = new Intent(CurrentJobActivity.this, CrntJobFilterActivity.class);
                startActivity(intent);

            }
        });

        applyBtn =(Button)findViewById(R.id.applybutton);
        applyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //JobApply();
            }
        });

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

    private void JobApply() {

        StringRequest stringRequest = new StringRequest(Request.Method.POST,"https://www.itshades.com/appwebservices/job-apply.php?uid="+uid+"&job_id="+jobid,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("resp",response);
                        //progressDialog.dismiss();
                        try {
                            JSONObject obj = new JSONObject(response);
                            String success= obj.getString("s");
                            String error= obj.getString("e");
                            String msg=obj.getString("m");

                            if (success.equalsIgnoreCase("1")) {

                                Toast.makeText(CurrentJobActivity.this, msg, Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Toast.makeText(CurrentJobActivity.this, msg, Toast.LENGTH_SHORT).show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(CurrentJobActivity.this,e.getMessage(), Toast.LENGTH_SHORT).show();
                            //progressDialog.dismiss();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(CurrentJobActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                        // progressDialog.dismiss();
                    }
                })
        {
        };

        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

    private void parseJSON1() {

        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, AllUrls.JOBS_URL,
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

                            mExampleAdapter1 = new JobsNameAdapter(CurrentJobActivity.this, mExampleList1,asyncResult_addNewConnection);
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
