package tbs.thinkbiz.solutions.itshades.CorpCustomer.Profile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import tbs.thinkbiz.solutions.itshades.R;

public class ContactUsPrflActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinerr;
    private EditText editTextcmpname,editTextcmpmail,editTextcmpphone,editTextcmpmsg;
    private Button buttonsendmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us_prfl);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        editTextcmpname=(EditText)findViewById(R.id.editTextadmin);
        editTextcmpmail=(EditText)findViewById(R.id.editTextmail);
        editTextcmpphone=(EditText)findViewById(R.id.editTextphone);
        editTextcmpmsg=(EditText)findViewById(R.id.editTextmsg);
        buttonsendmail=(Button)findViewById(R.id.buttonsendmail);

        spinerr = (Spinner) findViewById(R.id.spinner2);
        String[] users = new String[]{
                "Select reason for sending email",
                "Technical Issues",
                "Issues in Itshades.com",
                "Feedback/Suggestions",
                "Report Abuse",
                "Others"
        };

        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
                this,R.layout.spinneritems,users
        );
        spinnerArrayAdapter.setDropDownViewResource(R.layout.spinneritems);
        spinerr.setAdapter(spinnerArrayAdapter);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //String sp1= String.valueOf(spinerr.getSelectedItem());

        if (spinerr.equals("Technical Issues"))
        {

            editTextcmpname.setVisibility(View.VISIBLE);
            editTextcmpmail.setVisibility(View.VISIBLE);
            editTextcmpphone.setVisibility(View.VISIBLE);
            editTextcmpmsg.setVisibility(View.VISIBLE);
            buttonsendmail.setVisibility(View.VISIBLE);
        }
        else {
            editTextcmpname.setVisibility(View.GONE);
            editTextcmpmail.setVisibility(View.GONE);
            editTextcmpphone.setVisibility(View.GONE);
            editTextcmpmsg.setVisibility(View.GONE);
            buttonsendmail.setVisibility(View.GONE);
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
