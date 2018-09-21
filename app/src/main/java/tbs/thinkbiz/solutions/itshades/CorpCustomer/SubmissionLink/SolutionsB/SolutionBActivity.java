package tbs.thinkbiz.solutions.itshades.CorpCustomer.SubmissionLink.SolutionsB;

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

import java.util.ArrayList;
import java.util.List;

import tbs.thinkbiz.solutions.itshades.CorpCustomer.CorpMainActivity;
import tbs.thinkbiz.solutions.itshades.CorpCustomer.SubmissionLink.Parent;
import tbs.thinkbiz.solutions.itshades.CorpCustomer.SubmissionLink.ParentActivity;
import tbs.thinkbiz.solutions.itshades.CorpCustomer.SubmissionLink.ParentAdapter;
import tbs.thinkbiz.solutions.itshades.R;

public class SolutionBActivity extends AppCompatActivity {

    List<SoluModelB> productList1;
    RecyclerView recyclerViewtitle;

    String Actname;
    TextView textname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solution_b);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.backbar);
        View view =getSupportActionBar().getCustomView();

        SharedPreferences pref = this.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        Actname=pref.getString("Actvname","");
        textname=(TextView)findViewById(R.id.textname);
        textname.setText(Actname);

        ImageButton imageButton= (ImageButton)view.findViewById(R.id.action_bar_back);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String actname="Submission Links";

                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = pref.edit();

                edit.putString("Actvname",actname);

                edit.commit();
                Intent intent=new Intent(SolutionBActivity.this, ParentActivity.class);
                startActivity(intent);

            }
        });

        productList1 = new ArrayList<>();
        recyclerViewtitle = (RecyclerView) findViewById(R.id.recycler);
        recyclerViewtitle.setNestedScrollingEnabled(false);
        recyclerViewtitle.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerViewtitle.setHasFixedSize(true);


        productList1.add(new SoluModelB("Products & Platforms"));
        productList1.add(new SoluModelB("IT Consulting & Services"));
        productList1.add(new SoluModelB("Industry Solution"));




        SoluAdapterB adapter1 = new SoluAdapterB(this, productList1);
        recyclerViewtitle.setAdapter(adapter1);
    }
}
