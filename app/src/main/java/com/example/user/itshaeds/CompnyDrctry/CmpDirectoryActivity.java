package com.example.user.itshaeds.CompnyDrctry;

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

import com.example.user.itshaeds.PrevayActivity;
import com.example.user.itshaeds.R;
import com.example.user.itshaeds.TermsActivity;

import java.util.ArrayList;
import java.util.List;

public class CmpDirectoryActivity extends AppCompatActivity {

    List<CmpDrModel> productList;
    List<CompnyNameModel> productList1;
    RecyclerView recyclerView,recyclerCompny;
    //CheckBox checkBox;
    TextView discla,termsndcond,prvynspolcy;

    String Actname;
    TextView textname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cmp_directory);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.backandfilterbar);
        View view =getSupportActionBar().getCustomView();

        SharedPreferences pref = this.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        Actname=pref.getString("Actvname","");
        textname=(TextView)findViewById(R.id.textname);
        textname.setText(Actname);

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
                String actname ="Company Directory Filter";
                SharedPreferences pref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = pref.edit();

                edit.putString("Actvname",actname);

                edit.commit();
                Intent intent = new Intent(CmpDirectoryActivity.this, CmpProfFilterActivity.class);
                startActivity(intent);
                //startActivity(new Intent(CmpDirectoryActivity.this,CmpProfFilterActivity.class));
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
                startActivity(new Intent(CmpDirectoryActivity.this,TermsActivity.class));
            }
        });

        prvynspolcy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CmpDirectoryActivity.this,PrevayActivity.class));
            }
        });


        //category name with icon

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        productList = new ArrayList<>();

        productList.add(new CmpDrModel("All"));
        productList.add(new CmpDrModel("A"));
        productList.add(new CmpDrModel("B"));
        productList.add(new CmpDrModel("C"));
        productList.add(new CmpDrModel("D"));
        productList.add(new CmpDrModel("E"));
        productList.add(new CmpDrModel("F"));
        productList.add(new CmpDrModel("G"));
        productList.add(new CmpDrModel("H"));
        productList.add(new CmpDrModel("I"));
        productList.add(new CmpDrModel("J"));
        productList.add(new CmpDrModel("K"));
        productList.add(new CmpDrModel("L"));
        productList.add(new CmpDrModel("M"));
        productList.add(new CmpDrModel("N"));
        productList.add(new CmpDrModel("O"));
        productList.add(new CmpDrModel("P"));
        productList.add(new CmpDrModel("Q"));
        productList.add(new CmpDrModel("R"));
        productList.add(new CmpDrModel("S"));
        productList.add(new CmpDrModel("T"));
        productList.add(new CmpDrModel("U"));
        productList.add(new CmpDrModel("V"));
        productList.add(new CmpDrModel("W"));
        productList.add(new CmpDrModel("X"));
        productList.add(new CmpDrModel("Y"));
        productList.add(new CmpDrModel("Z"));




        CompDrAdapter adapter = new CompDrAdapter(this, productList);
        recyclerView.setAdapter(adapter);


        //Companies

        productList1 = new ArrayList<>();
        recyclerCompny = (RecyclerView) findViewById(R.id.my_recycler_jobs);
        recyclerCompny.setNestedScrollingEnabled(false);
        recyclerCompny.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerCompny.setHasFixedSize(true);



        productList1.add(new CompnyNameModel("inMorphis Services Pvt. Ltd.",R.string.msg,R.drawable.compnylogo));
        productList1.add(new CompnyNameModel("inMorphis Services Pvt. Ltd.",R.string.msg,R.drawable.compnylogo));
        productList1.add(new CompnyNameModel("inMorphis Services Pvt. Ltd.",R.string.msg,R.drawable.compnylogo));
        productList1.add(new CompnyNameModel("inMorphis Services Pvt. Ltd.",R.string.msg,R.drawable.compnylogo));
        productList1.add(new CompnyNameModel("inMorphis Services Pvt. Ltd.",R.string.msg,R.drawable.compnylogo));
        productList1.add(new CompnyNameModel("inMorphis Services Pvt. Ltd.",R.string.msg,R.drawable.compnylogo));
        productList1.add(new CompnyNameModel("inMorphis Services Pvt. Ltd.",R.string.msg,R.drawable.compnylogo));
        productList1.add(new CompnyNameModel("inMorphis Services Pvt. Ltd.",R.string.msg,R.drawable.compnylogo));
        productList1.add(new CompnyNameModel("inMorphis Services Pvt. Ltd.",R.string.msg,R.drawable.compnylogo));
        productList1.add(new CompnyNameModel("inMorphis Services Pvt. Ltd.",R.string.msg,R.drawable.compnylogo));
        productList1.add(new CompnyNameModel("inMorphis Services Pvt. Ltd.",R.string.msg,R.drawable.compnylogo));





        CompanyNameAdapter adapter1 = new CompanyNameAdapter(this, productList1);
        recyclerCompny.setAdapter(adapter1);
    }
}
