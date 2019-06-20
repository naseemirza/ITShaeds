package tbs.thinkbiz.solutions.itshades.MainPageTab.ITByteTabs;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
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
import tbs.thinkbiz.solutions.itshades.ITBytes.ITBytesAdapter;
import tbs.thinkbiz.solutions.itshades.ITBytes.ITBytesModel;
import tbs.thinkbiz.solutions.itshades.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ITBytesFrag extends Fragment {

    private ITBytesAdapter mExampleAdapter;
    private ArrayList<ITBytesModel> mExampleList;
    private RequestQueue mRequestQueue;
    private RecyclerView sRecyclerview;

    String Actname;
    TextView textname;
    ProgressBar progressBar;


    public ITBytesFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.fragment_itbytes, container, false);

        //getActivity().getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        //getActivity().getSupportActionBar().setDisplayShowCustomEnabled(true);
        //getActivity().getSupportActionBar().setCustomView(R.layout.backbar);
        //View view =getActivity().getSupportActionBar().getCustomView();

        //SharedPreferences pref = getActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        //Actname=pref.getString("Actvname","");
       // textname=(TextView)rootView.findViewById(tbs.thinkbiz.solutions.itshades.R.id.textname);
       // textname.setText(Actname);

//        ImageButton imageButton= (ImageButton)view.findViewById(tbs.thinkbiz.solutions.itshades.R.id.action_bar_back);
//
//        imageButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                getActivity().finish();
//            }
//        });

         progressBar = (ProgressBar)rootView.findViewById(R.id.progressBar);

        mExampleList = new ArrayList<>();
        mRequestQueue = Volley.newRequestQueue(getActivity());
        sRecyclerview=(RecyclerView)rootView.findViewById(R.id.my_recycler_jobs);
        sRecyclerview.setNestedScrollingEnabled(false);
        sRecyclerview.setLayoutManager(new GridLayoutManager(getActivity(),2));
        sRecyclerview.setHasFixedSize(true);

        parseJSON();

        return rootView;
    }

    private void parseJSON() {

        //final ProgressBar progressBar = (ProgressBar)getActivity().findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, AllUrls.ITBYTES_HOME,
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

                                mExampleList.add(new ITBytesModel(object.optString("year"),
                                        object.optString("year_display"),
                                        object.optString("month_edition")));
                            }

                            Log.e("rootJsonArray",mExampleList.size()+"");

                            mExampleAdapter = new ITBytesAdapter(getActivity(), mExampleList);
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

        mRequestQueue = Volley.newRequestQueue(getActivity());
        mRequestQueue.add(stringRequest);
    }

}
