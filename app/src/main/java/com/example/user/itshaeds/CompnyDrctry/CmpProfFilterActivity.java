package com.example.user.itshaeds.CompnyDrctry;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.example.user.itshaeds.FilterActivity;
import com.example.user.itshaeds.JobsActivity;
import com.example.user.itshaeds.R;

public class CmpProfFilterActivity extends AppCompatActivity {

    private Spinner spinerFA,spinerInd,spinerOffrng,spinerCntry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cmp_prof_filter);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.cmprofilefilterbar);
        View view =getSupportActionBar().getCustomView();

        ImageButton imageButton= (ImageButton)view.findViewById(R.id.action_bar_back);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



        spinerCntry = (Spinner) findViewById(R.id.spinnerCntry);
        String[] users3 = new String[]{
                "--Select Country--",
                "Afganistan",
                "Albania",
                "India"
        };
        ArrayAdapter<String> spinnerArrayAdapter3 = new ArrayAdapter<String>(
                this,R.layout.spinneritems,users3
        );
        spinnerArrayAdapter3.setDropDownViewResource(R.layout.spinneritems);
        spinerCntry.setAdapter(spinnerArrayAdapter3);



        spinerInd = (Spinner) findViewById(R.id.spinnerInd);
        String[] users1 = new String[]{
                "--Select Industry--",
                "All Industries",
                "Airlines"
        };
        ArrayAdapter<String> spinnerArrayAdapter1 = new ArrayAdapter<String>(
                this,R.layout.spinneritems,users1
        );
        spinnerArrayAdapter1.setDropDownViewResource(R.layout.spinneritems);
        spinerInd.setAdapter(spinnerArrayAdapter1);


        spinerFA = (Spinner) findViewById(R.id.spinnerFocsarea);
        String[] usersfa = new String[]{
                "--Select Focus Area--",
                "Agile",
                "Analytics",
                "Application Development"
        };
        ArrayAdapter<String> spinnerArrayAdapterfa = new ArrayAdapter<String>(
                this,R.layout.spinneritems,usersfa
        );
        spinnerArrayAdapterfa.setDropDownViewResource(R.layout.spinneritems);
        spinerFA.setAdapter(spinnerArrayAdapterfa);


        spinerOffrng = (Spinner) findViewById(R.id.spinneroffrng);
        String[] usersoff = new String[]{
                "--Select Offerings--",
                "IT Services",
                "IT Projects",
                "Platforms",
                "Applications",
                "Software",
                "Hardware",
                "Training",
                "Marketing",
                "Content Writing",
                "Recruitment",
                "Immigration",
                "Event"
        };
        ArrayAdapter<String> spinnerArrayAdapteroff = new ArrayAdapter<String>(
                this,R.layout.spinneritems,usersoff
        );
        spinnerArrayAdapteroff.setDropDownViewResource(R.layout.spinneritems);
        spinerOffrng.setAdapter(spinnerArrayAdapteroff);

    }
}
