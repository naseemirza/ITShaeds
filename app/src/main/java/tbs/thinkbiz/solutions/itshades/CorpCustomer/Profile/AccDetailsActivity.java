package tbs.thinkbiz.solutions.itshades.CorpCustomer.Profile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import tbs.thinkbiz.solutions.itshades.R;

public class AccDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acc_details);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}