package com.example.user.itshaeds.CorpCustomer.SubmissionLink;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.user.itshaeds.R;

import java.util.ArrayList;
import java.util.List;

public class ParentActivity extends AppCompatActivity {

    List<Parent> productList1;
    RecyclerView recyclerViewtitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        productList1 = new ArrayList<>();
        recyclerViewtitle = (RecyclerView) findViewById(R.id.recycler);
        recyclerViewtitle.setNestedScrollingEnabled(false);
        recyclerViewtitle.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerViewtitle.setHasFixedSize(true);


        productList1.add(new Parent("Jobs Submission"));
        productList1.add(new Parent("Solutions"));
        productList1.add(new Parent("Learning & Development"));
        productList1.add(new Parent("Artifacts"));
        productList1.add(new Parent("Events"));
        productList1.add(new Parent("Classifieds"));
        productList1.add(new Parent("Blog"));
        productList1.add(new Parent("Webinar"));


        ParentAdapter adapter1 = new ParentAdapter(this, productList1);
        recyclerViewtitle.setAdapter(adapter1);
    }
}
