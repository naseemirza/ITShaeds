package com.example.user.itshaeds.Jobs;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.user.itshaeds.PrevayActivity;
import com.example.user.itshaeds.R;
import com.example.user.itshaeds.TermsActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DetailsActivity extends AppCompatActivity {

    TextView discla,termsndcond,prvynspolcy;

    TextView textViewTitle;
    TextView textViewexp;
    TextView textViewcontry;
    TextView textViewloc;
    TextView textViewcmpname;
    TextView textViewkeyskills;
    TextView textViewjobdesc;
    TextView textViewexplevel;

    String Actname;
    TextView textname;

    String title,exp,country,loc,cmpname,keyskills,jobdesc,explevel;

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

//        discla=(TextView)findViewById(R.id.textdesc);
//        termsndcond=(TextView)findViewById(R.id.texttnc);
//        prvynspolcy=(TextView)findViewById(R.id.textpnp);


        textViewTitle = (TextView)findViewById(R.id.textvpost);
        textViewexp = (TextView)findViewById(R.id.textyrs);
        textViewcontry = (TextView)findViewById(R.id.textcontry);
        textViewloc =(TextView)findViewById(R.id.textlocation);
        textViewcmpname = (TextView)findViewById(R.id.compnm);
        textViewkeyskills = (TextView)findViewById(R.id.kskls);
        textViewjobdesc = (TextView)findViewById(R.id.desc);
        textViewexplevel = (TextView)findViewById(R.id.explevl);



        SharedPreferences pref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        title = pref.getString("Title", "");
        exp = pref.getString("Exp", "");
        country = pref.getString("Country", "");
        loc = pref.getString("Loc", "");
        cmpname = pref.getString("Cmpname", "");
        keyskills = pref.getString("Keyskills", "");
        jobdesc = pref.getString("Jobdesc", "");
        explevel = pref.getString("ExpLevel", "");


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


//        discla.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(Main2Activity.this,DisclaierActivity.class));
//            }
//        });

//        termsndcond.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(DetailsActivity.this,TermsActivity.class));
//            }
//        });

//        prvynspolcy.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(DetailsActivity.this,PrevayActivity.class));
//            }
//        });
//

    }

}
