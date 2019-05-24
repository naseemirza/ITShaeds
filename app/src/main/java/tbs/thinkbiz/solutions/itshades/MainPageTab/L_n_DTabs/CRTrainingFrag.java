package tbs.thinkbiz.solutions.itshades.MainPageTab.L_n_DTabs;


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
import tbs.thinkbiz.solutions.itshades.LearningAndDevelopment.LnDAdapter;
import tbs.thinkbiz.solutions.itshades.LearningAndDevelopment.LnDModel;
import tbs.thinkbiz.solutions.itshades.LearningAndDevelopment.LndFilterationActivity;
import tbs.thinkbiz.solutions.itshades.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CRTrainingFrag extends Fragment {

    String uid;
    String CatId="2";
    private LnDAdapter mExampleAdapter1;
    private ArrayList<LnDModel> mExampleList1;
    private RequestQueue mRequestQueue1;
    private RecyclerView mRecyclerview1;
    ProgressBar progressBar;
    FloatingActionButton floatingButton;
    TextView jsonotfound;

    public CRTrainingFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.fragment_crtraining, container, false);

        SharedPreferences pref = getActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        // CatId=pref.getString("CatId","");
        uid = pref.getString("userId", "");


        progressBar = (ProgressBar)rootView.findViewById(R.id.progressBar);
        jsonotfound=(TextView)rootView.findViewById(R.id.jsondata);

        floatingButton = (FloatingActionButton)rootView.findViewById(R.id.fab);
        floatingButton.setAlpha(0.50f);
        floatingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String CatId="2";
                String details="Classroom Training";
                SharedPreferences pref = v.getContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = pref.edit();
                edit.putString("Actvname",details);
                edit.putString("CatId",CatId);
                edit.apply();
                Intent intent=new Intent(getActivity(),LndFilterationActivity.class);
                startActivity(intent);
            }
        });

        mExampleList1 = new ArrayList<>();
        mRequestQueue1 = Volley.newRequestQueue(getActivity());

        mRecyclerview1=(RecyclerView)rootView.findViewById(R.id.my_recycler_jobs);
        mRecyclerview1.setNestedScrollingEnabled(false);
        mRecyclerview1.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        mRecyclerview1.setHasFixedSize(true);

        parseJSON1();

        return rootView;
    }

    private void parseJSON1() {
        progressBar.setVisibility(View.VISIBLE);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, AllUrls.L_AND_D+CatId+"&uid="+uid,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        progressBar.setVisibility(View.INVISIBLE);

                        try {
                            Log.e("rootJsonArray",response);
                            JSONArray rootJsonArray = new JSONArray(response);

                            Log.e("rootJsonArrayLength",rootJsonArray.length()+"");
                            if (rootJsonArray.length()==0)
                            {
                                jsonotfound.setVisibility(View.VISIBLE);
                            }

                            for (int i = 0; i < rootJsonArray.length(); i++) {
                                JSONObject object = rootJsonArray.getJSONObject(i);

                                mExampleList1.add(new LnDModel(object.optString("id"),
                                        object.optString("title_name"),
                                        object.optString("breif_desc"),
                                        object.optString("industry_relevance"),
                                        object.optString("focus_area"),
                                        object.optString("added_by"),
                                        object.optString("sourse_url")));

                            }

                            Log.e("rootJsonArray",mExampleList1.size()+"");

                            mExampleAdapter1 = new LnDAdapter(getActivity(), mExampleList1);
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
