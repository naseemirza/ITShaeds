package tbs.thinkbiz.solutions.itshades.CorpCustomer.Profile;

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
import tbs.thinkbiz.solutions.itshades.R;

public class ProfileActivity extends AppCompatActivity {

    List<ProfileModel> productList1;
    RecyclerView recyclerViewtitle;

    String Actname;
    TextView textname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

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

//                String actname="Corporate Customer";
//
//                SharedPreferences pref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
//                SharedPreferences.Editor edit = pref.edit();
//
//                edit.putString("Actvname",actname);
//                edit.commit();
                Intent intent=new Intent(ProfileActivity.this, CorpMainActivity.class);
                startActivity(intent);
            }
        });


        productList1 = new ArrayList<>();
        recyclerViewtitle = (RecyclerView) findViewById(tbs.thinkbiz.solutions.itshades.R.id.recyclerprofile);
        recyclerViewtitle.setNestedScrollingEnabled(false);
        recyclerViewtitle.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerViewtitle.setHasFixedSize(true);


        productList1.add(new ProfileModel("Company Site"));
        productList1.add(new ProfileModel("Account Details"));
        productList1.add(new ProfileModel("Change Password"));
        productList1.add(new ProfileModel("Invite To Friends"));
        productList1.add(new ProfileModel("Contact Us"));
        productList1.add(new ProfileModel("Log Out"));


        ProfileAdapter adapter1 = new ProfileAdapter(this, productList1);
        recyclerViewtitle.setAdapter(adapter1);
    }
}
