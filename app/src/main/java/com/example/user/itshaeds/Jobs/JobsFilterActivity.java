package com.example.user.itshaeds.Jobs;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.example.user.itshaeds.CompnyDrctry.CmpDirectoryActivity;
import com.example.user.itshaeds.CompnyDrctry.CmpProfFilterActivity;
import com.example.user.itshaeds.R;

public class JobsFilterActivity extends AppCompatActivity {

    private Spinner spinerrl,spinercntry,spinercrntcntry;

    //ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jobs_filter);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.jobsfilterbar);
        View view =getSupportActionBar().getCustomView();

        ImageButton imageButton= (ImageButton)view.findViewById(R.id.action_bar_back);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ImageButton imageButton2= (ImageButton)view.findViewById(R.id.action_bar_forward);

        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(JobsFilterActivity.this,CmpProfFilterActivity.class));
            }
        });

        spinerrl = (Spinner) findViewById(R.id.spinnerRolllevel);
        String[] users = new String[]{
                "Access Level",
                "Individual User",
                "Corparate"
        };

        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
                this,R.layout.spinneritems,users
        );
        spinnerArrayAdapter.setDropDownViewResource(R.layout.spinneritems);
        spinerrl.setAdapter(spinnerArrayAdapter);

        spinercntry = (Spinner) findViewById(R.id.spinnercntry);
        String[] users1 = new String[]{
                "Access Level",
                "Individual User",
                "Corparate"
        };

        ArrayAdapter<String> spinnerArrayAdapter1 = new ArrayAdapter<String>(
                this,R.layout.spinneritems,users1
        );
        spinnerArrayAdapter1.setDropDownViewResource(R.layout.spinneritems);
        spinercntry.setAdapter(spinnerArrayAdapter1);

        spinercrntcntry = (Spinner) findViewById(R.id.spinnercrntcntry);
        String[] users2 = new String[]{
                "Access Level",
                "Individual User",
                "Corparate"
        };

        ArrayAdapter<String> spinnerArrayAdapter2 = new ArrayAdapter<String>(
                this,R.layout.spinneritems,users2
        );
        spinnerArrayAdapter2.setDropDownViewResource(R.layout.spinneritems);
        spinercrntcntry.setAdapter(spinnerArrayAdapter2);

    }
}
