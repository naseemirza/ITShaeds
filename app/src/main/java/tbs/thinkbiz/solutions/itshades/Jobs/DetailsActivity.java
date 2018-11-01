package tbs.thinkbiz.solutions.itshades.Jobs;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.VolleyError;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.android.volley.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import tbs.thinkbiz.solutions.itshades.R;

public class DetailsActivity extends AppCompatActivity {

    TextView textViewTitle;
    TextView textViewexp;
    TextView textViewcontry;
    TextView textViewloc;
    TextView textViewcmpname;
    TextView textViewkeyskills;
    TextView textViewjobdesc;
    TextView textViewexplevel;

    String Actname,jobaply;
    TextView textname;
    Button BtnAply;

    String title,exp,country,loc,cmpname,keyskills,jobdesc,explevel;
    String jobid,uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.backbar);
        View view =getSupportActionBar().getCustomView();

        ImageButton imageButton= (ImageButton)view.findViewById(R.id.action_bar_back);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        textViewTitle = (TextView)findViewById(R.id.textvpost);
        textViewexp = (TextView)findViewById(R.id.textyrs);
        textViewcontry = (TextView)findViewById(R.id.textcontry);
        textViewloc =(TextView)findViewById(R.id.textlocation);
        textViewcmpname = (TextView)findViewById(R.id.compnm);
        textViewkeyskills = (TextView)findViewById(R.id.kskls);
        textViewjobdesc = (TextView)findViewById(R.id.desc);
        textViewexplevel = (TextView)findViewById(R.id.explevl);


        SharedPreferences pref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        jobid = pref.getString("ID", "");
        uid = pref.getString("UserId", "");
        title = pref.getString("Title", "");
        exp = pref.getString("Exp", "");
        country = pref.getString("Country", "");
        loc = pref.getString("Loc", "");
        cmpname = pref.getString("Cmpname", "");
        keyskills = pref.getString("Keyskills", "");
        jobdesc = pref.getString("Jobdesc", "");
        explevel = pref.getString("ExpLevel", "");
        jobaply = pref.getString("JobAply", "");


        Log.e("jobis", exp);
        Log.e("userid", uid);

        Actname=pref.getString("Actvname","");
        textname=(TextView)findViewById(R.id.textname);
        textname.setText(Actname);


        textViewTitle.setText(title);
        textViewexp.setText(exp);
        textViewcontry.setText(country);
        textViewloc.setText(loc);
        textViewcmpname.setText(cmpname);
        textViewkeyskills.setText(keyskills);
        textViewjobdesc.setText(jobdesc);
        textViewexplevel.setText(explevel);

        BtnAply=(Button)findViewById(R.id.btnapply);
        BtnAply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BtnAply.setText("Applied");
                BtnAply.setBackgroundResource(R.drawable.aftrapplybtn);

                JobApply();

                Log.e("userid", jobaply);

            }
        });

    }

    private void JobApply() {

        StringRequest stringRequest = new StringRequest(Request.Method.POST,"https://www.itshades.com/appwebservices/job-apply.php?uid="+uid+"&job_id="+jobid,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("resp",response);
                        //progressDialog.dismiss();
                        try {
                            JSONObject obj = new JSONObject(response);
                            String success= obj.getString("s");
                            String error= obj.getString("e");
                            String msg=obj.getString("m");

                            if (success.equalsIgnoreCase("1")) {

                                Toast.makeText(DetailsActivity.this, msg, Toast.LENGTH_SHORT).show();
                            }
                            else {
                            Toast.makeText(DetailsActivity.this, msg, Toast.LENGTH_SHORT).show();
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                        Toast.makeText(DetailsActivity.this,e.getMessage(), Toast.LENGTH_SHORT).show();
                        //progressDialog.dismiss();
                    }
                }
    },
            new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Toast.makeText(DetailsActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            // progressDialog.dismiss();
        }
    })
       {
    };

    RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }
}
