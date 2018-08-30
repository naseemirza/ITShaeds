package com.example.user.itshaeds.CorpCustomer;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.example.user.itshaeds.CorpCustomer.Profile.ProfileActivity;
import com.example.user.itshaeds.CorpCustomer.SubmissionLink.ParentActivity;
import com.example.user.itshaeds.R;

public class CorpMainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    WebView mywebview;
    ProgressDialog progressDialog;

    String username,usermail;
    TextView textViewname,textViewemail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corp_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        SharedPreferences pref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        username = pref.getString("Username", "");
        usermail = pref.getString("email", "");


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

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.colorBlack));
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        textViewname= (TextView) navigationView.getHeaderView(0).findViewById(R.id.corptext);
        textViewemail= (TextView) navigationView.getHeaderView(0).findViewById(R.id.corptextmail);
        textViewname.setText(username);
        textViewemail.setText(usermail);
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
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.corp_main, menu);
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
            startActivity(new Intent(CorpMainActivity.this,ProfileActivity.class));
            // Handle the camera action
        } else if (id == R.id.nav_subm) {
           startActivity(new Intent(CorpMainActivity.this,ParentActivity.class));
        } else if (id == R.id.nav_authuser) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
