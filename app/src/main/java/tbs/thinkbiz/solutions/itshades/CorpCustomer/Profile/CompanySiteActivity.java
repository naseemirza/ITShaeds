package tbs.thinkbiz.solutions.itshades.CorpCustomer.Profile;

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

import java.util.ArrayList;
import java.util.List;

import tbs.thinkbiz.solutions.itshades.CompnyDrctry.CompPrflAdapter;
import tbs.thinkbiz.solutions.itshades.CompnyDrctry.CompPrflModel;
import tbs.thinkbiz.solutions.itshades.R;

public class CompanySiteActivity extends AppCompatActivity {

    List<CompSiteModel> productList;
    RecyclerView recyclerView;

    String Actname , sitename,phone,website,desc,image,mailid;
    TextView textname , sitetext, phonetext,websitetext,desctext, mailtext;
    ImageView cmpimage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_site);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.backbar);
        View view =getSupportActionBar().getCustomView();

        ImageButton imageButton= (ImageButton)view.findViewById(R.id.action_bar_back);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        SharedPreferences pref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        Actname=pref.getString("Actvname","");

        textname=(TextView)findViewById(R.id.textname);
        textname.setText(Actname);


        //category name with icon

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        productList = new ArrayList<>();


        productList.add(new CompSiteModel("Solutions", R.drawable.solutions));
        productList.add(new CompSiteModel("L & D", R.drawable.learning));
        productList.add(new CompSiteModel("Artifacts", R.drawable.artifacts));
        productList.add(new CompSiteModel("Events", R.drawable.events));
        productList.add(new CompSiteModel("Classified", R.drawable.classifieds));
        productList.add(new CompSiteModel("Jobs", R.drawable.jobs));
        productList.add(new CompSiteModel("Blogs", R.drawable.company_reviews));



        CompSiteAdapter adapter = new CompSiteAdapter(this, productList);
        recyclerView.setAdapter(adapter);
    }
}
