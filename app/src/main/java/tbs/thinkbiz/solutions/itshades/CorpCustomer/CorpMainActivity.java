package tbs.thinkbiz.solutions.itshades.CorpCustomer;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.TextView;

import tbs.thinkbiz.solutions.itshades.CorpCustomer.Profile.ProfileActivity;
import tbs.thinkbiz.solutions.itshades.CorpCustomer.SubmissionLink.ParentActivity;
import tbs.thinkbiz.solutions.itshades.LoginActivity;
import tbs.thinkbiz.solutions.itshades.R;

import static tbs.thinkbiz.solutions.itshades.LoginActivity.booltype;
import static tbs.thinkbiz.solutions.itshades.LoginActivity.Uroll;

public class CorpMainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    WebView mywebview;
    ProgressDialog progressDialog;

    String username,usermail,Userid,uroll;
    TextView textViewname,textViewemail;

    String Actname ;
    TextView textname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(tbs.thinkbiz.solutions.itshades.R.layout.activity_corp_main);
        Toolbar toolbar = (Toolbar) findViewById(tbs.thinkbiz.solutions.itshades.R.id.toolbar);
        setSupportActionBar(toolbar);


        SharedPreferences pref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        username = pref.getString("Username", "");
        uroll = pref.getString("uroll", "");
        booltype=pref.getBoolean("Booltype", Boolean.parseBoolean(""));
       // usermail = pref.getString("email", "");
        Userid = pref.getString("userid", "");
        //Actname = pref.getString("Actvname", "");

       // getSupportActionBar().setTitle(Actname);

        Log.e("userid",Userid);


//        mywebview = (WebView) findViewById(R.id.webView1);
//        mywebview.setWebViewClient(new MyWebViewClient());
//
//        String url="https://www.itshades.com/index.php";
//        mywebview.getSettings().setJavaScriptEnabled(true);
//        mywebview.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
//        mywebview.loadUrl(url);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(tbs.thinkbiz.solutions.itshades.R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, tbs.thinkbiz.solutions.itshades.R.string.navigation_drawer_open, tbs.thinkbiz.solutions.itshades.R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(tbs.thinkbiz.solutions.itshades.R.color.colorBlack));
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(tbs.thinkbiz.solutions.itshades.R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        textViewname= (TextView) navigationView.getHeaderView(0).findViewById(tbs.thinkbiz.solutions.itshades.R.id.corptext);
      //  textViewemail= (TextView) navigationView.getHeaderView(0).findViewById(tbs.thinkbiz.solutions.itshades.R.id.corptextmail);
        textViewname.setText(username);
       // textViewemail.setText(usermail);
    }

//    private class MyWebViewClient extends WebViewClient {
//        @Override
//        public boolean shouldOverrideUrlLoading(WebView view, String url) {
//            view.loadUrl(url);
//            return true;
//        }
//
//        @Override
//        public void onPageStarted(WebView view, String url, Bitmap favicon) {
//            super.onPageStarted(view, url, favicon);
//            progressDialog = new ProgressDialog(CorpMainActivity.this);
//            progressDialog.setMessage("Please wait ...");
//            progressDialog.setProgressStyle(90);
//            progressDialog.show();
//        }
//        @Override
//        public void onPageFinished(WebView view, String url) {
//            super.onPageFinished(view, url);
//            if (progressDialog != null) {
//                progressDialog.dismiss();
//            }
//        }
//    }

    @Override
    public void onBackPressed() {

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {

            //super.onBackPressed();
            Intent a = new Intent(Intent.ACTION_MAIN);
            a.addCategory(Intent.CATEGORY_HOME);
            a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(a);
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(tbs.thinkbiz.solutions.itshades.R.menu.corp_main, menu);
        return true;
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a Parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_profile) {

            String actname="Profile";

            SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
            SharedPreferences.Editor edit = pref.edit();

            edit.putString("Actvname",actname);

            edit.commit();
            Intent intent=new Intent(CorpMainActivity.this,ProfileActivity.class);
            startActivity(intent);
            // Handle the camera action
        } else if (id == R.id.nav_subm) {

            String actname="Submission Links";

            SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
            SharedPreferences.Editor edit = pref.edit();

            edit.putString("Actvname",actname);

            edit.apply();
            Intent intent=new Intent(CorpMainActivity.this,ParentActivity.class);
            startActivity(intent);
           //startActivity(new Intent(CorpMainActivity.this,ParentActivity.class));
        }
        else if (id == R.id.nav_subsc) {

            startActivity(new Intent(CorpMainActivity.this, SubscribeActivity.class));
        }
        if (id == R.id.nav_logout) {

            //String actname="Profile";
            booltype=false;
            SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
            SharedPreferences.Editor edit = pref.edit();
           // edit.putString("Actvname",actname);
            edit.putBoolean("Booltype",booltype);
            edit.putString("uroll", Uroll);
            edit.apply();
            Intent intent=new Intent(CorpMainActivity.this,LoginActivity.class);
            startActivity(intent);
            //startActivity(new Intent(CorpMainActivity.this,LoginActivity.class));

          }
//         else if (id == R.id.nav_authuser) {
//
//            String actname=" Manage Authorized Users";
//
//            SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
//            SharedPreferences.Editor edit = pref.edit();
//
//            edit.putString("Actvname",actname);
//
//            edit.commit();
//            Intent intent=new Intent(CorpMainActivity.this,MangAuthUsersActivity.class);
//            startActivity(intent);
       // }

        DrawerLayout drawer = (DrawerLayout) findViewById(tbs.thinkbiz.solutions.itshades.R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
