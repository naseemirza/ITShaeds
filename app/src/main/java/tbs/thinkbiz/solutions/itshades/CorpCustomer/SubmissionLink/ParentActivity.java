package tbs.thinkbiz.solutions.itshades.CorpCustomer.SubmissionLink;

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

import tbs.thinkbiz.solutions.itshades.CorpCustomer.CorpMainActivity;
import tbs.thinkbiz.solutions.itshades.CorpCustomer.SubmissionLink.JobSubmission.EditViewActivity;
import tbs.thinkbiz.solutions.itshades.CorpCustomer.SubmissionLink.JobSubmission.JobSubmiActivity;
import tbs.thinkbiz.solutions.itshades.R;

import java.util.ArrayList;
import java.util.List;

public class ParentActivity extends AppCompatActivity {

    List<Parent> productList1;
    RecyclerView recyclerViewtitle;

    String Actname;
    TextView textname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent);

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
                Intent intent=new Intent(ParentActivity.this, CorpMainActivity.class);
                startActivity(intent);
                finish();
            }
        });


        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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
