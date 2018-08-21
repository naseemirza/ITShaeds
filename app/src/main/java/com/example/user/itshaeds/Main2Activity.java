package com.example.user.itshaeds;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.user.itshaeds.CorpCustomer.Profile.ProfileActivity;
import com.example.user.itshaeds.Jobs.AdapterJobs;
import com.example.user.itshaeds.Jobs.JobsModelName;
import com.example.user.itshaeds.Jobs.JobsNameAdapter;
import com.example.user.itshaeds.Jobs.ModelJobs;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener  {

    List<ModelJobs> productList;
    RecyclerView recyclerView;

    TextView discla,termsndcond,prvynspolcy;
    FloatingActionButton floatingActionButton;
    CheckBox checkBox;
    Button buttonaply;

    private JobsNameAdapter mExampleAdapter1;
    private ArrayList<JobsModelName> mExampleList1;
    private RequestQueue mRequestQueue1;
    private RecyclerView mRecyclerview1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);



//        if(!isConnected(Main2Activity.this)) buildDialog(Main2Activity.this).show();
//        else {
//            //Toast.makeText(MainActivity.this,"", Toast.LENGTH_SHORT).show();
//            setContentView(R.layout.activity_main2);
//        }

        //floatingActionButton=(FloatingActionButton)findViewById(R.id.fab);
        //checkBox=(CheckBox)findViewById(R.id.chkox);
        //buttonaply=(Button)findViewById(R.id.applybutton);



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


        mExampleList1 = new ArrayList<>();
        mRequestQueue1 = Volley.newRequestQueue(this);
        mRecyclerview1=(RecyclerView)findViewById(R.id.my_recycler_jobs);
        mRecyclerview1.setNestedScrollingEnabled(false);
        mRecyclerview1.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        mRecyclerview1.setHasFixedSize(true);

        parseJSON1();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



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
    }



//    public boolean isConnected(Context context) {
//
//        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
//        NetworkInfo netinfo = cm.getActiveNetworkInfo();
//
//        if (netinfo != null && netinfo.isConnectedOrConnecting()) {
//            android.net.NetworkInfo wifi = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
//            android.net.NetworkInfo mobile = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
//
//            if((mobile != null && mobile.isConnectedOrConnecting()) || (wifi != null && wifi.isConnectedOrConnecting())) return true;
//            else return false;
//        } else
//            return false;
//    }
//
//    public AlertDialog.Builder buildDialog(Context c) {
//
//        AlertDialog.Builder builder = new AlertDialog.Builder(c);
//        builder.setTitle("No Internet Connection");
//        builder.setMessage("You need to have Mobile Data or wifi to access this. Press ok to Exit");
//
//        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//
//               dialog.dismiss();
//            }
//        });
//
//        return builder;
//    }


    private void parseJSON1() {

        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, "https://www.itshades.com/appwebservices/job-search.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        progressBar.setVisibility(View.INVISIBLE);

                        try {
                            Log.e("rootJsonArray",response);
                            JSONArray rootJsonArray = new JSONArray(response);

                            Log.e("rootJsonArrayLength",rootJsonArray.length()+"");

                            for (int i = 0; i < rootJsonArray.length(); i++) {
                                JSONObject object = rootJsonArray.getJSONObject(i);

                                mExampleList1.add(new JobsModelName(object.optString("id"),
                                        object.optString("job_title"),
                                        object.optString("expirence"),
                                        object.optString("country"),
                                        object.optString("work_city"),
                                        object.optString("company_name"),
                                        object.optString("job_keyskill"),
                                        object.optString("job_description"),
                                        object.optString("job_postion")));

                            }

                            Log.e("rootJsonArray",mExampleList1.size()+"");

                            mExampleAdapter1 = new JobsNameAdapter(Main2Activity.this, mExampleList1);
                            mRecyclerview1.setAdapter(mExampleAdapter1);
                            mExampleAdapter1.notifyDataSetChanged();
                            mRecyclerview1.setHasFixedSize(true);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                        Log.e("TAg",error.getMessage());
                    }
                });

        mRequestQueue1 = Volley.newRequestQueue(this);
        mRequestQueue1.add(stringRequest);
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
        // as you specify a Parent activity in AndroidManifest.xml.
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
            String actname ="About Us";
            SharedPreferences pref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
            SharedPreferences.Editor edit = pref.edit();

            edit.putString("Actvname",actname);

            edit.commit();

            startActivity(new Intent(Main2Activity.this,AboutUsActivity.class));
        } else if (id == R.id.nav_subsc) {

            String actname ="Subscribe";
            SharedPreferences pref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
            SharedPreferences.Editor edit = pref.edit();

            edit.putString("Actvname",actname);

            edit.commit();
            startActivity(new Intent(Main2Activity.this, SubscribeActivity.class));
        } else if (id == R.id.nav_profile) {
                startActivity(new Intent(Main2Activity.this,MyProfileActivity.class));
            }
         else if (id == R.id.nav_login) {
            startActivity(new Intent(Main2Activity.this,LoginActivity.class));

        } else if (id == R.id.nav_contactus) {

            String actname ="Contact Us";
            SharedPreferences pref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
            SharedPreferences.Editor edit = pref.edit();

            edit.putString("Actvname",actname);

            edit.commit();
            startActivity(new Intent(Main2Activity.this,ContactUsActivity.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }




}
