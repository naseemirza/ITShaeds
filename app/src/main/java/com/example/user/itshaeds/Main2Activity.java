package com.example.user.itshaeds;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    List<JobsModelName> productList1;

    List<ModelJobs> productList;
    RecyclerView recyclerView,recyclerViewtitle;
    //CheckBox checkBox;
    TextView discla,termsndcond,prvynspolcy;
    FloatingActionButton floatingActionButton;

    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        floatingActionButton=(FloatingActionButton)findViewById(R.id.fab);
        checkBox=(CheckBox)findViewById(R.id.chkox);



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
                startActivity(new Intent(Main2Activity.this,TermsActivity.class));
            }
        });

        prvynspolcy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main2Activity.this,PrevayActivity.class));
            }
        });


        //category name with icon

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        productList = new ArrayList<>();

        productList.add(new ModelJobs("Dream Jobs", R.drawable.jobs));
        productList.add(new ModelJobs("Current Jobs", R.drawable.jobs));
        productList.add(new ModelJobs("IT Bytes", R.drawable.it));
        productList.add(new ModelJobs("Classified", R.drawable.classifieds));
        productList.add(new ModelJobs("Solutions", R.drawable.solutions));
        productList.add(new ModelJobs("L & D", R.drawable.learning));
        productList.add(new ModelJobs("Artifacts", R.drawable.artifacts));
        productList.add(new ModelJobs("Events", R.drawable.events));
        productList.add(new ModelJobs("Company Reviews", R.drawable.company_reviews));



        AdapterJobs adapter = new AdapterJobs(this, productList);
        recyclerView.setAdapter(adapter);

        // Jobs Title names

        productList1 = new ArrayList<>();
        recyclerViewtitle = (RecyclerView) findViewById(R.id.my_recycler_jobs);
        recyclerViewtitle.setNestedScrollingEnabled(false);
        recyclerViewtitle.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerViewtitle.setHasFixedSize(true);



        productList1.add(new JobsModelName("Assistant Manager-.Net Sql Tech Lead","7-10 Yrs, India Hyderabad"));
        productList1.add(new JobsModelName("Assistant Manager-.Net Sql Tech Lead","7-10 Yrs, India Hyderabad"));
        productList1.add(new JobsModelName("Assistant Manager-.Net Sql Tech Lead","7-10 Yrs, India Hyderabad"));
        productList1.add(new JobsModelName("Assistant Manager-.Net Sql Tech Lead","7-10 Yrs, India Hyderabad"));
        productList1.add(new JobsModelName("Assistant Manager-.Net Sql Tech Lead","7-10 Yrs, India Hyderabad"));
        productList1.add(new JobsModelName("Assistant Manager-.Net Sql Tech Lead","7-10 Yrs, India Hyderabad"));
        productList1.add(new JobsModelName("Assistant Manager-.Net Sql Tech Lead","7-10 Yrs, India Hyderabad"));
        productList1.add(new JobsModelName("Assistant Manager-.Net Sql Tech Lead","7-10 Yrs, India Hyderabad"));
        productList1.add(new JobsModelName("Assistant Manager-.Net Sql Tech Lead","7-10 Yrs, India Hyderabad"));
        productList1.add(new JobsModelName("Assistant Manager-.Net Sql Tech Lead","7-10 Yrs, India Hyderabad"));




        JobsNameAdapter adapter1 = new JobsNameAdapter(this, productList1);
        recyclerViewtitle.setAdapter(adapter1);




        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_search) {
//
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_aboutus) {
            startActivity(new Intent(Main2Activity.this,AboutUsActivity.class));
        } else if (id == R.id.nav_subsc) {
            startActivity(new Intent(Main2Activity.this,SubscribeActivity.class));
        } else if (id == R.id.nav_login) {
            startActivity(new Intent(Main2Activity.this,LoginActivity.class));

        } else if (id == R.id.nav_contactus) {
            startActivity(new Intent(Main2Activity.this,ContactUsActivity.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
