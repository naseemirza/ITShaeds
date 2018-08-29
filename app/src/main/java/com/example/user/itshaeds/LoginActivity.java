package com.example.user.itshaeds;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
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
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
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
import com.example.user.itshaeds.CorpCustomer.CorpMainActivity;
import com.example.user.itshaeds.ITBytes.ITBytDetailsActivity1;

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
    private static String LGN_URL = "https://www.itshades.com/appwebservices/login.php";
    final Context context = this;
    ProgressDialog progressDialog;
    String userrole;

    int success;
    int error;
    String msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextmail = (EditText) findViewById(R.id.editTextU);
        editTextpass = (EditText) findViewById(R.id.editTextP);

        forgotpass = (TextView) findViewById(R.id.textViewfrgt);

        forgotpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String actname="Forgot Password";
                SharedPreferences pref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = pref.edit();

                edit.putString("Actvname",actname);

                edit.commit();
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

                edit.commit();
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });


        spiner = (Spinner) findViewById(R.id.spinner);
        String[] users = new String[]{
                "Select Access Level",
                "Individual User",
                "Corporate Customer"
        };

        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
                this, R.layout.spinneritems, users
        );
        spinnerArrayAdapter.setDropDownViewResource(R.layout.spinneritems);
        spiner.setAdapter(spinnerArrayAdapter);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        buttonLogin = (Button) findViewById(R.id.buttonL);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(LoginActivity.this,Main2Activity.class);
                startActivity(intent);

//                Intent intent=new Intent(LoginActivity.this,CorpMainActivity.class);
//                startActivity(intent);

//                final String email = editTextmail.getText().toString().trim();
//
//                if (TextUtils.isEmpty(email)) {
//                    editTextmail.setError("Please enter your email");
//                    editTextmail.requestFocus();
//                }
//
//                if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
//                    editTextmail.setError("Enter a valid email");
//                    editTextmail.requestFocus();
//                }
//
//                if (editTextpass.getText().toString().length() == 0) {
//                    editTextpass.setError("Password not entered");
//                    editTextpass.requestFocus();
//                }
//                if (editTextpass.getText().toString().length() < 6) {
//                    editTextpass.setError("Password should be atleast of 6 charactors");
//                    editTextpass.requestFocus();
//                } else {
//
//                    Loginbtn();
//                }

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

    private void Loginbtn() {

        progressDialog = new ProgressDialog(LoginActivity.this);
        progressDialog.setMessage("Signing In...");
        progressDialog.show();

        final String email = editTextmail.getText().toString().trim();
        final String password = editTextpass.getText().toString().trim();
        final String usertype = spiner.getSelectedItem().toString();

        if (usertype.equals("Individual User")) {
            userrole = "1";
        } else if (usertype.equals("Corporate Customer")) {
            userrole = "2";
        }

        Log.e("resp", userrole);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, LGN_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("resp", response);
                        progressDialog.dismiss();

                        try {
                            JSONObject obj = new JSONObject(response);
                            success= Integer.parseInt(((obj.getString("s"))));
                            Log.e("succes", String.valueOf(success));
                            error= Integer.parseInt(((obj.getString("e"))));
                            msg=obj.getString("m");
                            if (success==1)
                            {
                                    Toast.makeText(LoginActivity.this, msg, Toast.LENGTH_SHORT).show();
                                     progressDialog.dismiss();
                                    Intent intent=new Intent(LoginActivity.this,Main2Activity.class);
                                     startActivity(intent);
                                editTextmail.setText("");
                                editTextpass.setText("");
                            }
                            else if(success==0)
                            {
                                Toast.makeText(LoginActivity.this, msg, Toast.LENGTH_SHORT).show();
                                //Toast.makeText(LoginActivity.this, "Invalid User", Toast.LENGTH_SHORT).show();
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
                params.put("job", userrole);
                return params;
            }
        };

        RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
        queue.add(stringRequest);
    }


//    public void SetError(String errorMessage)
//    {
//        View view = spiner.getSelectedView();
//
//        // Set TextView in Secondary Unit spinner to be in error so that red (!) icon
//        // appears, and then shake control if in error
//        TextView tvListItem = (TextView)view;
//
//        // Set fake TextView to be in error so that the error message appears
//        TextView tvInvisibleError = (TextView)findViewById(R.id.tvInvisibleError);
//
//        // Shake and set error if in error state, otherwise clear error
//        if(errorMessage != null)
//        {
//            tvListItem.setError(errorMessage);
//            tvListItem.requestFocus();
//
//            // Shake the spinner to highlight that current selection
//            // is invalid -- SEE COMMENT BELOW
//            //Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake);
//            //spiner.startAnimation(shake);
//
//            tvInvisibleError.requestFocus();
//            tvInvisibleError.setError(errorMessage);
//        }
//        else
//        {
//            tvListItem.setError(null);
//            tvInvisibleError.setError(null);
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
        getMenuInflater().inflate(R.menu.main, menu);
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

        if (id == R.id.nav_aboutus) {
            startActivity(new Intent(LoginActivity.this,AboutUsActivity.class));
        } else if (id == R.id.nav_subsc) {
            startActivity(new Intent(LoginActivity.this,SubscribeActivity.class));
        } else if (id == R.id.nav_login) {
            startActivity(new Intent(LoginActivity.this,LoginActivity.class));

        } else if (id == R.id.nav_contactus) {
            startActivity(new Intent(LoginActivity.this,ContactUsActivity.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
