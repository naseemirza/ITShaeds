package tbs.thinkbiz.solutions.itshades.CorpCustomer.Profile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ProfileActivity extends AppCompatActivity {

    List<Profile> productList1;
    RecyclerView recyclerViewtitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(tbs.thinkbiz.solutions.itshades.R.layout.activity_profile);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        productList1 = new ArrayList<>();
        recyclerViewtitle = (RecyclerView) findViewById(tbs.thinkbiz.solutions.itshades.R.id.recyclerprofile);
        recyclerViewtitle.setNestedScrollingEnabled(false);
        recyclerViewtitle.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerViewtitle.setHasFixedSize(true);


        productList1.add(new Profile("Company Site"));
        productList1.add(new Profile("Account Details"));
        productList1.add(new Profile("Change Password"));
        productList1.add(new Profile("Invite To Friends"));
        productList1.add(new Profile("Contact Us"));
        productList1.add(new Profile("Log Out"));


        ProfileAdapter adapter1 = new ProfileAdapter(this, productList1);
        recyclerViewtitle.setAdapter(adapter1);
    }
}
