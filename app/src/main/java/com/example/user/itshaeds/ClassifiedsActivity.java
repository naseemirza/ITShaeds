package com.example.user.itshaeds;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;

public class ClassifiedsActivity extends AppCompatActivity {

    private Spinner spiner1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classifieds);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.classifiedsbar);
        View view =getSupportActionBar().getCustomView();

        spiner1 = (Spinner) findViewById(R.id.spinner3);
        String[] users = new String[]{
                "--Select Classified Types--",
                "Offerings",
                "Promotions",
                "Other"
        };

        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
                this,R.layout.spinneritems,users
        );
        spinnerArrayAdapter.setDropDownViewResource(R.layout.spinneritems);
        spiner1.setAdapter(spinnerArrayAdapter);


        ImageButton imageButton= (ImageButton)view.findViewById(R.id.action_bar_back);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
