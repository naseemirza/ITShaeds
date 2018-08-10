package com.example.user.itshaeds.ITBytes;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.user.itshaeds.Jobs.JobsModelName;
import com.example.user.itshaeds.Jobs.JobsNameAdapter;
import com.example.user.itshaeds.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ITBytesActivity extends AppCompatActivity {

    private ITBytesAdapter mExampleAdapter;
    private ArrayList<ITBytesModel> mExampleList;
    private RequestQueue mRequestQueue;
    private RecyclerView sRecyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itbytes);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.itbytesbar);
        View view =getSupportActionBar().getCustomView();

        ImageButton imageButton= (ImageButton)view.findViewById(R.id.action_bar_back);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        mExampleList = new ArrayList<>();
        mRequestQueue = Volley.newRequestQueue(this);
        sRecyclerview=(RecyclerView)findViewById(R.id.my_recycler_jobs);
        sRecyclerview.setNestedScrollingEnabled(false);
        sRecyclerview.setLayoutManager(new GridLayoutManager(this,2));
        sRecyclerview.setHasFixedSize(true);

        parseJSON();

    }
    private void parseJSON() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, "https://www.itshades.com/appwebservices/it-bytes.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            Log.e("rootJsonArray",response);
                            JSONArray rootJsonArray = new JSONArray(response);

                            Log.e("rootJsonArrayLength",rootJsonArray.length()+"");

                            for (int i = 0; i < rootJsonArray.length(); i++) {
                                JSONObject object = rootJsonArray.getJSONObject(i);

                                mExampleList.add(new ITBytesModel(object.optString("year"),
                                        object.optString("month_edition"),
                                        object.optString("year_display"),
                                        object.optString("edition_display")));
                            }

                            Log.e("rootJsonArray",mExampleList.size()+"");

                            mExampleAdapter = new ITBytesAdapter(ITBytesActivity.this, mExampleList);
                            sRecyclerview.setAdapter(mExampleAdapter);
                            mExampleAdapter.notifyDataSetChanged();
                            sRecyclerview.setHasFixedSize(true);

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

}
