package tbs.thinkbiz.solutions.itshades;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import tbs.thinkbiz.solutions.itshades.CorpCustomer.CorpMainActivity;
import tbs.thinkbiz.solutions.itshades.MainPageTab.MainPageActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Spinner spiner;
    private Button buttonLogin;
    private TextView reg, forgotpass;

    EditText editTextpass, editTextmail;
    final Context context = this;
    ProgressDialog progressDialog;
    public static String Uroll; //, uroll;
    RadioGroup radioGroup;
    RadioButton radioButton;

  public static Boolean booltype;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextmail = (EditText) findViewById(R.id.editTextU);
        editTextpass = (EditText) findViewById(R.id.editTextP);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioButton = (RadioButton) findViewById(R.id.rb1);

        SharedPreferences pref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
          booltype=pref.getBoolean("Booltype", Boolean.parseBoolean(""));
          Uroll = pref.getString("uroll", "");

          // Log.e("url",uroll);

        if(booltype){

            if (Uroll.equals("1")) {
                startActivity(new Intent(LoginActivity.this, MainPageActivity.class));
                finish();
            }
           else if (Uroll.equals("2")) {
                startActivity(new Intent(LoginActivity.this, CorpMainActivity.class));
                finish();
            }
           // finish();   //finish current activity
        }


        forgotpass = (TextView) findViewById(R.id.textViewfrgt);

        forgotpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String actname="Forgot Password";
                SharedPreferences pref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = pref.edit();
                edit.putString("Actvname",actname);

                edit.apply();
                Intent intent = new Intent(LoginActivity.this, ForgotPassActivity.class);
                startActivity(intent);
            }
        });

        reg = (TextView) findViewById(R.id.textViewRgs);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String actname="Register Here";
                SharedPreferences pref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = pref.edit();

                edit.putString("Actvname",actname);
                edit.apply();
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        buttonLogin = (Button) findViewById(R.id.buttonL);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isOnline()) {
                    //do whatever you want to do
                } else {
                    try {
                        android.app.AlertDialog alertDialog = new android.app.AlertDialog.Builder(LoginActivity.this).create();

                        alertDialog.setTitle("Info");
                        alertDialog.setMessage("Internet not available, Cross check your internet connectivity and try again");
                        alertDialog.setIcon(R.drawable.ic_warning_black_24dp);
                        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
//                        finish();
                                startActivity(new Intent(LoginActivity.this,LoginActivity.class));

                            }
                        });

                        alertDialog.show();
                    } catch (Exception e) {
                        //Log.d(SyncStateContract.Constants.TAG, "Show Dialog: " + e.getMessage());
                    }
                }

                if(isValidate())
                {
                    Loginbtn();
                }

//                Intent intent=new Intent(LoginActivity.this,Main2Activity.class);
//                startActivity(intent);

//                Intent intent=new Intent(LoginActivity.this,CorpMainActivity.class);
//                startActivity(intent);

            }
        });


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.colorBlack));
        toggle.syncState();


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public boolean isOnline() {
        ConnectivityManager conMgr = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = conMgr.getActiveNetworkInfo();

        if(netInfo == null || !netInfo.isConnected() || !netInfo.isAvailable()){
            // Toast.makeText(this, "No Internet connection!", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

    private boolean isValidate()
    {
        final String email = editTextmail.getText().toString().trim();
        //int pos =spiner.getSelectedItemPosition();

                if (TextUtils.isEmpty(email)) {
                    editTextmail.setError("Please enter your email");
                    editTextmail.requestFocus();
                    return false;
                }

                if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    editTextmail.setError("Enter a valid email");
                    editTextmail.requestFocus();
                    return false;
                }

                if (editTextpass.getText().toString().length() == 0) {
                    editTextpass.setError("Password not entered");
                    editTextpass.requestFocus();
                    return false;
                }
                if (editTextpass.getText().toString().length() < 5) {
                    editTextpass.setError("Password should be atleast of 6 charactors");
                    editTextpass.requestFocus();
                    return false;
                }
        if (radioGroup.getCheckedRadioButtonId() == -1) {
            radioButton.setError("Please select one option");
            radioGroup.requestFocus();
            return false;
        }

                return true;
    }

    private void Loginbtn() {

        progressDialog = new ProgressDialog(LoginActivity.this);
        progressDialog.setMessage("Signing In...");
        progressDialog.show();

        final String email = editTextmail.getText().toString().trim();
        final String password = editTextpass.getText().toString().trim();
        final String usertype = ((RadioButton) findViewById(radioGroup.getCheckedRadioButtonId())).getText().toString();

        if (usertype.equals("Individual User"))
        {
            Uroll="1";
        }
        else if (usertype.equals("Business User")){
            Uroll="2";
        }

        Log.e("resp", Uroll);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, AllUrls.LOGIN_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Log.e("resp", response);
                        progressDialog.dismiss();

                        try {
                            JSONObject obj = new JSONObject(response);
                            String success= obj.getString("s");
                            String error= obj.getString("e");
                            String msg=obj.getString("m");
                            String uid=obj.getString("userid");

                            Log.e("resp", uid);

                            if (success.equalsIgnoreCase("1"))
                            {
                                if (Uroll.equals("1")){

                                    booltype=true;
                                    SharedPreferences pref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                                        SharedPreferences.Editor edit = pref.edit();
                                        edit.putString("Username", usertype);
                                        edit.putString("userid", uid);
                                        edit.putString("uroll", Uroll);
                                        edit.putBoolean("Booltype",booltype);
                                        Toast.makeText(LoginActivity.this, msg, Toast.LENGTH_SHORT).show();
                                        progressDialog.dismiss();
                                        edit.apply();                                                     //Main2Activity
                                        Intent intent = new Intent(LoginActivity.this, MainPageActivity.class);
                                        startActivity(intent);
                                        editTextmail.setText("");
                                        editTextpass.setText("");
                                        radioGroup.clearCheck();
                                }

                             else if (Uroll.equals("2")){
                                     booltype=true;
                                    SharedPreferences pref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                                    SharedPreferences.Editor edit = pref.edit();
                                    edit.putString("Username",usertype);
                                    edit.putString("userid",uid);
                                    edit.putString("uroll", Uroll);
                                    edit.putBoolean("Booltype",booltype);
                                Toast.makeText(LoginActivity.this, msg, Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                                    edit.apply();
                                Intent intent=new Intent(LoginActivity.this,CorpMainActivity.class);
                                startActivity(intent);
                                editTextmail.setText("");
                                editTextpass.setText("");
                                    radioGroup.clearCheck();
                            }
                            }
                            else
                            {
                                Toast.makeText(LoginActivity.this, msg, Toast.LENGTH_SHORT).show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(LoginActivity.this,e.getMessage(), Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(LoginActivity.this, "error" + error.getMessage(), Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                    }
                }) {
            @Override

            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("username", email);
                params.put("password", password);
                params.put("job", Uroll);
                return params;
            }
        };

        RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
        queue.add(stringRequest);
    }

    @Override
    public void onBackPressed() {
       // finish();
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
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_aboutus) {
            startActivity(new Intent(LoginActivity.this,AboutUsActivity.class));
        }

        else if (id == R.id.nav_login) {
            startActivity(new Intent(LoginActivity.this,LoginActivity.class));

        } else if (id == R.id.nav_contactus) {
            startActivity(new Intent(LoginActivity.this,ContactUsActivity.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
