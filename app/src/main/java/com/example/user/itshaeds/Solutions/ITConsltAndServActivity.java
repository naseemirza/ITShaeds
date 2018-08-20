package com.example.user.itshaeds.Solutions;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.user.itshaeds.R;

import java.util.ArrayList;
import java.util.List;

public class ITConsltAndServActivity extends AppCompatActivity {

    //private Spinner spiner1,spiner2;

    List<SoluModel> productList1;
    RecyclerView recyclerView;
    String Actname;
    TextView textname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itconslt_and_serv);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.backandfilterbar);
        View view =getSupportActionBar().getCustomView();

        SharedPreferences pref = this.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        Actname=pref.getString("Actvname","");
        textname=(TextView)findViewById(R.id.textname);
        textname.setText(Actname);

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


//        spiner1 = (Spinner) findViewById(R.id.spinner1);
//        String[] users = new String[]{
//                "All",
//                "Airlines",
//                "Banking",
//                "Airlines",
//                "Banking",
//                "Airlines",
//                "Banking",
//                "Airlines",
//                "Banking",
//                "Airlines",
//                "Banking"
//        };
//
//        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
//                this,R.layout.spinneritems,users
//        );
//        spinnerArrayAdapter.setDropDownViewResource(R.layout.spinneritems);
//        spiner1.setAdapter(spinnerArrayAdapter);
//
//
//        spiner2 = (Spinner) findViewById(R.id.spinner2);
//        String[] users2 = new String[]{
//                "All",
//                "Airlines",
//                "Banking",
//                "Airlines",
//                "Banking",
//                "Airlines",
//                "Banking",
//                "Airlines",
//                "Banking",
//                "Airlines",
//                "Banking"
//        };
//
//        ArrayAdapter<String> spinnerArrayAdapter2 = new ArrayAdapter<String>(
//                this,R.layout.spinneritems,users2
//        );
//        spinnerArrayAdapter.setDropDownViewResource(R.layout.spinneritems);
//        spiner2.setAdapter(spinnerArrayAdapter2);


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
                String actname ="Filtration";
                SharedPreferences pref = v.getContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = pref.edit();
                edit.putString("Actvname",actname );

                edit.commit();
                Intent intent=new Intent(ITConsltAndServActivity.this,FilterAllActivity.class);

                startActivity(intent);
            }
        });

    }
}
