package com.example.user.itshaeds.LearningAndDevelopment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.user.itshaeds.R;
import com.example.user.itshaeds.Solutions.FilterAllActivity;
import com.example.user.itshaeds.Solutions.ProdAndPlatformActivity;
import com.example.user.itshaeds.Solutions.SoluAdapter;
import com.example.user.itshaeds.Solutions.SoluModel;

import java.util.ArrayList;
import java.util.List;

public class ClassroomTraingActivity extends AppCompatActivity {

    String actname;
    TextView actnametext;

    List<SoluModel> productList1;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classroom_traing);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.activitynamebar);
        View view =getSupportActionBar().getCustomView();

        actnametext=(TextView)findViewById(R.id.actnameall);
        SharedPreferences pref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        actname = pref.getString("Activityname", "");

        actnametext.setText(actname);


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
                String actvtyname="Filtration";
                SharedPreferences pref = v.getContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = pref.edit();
                edit.putString("Actvtname",actvtyname);

                edit.commit();
                Intent intent=new Intent(ClassroomTraingActivity.this,FilterAllActivity.class);

                startActivity(intent);
            }
        });

        productList1 = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_jobs);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setHasFixedSize(true);



        productList1.add(new SoluModel("Veeva-ZincMAPS Originator End User Course",
                "This 2-hour online course is for any user in any region assigned a Job to review within Zinc MAPS. Reviewers may also sign the final certificate, if applicable.",
                "Industry Relevance :"," All Industries","Focus Area :"," Digital",
                "Posted By :"," Admin","Posted Date :"," Thursday, 05 July 2018"));
        productList1.add(new SoluModel("Veeva-ZincMAPS Originator End User Course",
                "This 2-hour online course is for any user in any region assigned a Job to review within Zinc MAPS. Reviewers may also sign the final certificate, if applicable.",
                "Industry Relevance :"," All Industries","Focus Area :"," Digital",
                "Posted By :"," Admin","Posted Date :"," Thursday, 05 July 2018"));
        productList1.add(new SoluModel("Veeva-ZincMAPS Originator End User Course",
                "This 2-hour online course is for any user in any region assigned a Job to review within Zinc MAPS. Reviewers may also sign the final certificate, if applicable.",
                "Industry Relevance :"," All Industries","Focus Area :"," Digital",
                "Posted By :"," Admin","Posted Date :"," Thursday, 05 July 2018"));
        productList1.add(new SoluModel("Veeva-ZincMAPS Originator End User Course",
                "This 2-hour online course is for any user in any region assigned a Job to review within Zinc MAPS. Reviewers may also sign the final certificate, if applicable.",
                "Industry Relevance :"," All Industries","Focus Area :"," Digital",
                "Posted By :"," Admin","Posted Date :"," Thursday, 05 July 2018"));
        productList1.add(new SoluModel("Veeva-ZincMAPS Originator End User Course",
                "This 2-hour online course is for any user in any region assigned a Job to review within Zinc MAPS. Reviewers may also sign the final certificate, if applicable.",
                "Industry Relevance :"," All Industries","Focus Area :"," Digital",
                "Posted By :"," Admin","Posted Date :"," Thursday, 05 July 2018"));
        productList1.add(new SoluModel("Veeva-ZincMAPS Originator End User Course",
                "This 2-hour online course is for any user in any region assigned a Job to review within Zinc MAPS. Reviewers may also sign the final certificate, if applicable.",
                "Industry Relevance :"," All Industries","Focus Area :"," Digital",
                "Posted By :"," Admin","Posted Date :"," Thursday, 05 July 2018"));
        productList1.add(new SoluModel("Veeva-ZincMAPS Originator End User Course",
                "This 2-hour online course is for any user in any region assigned a Job to review within Zinc MAPS. Reviewers may also sign the final certificate, if applicable.",
                "Industry Relevance :"," All Industries","Focus Area :"," Digital",
                "Posted By :"," Admin","Posted Date :"," Thursday, 05 July 2018"));
        productList1.add(new SoluModel("Veeva-ZincMAPS Originator End User Course",
                "This 2-hour online course is for any user in any region assigned a Job to review within Zinc MAPS. Reviewers may also sign the final certificate, if applicable.",
                "Industry Relevance :"," All Industries","Focus Area :"," Digital",
                "Posted By :"," Admin","Posted Date :"," Thursday, 05 July 2018"));
        productList1.add(new SoluModel("Veeva-ZincMAPS Originator End User Course",
                "This 2-hour online course is for any user in any region assigned a Job to review within Zinc MAPS. Reviewers may also sign the final certificate, if applicable.",
                "Industry Relevance :"," All Industries","Focus Area :"," Digital",
                "Posted By :"," Admin","Posted Date :"," Thursday, 05 July 2018"));
        productList1.add(new SoluModel("Veeva-ZincMAPS Originator End User Course",
                "This 2-hour online course is for any user in any region assigned a Job to review within Zinc MAPS. Reviewers may also sign the final certificate, if applicable.",
                "Industry Relevance :"," All Industries","Focus Area :"," Digital",
                "Posted By :"," Admin","Posted Date :"," Thursday, 05 July 2018"));



        SoluAdapter adapter1 = new SoluAdapter(this, productList1);
        recyclerView.setAdapter(adapter1);

    }
}
