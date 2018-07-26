package com.example.user.itshaeds;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;

public class SolutionsActivity extends AppCompatActivity {

    private Spinner spiner1,spiner2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solutions);



        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.solution_action_bar_layout);
        View view =getSupportActionBar().getCustomView();


        spiner1 = (Spinner) findViewById(R.id.spinner1);
        String[] users = new String[]{
                "Access Level",
                "Individual User",
                "Corparate"
        };

        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
                this,R.layout.spinneritems,users
        );
        spinnerArrayAdapter.setDropDownViewResource(R.layout.spinneritems);
        spiner1.setAdapter(spinnerArrayAdapter);


        spiner2 = (Spinner) findViewById(R.id.spinner2);
        String[] users2 = new String[]{
                "Access Level",
                "Individual User",
                "Corparate"
        };

        ArrayAdapter<String> spinnerArrayAdapter2 = new ArrayAdapter<String>(
                this,R.layout.spinneritems,users2
        );
        spinnerArrayAdapter.setDropDownViewResource(R.layout.spinneritems);
        spiner2.setAdapter(spinnerArrayAdapter2);


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
                //startActivity(new Intent(JobsActivity.this,FilterActivity.class));
            }
        });

    }
    }

