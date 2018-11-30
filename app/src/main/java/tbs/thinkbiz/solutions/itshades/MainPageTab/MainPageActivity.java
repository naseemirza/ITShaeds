package tbs.thinkbiz.solutions.itshades.MainPageTab;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import tbs.thinkbiz.solutions.itshades.AboutUsActivity;
import tbs.thinkbiz.solutions.itshades.ContactUsActivity;
import tbs.thinkbiz.solutions.itshades.IndividulaProfile.MyProfileActivity;
import tbs.thinkbiz.solutions.itshades.LoginActivity;
import tbs.thinkbiz.solutions.itshades.MainPageTab.ArtifactsTabs.ArtifactsFrag;
import tbs.thinkbiz.solutions.itshades.MainPageTab.BusinessCorner.BusinessCornerFrag;
import tbs.thinkbiz.solutions.itshades.MainPageTab.ITByteTabs.ITBytesFrag;
import tbs.thinkbiz.solutions.itshades.MainPageTab.ITJobsTabs.ITJobsFrag;
import tbs.thinkbiz.solutions.itshades.MainPageTab.L_n_DTabs.L_AND_DFrag;
import tbs.thinkbiz.solutions.itshades.MainPageTab.MarkEventTabs.MarkEvntFrag;
import tbs.thinkbiz.solutions.itshades.MainPageTab.SolutionsTabs.SolutionsFrag;
import tbs.thinkbiz.solutions.itshades.R;

public class MainPageActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

     Toolbar toolbar;
     TabLayout tabLayout;
    ViewPager viewPager;

    String username,usermail;
    TextView textViewname,textViewemail;
    ImageView imghome;
    String uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        SharedPreferences pref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        uid=pref.getString("userid","");
        username = pref.getString("Username", "");
        usermail = pref.getString("email", "");

//        imghome=(ImageView)findViewById(R.id.homeicon);
//        imghome.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainPageActivity.this,MainPageActivity.class));
//            }
//        });

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        //tabLayout.setTabTextColors(R.color.colorBlack, R.color.colorBlack);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.colorBlack));
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        textViewname= (TextView) navigationView.getHeaderView(0).findViewById(R.id.usernametext);
        textViewemail= (TextView) navigationView.getHeaderView(0).findViewById(R.id.textViewmail);
        textViewname.setText(username);
        textViewemail.setText(usermail);
    }



    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new HomeFrag(), "HOME");
        adapter.addFragment(new ITBytesFrag(), "IT BYTES");
        adapter.addFragment(new SolutionsFrag(), "SOLUTIONS");
        adapter.addFragment(new L_AND_DFrag(), "L & D");
        adapter.addFragment(new ArtifactsFrag(), "ARTIFACTS");
        adapter.addFragment(new MarkEvntFrag(), "MARKETING EVENTS");
        adapter.addFragment(new BusinessCornerFrag(), "BUSINESS CORNER");
        adapter.addFragment(new ITJobsFrag(), "IT Jobs");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
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
        getMenuInflater().inflate(R.menu.main_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_aboutus) {

            startActivity(new Intent(MainPageActivity.this,AboutUsActivity.class));
        }

        else if (id == R.id.nav_profile) {

            String actname="My Profile";
            SharedPreferences pref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
            SharedPreferences.Editor edit = pref.edit();
            edit.putString("Actvname",actname);
            edit.apply();
            startActivity(new Intent(MainPageActivity.this,MyProfileActivity.class));
        }
//        else if (id == R.id.nav_chngpass) {
//            startActivity(new Intent(Main2Activity.this,IndChangePassActivity.class));
//        }
//        else if (id == R.id.nav_invtfrnds) {
//            startActivity(new Intent(Main2Activity.this,IndInvitFrndsActivity.class));
//        }
//        else if (id == R.id.subscrib) {
//            startActivity(new Intent(Main2Activity.this,IndSubscrbActivity.class));
//        }

        else if (id == R.id.nav_logout) {
            startActivity(new Intent(MainPageActivity.this,LoginActivity.class));

        } else if (id == R.id.nav_contactus) {

            //ContactUsActivity
            Intent intent=new Intent(MainPageActivity.this,ContactUsActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
