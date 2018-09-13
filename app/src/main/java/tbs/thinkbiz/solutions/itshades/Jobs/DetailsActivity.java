package tbs.thinkbiz.solutions.itshades.Jobs;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import tbs.thinkbiz.solutions.itshades.R;

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
        getSupportActionBar().setCustomView(tbs.thinkbiz.solutions.itshades.R.layout.backbar);
        View view =getSupportActionBar().getCustomView();

        ImageButton imageButton= (ImageButton)view.findViewById(tbs.thinkbiz.solutions.itshades.R.id.action_bar_back);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

//        discla=(TextView)findViewById(R.id.textdesc);
//        termsndcond=(TextView)findViewById(R.id.texttnc);
//        prvynspolcy=(TextView)findViewById(R.id.textpnp);


        textViewTitle = (TextView)findViewById(tbs.thinkbiz.solutions.itshades.R.id.textvpost);
        textViewexp = (TextView)findViewById(tbs.thinkbiz.solutions.itshades.R.id.textyrs);
        textViewcontry = (TextView)findViewById(tbs.thinkbiz.solutions.itshades.R.id.textcontry);
        textViewloc =(TextView)findViewById(tbs.thinkbiz.solutions.itshades.R.id.textlocation);
        textViewcmpname = (TextView)findViewById(tbs.thinkbiz.solutions.itshades.R.id.compnm);
        textViewkeyskills = (TextView)findViewById(tbs.thinkbiz.solutions.itshades.R.id.kskls);
        textViewjobdesc = (TextView)findViewById(tbs.thinkbiz.solutions.itshades.R.id.desc);
        textViewexplevel = (TextView)findViewById(tbs.thinkbiz.solutions.itshades.R.id.explevl);



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
        textname=(TextView)findViewById(tbs.thinkbiz.solutions.itshades.R.id.textname);
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
