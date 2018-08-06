package com.example.user.itshaeds.ITBytes;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.itshaeds.AdapterJobs;
import com.example.user.itshaeds.JobsModelName;
import com.example.user.itshaeds.ModelJobs;
import com.example.user.itshaeds.PrevayActivity;
import com.example.user.itshaeds.R;
import com.example.user.itshaeds.TermsActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ITBytDetailsActivity extends AppCompatActivity {

    List<JobsModelName> productList1;

    List<ModelJobs> productList;
    RecyclerView recyclerView,recyclerViewtitle;
    //CheckBox checkBox;
    TextView discla,termsndcond,prvynspolcy;

    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    HashMap<String, List<String>> expandableListDetail;

    ImageView imageViewadd,imageViewminus;


    TextView activitynametext;
    String actvtyname,acttyname1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itbyt_details);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.itbytedetailbar);
        View view =getSupportActionBar().getCustomView();

        activitynametext=(TextView)findViewById(R.id.actname);
        SharedPreferences pref = this.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        actvtyname=pref.getString("Title","");
        acttyname1=pref.getString("nm","");

        activitynametext.setText(actvtyname+" "+acttyname1);


        ImageButton imageButton= (ImageButton)view.findViewById(R.id.action_bar_back);

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
//                startActivity(new Intent(Main2Activity.this,DisclaierActivity.class));
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
        productList.add(new ModelJobs("Solutions", R.drawable.solutions));
        productList.add(new ModelJobs("Reward & Ricognition", R.drawable.reward));
        productList.add(new ModelJobs("Customer Success", R.drawable.customer_reviews));
        productList.add(new ModelJobs("Marketing & Events", R.drawable.marketing));
        productList.add(new ModelJobs("A & A Partnership", R.drawable.partnership));
        productList.add(new ModelJobs("Miscellaneous", R.drawable.misclenious));
        productList.add(new ModelJobs("Announcements", R.drawable.anouncment));




        ITBytRecycAdapter adapter = new ITBytRecycAdapter(this, productList);
        recyclerView.setAdapter(adapter);



        imageViewadd=(ImageView)findViewById(R.id.imgadd);
        imageViewminus=(ImageView)findViewById(R.id.imgminus);


//        expandableListView = (ExpandableListView)findViewById(R.id.expandableListView);
//        expandableListView.setGroupIndicator(null);
//        expandableListDetail = ExpandableListDataPump.getData();
//        expandableListTitle = new ArrayList<String>(expandableListDetail.keySet());
//
//        expandableListAdapter = new CustomExpandableListAdapter(ITBytDetailsActivity.this, expandableListTitle, expandableListDetail);
//        expandableListView.setAdapter(expandableListAdapter);
//        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
//
//            @Override
//            public void onGroupExpand(int groupPosition) {
//
//                imageViewadd=(ImageView)findViewById(R.id.imgadd);
//                imageViewminus=(ImageView)findViewById(R.id.imgminus);
//
//                imageViewadd.setVisibility(View.GONE);
//                imageViewminus.setVisibility(View.VISIBLE);
//
////                        Toast.makeText(getActivity().getApplicationContext(),
////                                expandableListTitle.get(groupPosition) + " List Expanded.",
////                                Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
//
//            @Override
//            public void onGroupCollapse(int groupPosition) {
//
//                imageViewadd.setVisibility(View.VISIBLE);
//                imageViewminus.setVisibility(View.GONE);
//
////                        Toast.makeText(getActivity().getApplicationContext(),
////                                expandableListTitle.get(groupPosition) + " List Collapsed.",
////                                Toast.LENGTH_SHORT).show();
//
//            }
//        });
//
//        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
//            @Override
//            public boolean onChildClick(ExpandableListView parent, View v,
//                                        int groupPosition, int childPosition, long id) {
//
//
////                        Toast.makeText(
////                                getActivity().getApplicationContext(),
////                                expandableListTitle.get(groupPosition)
////                                        + " -> "
////                                        + expandableListDetail.get(
////                                        expandableListTitle.get(groupPosition)).get(
////                                        childPosition), Toast.LENGTH_SHORT
////                        ).show();
//                return false;
//            }
//        });


        // Jobs Title names

        productList1 = new ArrayList<>();
        recyclerViewtitle = (RecyclerView) findViewById(R.id.my_recycler_jobs);
        recyclerViewtitle.setNestedScrollingEnabled(false);
        recyclerViewtitle.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerViewtitle.setHasFixedSize(true);



        productList1.add(new JobsModelName("Financial Results for the First Quarter","Infosys announces results for Infosys announces results for Infosys announces results for Infosys announces results for"));
        productList1.add(new JobsModelName("Financial Results for the First Quarter","Infosys announces results for Infosys announces results for Infosys announces results for Infosys announces results for"));
        productList1.add(new JobsModelName("Financial Results for the First Quarter","Infosys announces results for Infosys announces results for Infosys announces results for Infosys announces results for"));
        productList1.add(new JobsModelName("Financial Results for the First Quarter","Infosys announces results for Infosys announces results for Infosys announces results for Infosys announces results for"));
        productList1.add(new JobsModelName("Financial Results for the First Quarter","Infosys announces results for Infosys announces results for Infosys announces results for Infosys announces results for"));
        productList1.add(new JobsModelName("Financial Results for the First Quarter","Infosys announces results for Infosys announces results for Infosys announces results for Infosys announces results for"));
        productList1.add(new JobsModelName("Financial Results for the First Quarter","Infosys announces results for Infosys announces results for Infosys announces results for Infosys announces results for"));



        ITbytdetailsAdapter adapter1 = new ITbytdetailsAdapter(this, productList1);
        recyclerViewtitle.setAdapter(adapter1);
    }
}
