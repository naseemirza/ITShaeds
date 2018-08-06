package com.example.user.itshaeds.CompnyDrctry;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.itshaeds.R;

import java.util.ArrayList;
import java.util.List;

public class CmpProfileActivity extends AppCompatActivity {

    TextView discla,termsndcond,prvynspolcy;

    TextView textViewnm;
    ImageView cmpimage;
    String cmpname,cmpdesc,cmpimg;

    List<CompPrflModel> productList;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cmp_profile);

        SharedPreferences pref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        cmpname = pref.getString("Compname", "");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(cmpname);

        textViewnm = (TextView) findViewById(R.id.cmpname1);

//        textViewDes = (TextView) findViewById(R.id.abtcmpny);
//        cmpimage = (ImageView) findViewById(R.id.compid);
//

//        cmpdesc = pref.getString("Descrp", "");
//        cmpimg = pref.getString("cardimage", "");
//
//        Glide.with(this)
//                .load(cmpimg)
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .fitCenter()
//                .into(cmpimage);
//
//        // Picasso.with(getActivity()).load(mimage).fit().centerInside().into(imageView);
//        //textViewname.setText(mname);
        textViewnm.setText(cmpname);
        //textViewnm1.setError(cmpname);
//        textViewDes.setText(cmpdesc);

        //category name with icon

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        productList = new ArrayList<>();


        productList.add(new CompPrflModel("Solutions", R.drawable.solutions));
        productList.add(new CompPrflModel("L & D", R.drawable.learning));
        productList.add(new CompPrflModel("Artifacts", R.drawable.artifacts));
        productList.add(new CompPrflModel("Events", R.drawable.events));
        productList.add(new CompPrflModel("Classified", R.drawable.classifieds));
        productList.add(new CompPrflModel("Jobs", R.drawable.jobs));
        productList.add(new CompPrflModel("Blogs", R.drawable.company_reviews));



        CompPrflAdapter adapter = new CompPrflAdapter(this, productList);
        recyclerView.setAdapter(adapter);
    }
}
