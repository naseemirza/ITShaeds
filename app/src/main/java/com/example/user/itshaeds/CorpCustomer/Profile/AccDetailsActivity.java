package com.example.user.itshaeds.CorpCustomer.Profile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.user.itshaeds.R;

public class AccDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acc_details);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
