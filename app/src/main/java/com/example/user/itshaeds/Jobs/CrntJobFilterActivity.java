package com.example.user.itshaeds.Jobs;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.example.user.itshaeds.R;

public class CrntJobFilterActivity extends AppCompatActivity {


    private Spinner spinerFE,spinerInd,spinerExp,spinerCntry,spinerRL;
    ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crnt_job_filter);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.crntjobfilterbar);
        View view =getSupportActionBar().getCustomView();

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        imageButton=(ImageButton)findViewById(R.id.action_bar_back);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        spinerFE = (Spinner) findViewById(R.id.spinnerFE);
        String[] users = new String[]{
                "Functiona Experties",
                "Sales",
                "Preesales"
        };

        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
                this,R.layout.spinneritems,users
        );
        spinnerArrayAdapter.setDropDownViewResource(R.layout.spinneritems);
        spinerFE.setAdapter(spinnerArrayAdapter);

        spinerInd = (Spinner) findViewById(R.id.spinnerInd);
        String[] users1 = new String[]{
                "Industry",
                "All Industries",
                "Airlines"
        };
        ArrayAdapter<String> spinnerArrayAdapter1 = new ArrayAdapter<String>(
                this,R.layout.spinneritems,users1
        );
        spinnerArrayAdapter1.setDropDownViewResource(R.layout.spinneritems);
        spinerInd.setAdapter(spinnerArrayAdapter1);


        spinerExp = (Spinner) findViewById(R.id.spinnerExp);
        String[] users2 = new String[]{
                "Exp.Year",
                "<10 years",
                "10-15 years",
                "15-20 years",
                "20+ years"
        };

        ArrayAdapter<String> spinnerArrayAdapter2 = new ArrayAdapter<String>(
                this,R.layout.spinneritems,users2
        );
        spinnerArrayAdapter2.setDropDownViewResource(R.layout.spinneritems);
        spinerExp.setAdapter(spinnerArrayAdapter2);


        spinerCntry = (Spinner) findViewById(R.id.spinnerCntry);
        String[] users3 = new String[]{
                "Country",
                "Afganistan",
                "Albania",
                "India"
        };
        ArrayAdapter<String> spinnerArrayAdapter3 = new ArrayAdapter<String>(
                this,R.layout.spinneritems,users3
        );
        spinnerArrayAdapter3.setDropDownViewResource(R.layout.spinneritems);
        spinerCntry.setAdapter(spinnerArrayAdapter3);


        spinerRL = (Spinner) findViewById(R.id.spinnerRlllvl);
        String[] users4 = new String[]{
                "Role Level",
                "Manager",
                "Director"
        };

        ArrayAdapter<String> spinnerArrayAdapter4 = new ArrayAdapter<String>(
                this,R.layout.spinneritems,users4
        );
        spinnerArrayAdapter4.setDropDownViewResource(R.layout.spinneritems);
        spinerRL.setAdapter(spinnerArrayAdapter4);
    }
}
