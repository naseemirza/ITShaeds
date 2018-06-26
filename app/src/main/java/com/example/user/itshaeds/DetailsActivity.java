package com.example.user.itshaeds;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    TextView textViewpost,textViewexp,textViewloc;
    String textpost,textexp,textloc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        textViewpost=(TextView)findViewById(R.id.textvpost);
        textViewexp=(TextView)findViewById(R.id.textyrs);
        textViewloc=(TextView)findViewById(R.id.textlocation);

        Intent intent = getIntent();
        Bundle bd = intent.getExtras();
        if(bd != null)
        {
            String getpost = (String) bd.get("postname");
            textViewpost.setText(getpost);
            String getexp = (String) bd.get("exp");
            textViewexp.setText(getexp);
            String getloc = (String) bd.get("location");
            textViewloc.setText(getloc);
        }



    }
}
