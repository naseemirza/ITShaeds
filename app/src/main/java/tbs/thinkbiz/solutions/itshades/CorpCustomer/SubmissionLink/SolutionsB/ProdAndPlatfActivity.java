package tbs.thinkbiz.solutions.itshades.CorpCustomer.SubmissionLink.SolutionsB;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import tbs.thinkbiz.solutions.itshades.CorpCustomer.CorpMainActivity;
import tbs.thinkbiz.solutions.itshades.CorpCustomer.SubmissionLink.ParentActivity;
import tbs.thinkbiz.solutions.itshades.Jobs.JobsActivity;
import tbs.thinkbiz.solutions.itshades.Jobs.JobsFilterActivity;
import tbs.thinkbiz.solutions.itshades.R;

public class ProdAndPlatfActivity extends AppCompatActivity {

    String Actname;
    TextView textname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prod_and_platf);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.backandfilterbar);
        View view =getSupportActionBar().getCustomView();

        SharedPreferences pref = this.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        Actname=pref.getString("Actvname","");
        textname=(TextView)findViewById(R.id.textname);
        textname.setText(Actname);

        //ImageButton imageButton= (ImageButton)view.findViewById(R.id.action_bar_back);

//        imageButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(ParentActivity.this, CorpMainActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        });

//        ImageButton imageButton2= (ImageButton)view.findViewById(tbs.thinkbiz.solutions.itshades.R.id.action_bar_forward);
//
//        imageButton2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(JobsActivity.this,JobsFilterActivity.class));
//            }
//        });
    }
}
