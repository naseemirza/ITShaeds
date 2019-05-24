package tbs.thinkbiz.solutions.itshades.IndividulaProfile;

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
import tbs.thinkbiz.solutions.itshades.CorpCustomer.Profile.ProfileActivity;
import tbs.thinkbiz.solutions.itshades.CorpCustomer.Profile.ProfileAdapter;
import tbs.thinkbiz.solutions.itshades.CorpCustomer.Profile.ProfileModel;
import tbs.thinkbiz.solutions.itshades.Main2Activity;
import tbs.thinkbiz.solutions.itshades.MainPageTab.MainPageActivity;
import tbs.thinkbiz.solutions.itshades.R;

public class MyProfileActivity extends AppCompatActivity {

    List<IndProfileModel> productList1;
    RecyclerView recyclerViewtitle;
    String Actname;
    TextView textname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

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

                //finish();
                Intent intent=new Intent(MyProfileActivity.this, MainPageActivity.class);
                startActivity(intent);
            }
        });

        productList1 = new ArrayList<>();
        recyclerViewtitle = (RecyclerView) findViewById(R.id.recyclerprofile);
        recyclerViewtitle.setNestedScrollingEnabled(false);
        recyclerViewtitle.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerViewtitle.setHasFixedSize(true);

        productList1.add(new IndProfileModel("Become Premium User"));
        productList1.add(new IndProfileModel("Change Password"));
        productList1.add(new IndProfileModel("Invite To Friends"));
        productList1.add(new IndProfileModel("Contact Us"));
        productList1.add(new IndProfileModel("Subcribe"));

        IndprofileAdapter adapter1 = new IndprofileAdapter(this, productList1);
        recyclerViewtitle.setAdapter(adapter1);
    }
}
