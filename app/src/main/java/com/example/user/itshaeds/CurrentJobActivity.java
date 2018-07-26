package com.example.user.itshaeds;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CurrentJobActivity extends AppCompatActivity {

    //TextView textViewpo1,textexp,textloc;
    List<JobsModelName> productList1;
    RecyclerView recyclerViewtitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_job);

//        textViewpo1=(TextView)findViewById(R.id.textpost);
//        textexp=(TextView)findViewById(R.id.textYRS);
//        textloc=(TextView)findViewById(R.id.textloc);
//
//        textViewpo1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                String textpost=textViewpo1.getText().toString();
//                String textexpr=textexp.getText().toString();
//                String textloct=textloc.getText().toString();
//
//
//                Intent intent=new Intent(CurrentJobActivity.this, DetailsActivity.class);
//                intent.putExtra("postname",textpost);
//                intent.putExtra("exp",textexpr);
//                intent.putExtra("location",textloct);
//
//                startActivity(intent);
//            }
//        });

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.currentjobsfilterbar);
        View view =getSupportActionBar().getCustomView();

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
                startActivity(new Intent(CurrentJobActivity.this,CrntJobFilterActivity.class));
            }
        });


        productList1 = new ArrayList<>();
        recyclerViewtitle = (RecyclerView) findViewById(R.id.my_recycler_jobs);
        recyclerViewtitle.setNestedScrollingEnabled(false);
        recyclerViewtitle.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerViewtitle.setHasFixedSize(true);


        productList1.add(new JobsModelName("Assistant Manager-.Net Sql Technical Lead","7-10 Yrs, India Hyderabad"));
        productList1.add(new JobsModelName("Assistant Manager-.Net Sql Technical Lead","7-10 Yrs, India Hyderabad"));
        productList1.add(new JobsModelName("Assistant Manager-.Net Sql Technical Lead","7-10 Yrs, India Hyderabad"));
        productList1.add(new JobsModelName("Assistant Manager-.Net Sql Technical Lead","7-10 Yrs, India Hyderabad"));
        productList1.add(new JobsModelName("Assistant Manager-.Net Sql Technical Lead","7-10 Yrs, India Hyderabad"));
        productList1.add(new JobsModelName("Assistant Manager-.Net Sql Technical Lead","7-10 Yrs, India Hyderabad"));
        productList1.add(new JobsModelName("Assistant Manager-.Net Sql Technical Lead","7-10 Yrs, India Hyderabad"));
        productList1.add(new JobsModelName("Assistant Manager-.Net Sql Technical Lead","7-10 Yrs, India Hyderabad"));
        productList1.add(new JobsModelName("Assistant Manager-.Net Sql Technical Lead","7-10 Yrs, India Hyderabad"));
        productList1.add(new JobsModelName("Assistant Manager-.Net Sql Technical Lead","7-10 Yrs, India Hyderabad"));


        JobsNameAdapter adapter1 = new JobsNameAdapter(this, productList1);
        recyclerViewtitle.setAdapter(adapter1);

    }
}
