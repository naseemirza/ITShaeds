package tbs.thinkbiz.solutions.itshades.MainPageTab.ITJobsTabs;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
import tbs.thinkbiz.solutions.itshades.Events.OnlineEvent.OnlnEvntFilterationActivity;
import tbs.thinkbiz.solutions.itshades.Jobs.AsyncResult;
import tbs.thinkbiz.solutions.itshades.Jobs.CrntJobFilterActivity;
import tbs.thinkbiz.solutions.itshades.Jobs.CrntJobFilterationActivity;
import tbs.thinkbiz.solutions.itshades.Jobs.JobsActivity;
import tbs.thinkbiz.solutions.itshades.Jobs.JobsModelName;
import tbs.thinkbiz.solutions.itshades.Jobs.JobsNameAdapter;
import tbs.thinkbiz.solutions.itshades.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CurentOpngJobsFrag extends Fragment {

    private JobsNameAdapter mExampleAdapter1;
    private ArrayList<JobsModelName> mExampleList1;
    private RequestQueue mRequestQueue1;
    private RecyclerView mRecyclerview1;

    ProgressBar progressBar;
    FloatingActionButton floatingButton;

    Button applyBtn;
    static int isClicked=0;

    public CurentOpngJobsFrag() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.fragment_curent_opng_jobs, container, false);

        progressBar = (ProgressBar)rootView.findViewById(R.id.progressBar);
        floatingButton = (FloatingActionButton)rootView.findViewById(R.id.fab);
        floatingButton.setAlpha(0.50f);
        floatingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String details="Online Events";
                SharedPreferences pref = v.getContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = pref.edit();
                edit.putString("Actvname",details);
                edit.apply();
                Intent intent=new Intent(getActivity(),CrntJobFilterActivity.class);
                startActivity(intent);
            }
        });


        applyBtn =(Button)rootView.findViewById(R.id.applybutton);

        mExampleList1 = new ArrayList<>();
        mRequestQueue1 = Volley.newRequestQueue(getActivity());

        mRecyclerview1=(RecyclerView)rootView.findViewById(R.id.my_recycler_jobs);
        mRecyclerview1.setNestedScrollingEnabled(false);
        mRecyclerview1.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        mRecyclerview1.setHasFixedSize(true);

        parseJSON1();

        return rootView;
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

                            mExampleAdapter1 = new JobsNameAdapter(getActivity(), mExampleList1,asyncResult_addNewConnection);
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

        mRequestQueue1 = Volley.newRequestQueue(getActivity());
        mRequestQueue1.add(stringRequest);
    }


}
