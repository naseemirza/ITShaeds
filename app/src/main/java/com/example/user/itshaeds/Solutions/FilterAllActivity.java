package com.example.user.itshaeds.Solutions;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.user.itshaeds.R;

public class FilterAllActivity extends AppCompatActivity {

    private Spinner spinerInd,spinerFA;
    String actname;
    TextView textactname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter_all);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.filterallbar);
        View view =getSupportActionBar().getCustomView();

        textactname=(TextView)findViewById(R.id.textactname);
        SharedPreferences pref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        actname = pref.getString("Actvtname", "");

        textactname.setText(actname);

        ImageButton imageButton= (ImageButton)view.findViewById(R.id.action_bar_back);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        spinerInd = (Spinner) findViewById(R.id.spinnerInd);
        String[] users1 = new String[]{
                "All",
                "Airlines",
                "Banking",
                "Airlines",
                "Banking",
                "Airlines",
                "Banking",
                "Airlines",
                "Banking",
                "Airlines",
                "Banking"
        };
        ArrayAdapter<String> spinnerArrayAdapter1 = new ArrayAdapter<String>(
                this,R.layout.spinneritems,users1
        );
        spinnerArrayAdapter1.setDropDownViewResource(R.layout.spinneritems);
        spinerInd.setAdapter(spinnerArrayAdapter1);


        spinerFA = (Spinner) findViewById(R.id.spinnerFocsarea);
        String[] usersfa = new String[]{
                "All",
                "Airlines",
                "Banking",
                "Airlines",
                "Banking",
                "Airlines",
                "Banking",
                "Airlines",
                "Banking",
                "Airlines",
                "Banking"
        };
        ArrayAdapter<String> spinnerArrayAdapterfa = new ArrayAdapter<String>(
                this,R.layout.spinneritems,usersfa
        );
        spinnerArrayAdapterfa.setDropDownViewResource(R.layout.spinneritems);
        spinerFA.setAdapter(spinnerArrayAdapterfa);

    }
}
