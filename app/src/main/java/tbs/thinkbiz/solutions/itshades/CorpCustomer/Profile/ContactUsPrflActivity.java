package tbs.thinkbiz.solutions.itshades.CorpCustomer.Profile;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import tbs.thinkbiz.solutions.itshades.R;

public class ContactUsPrflActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinerr;
    private EditText editTextcmpname,editTextcmpmail,editTextcmpphone,editTextcmpmsg;
    private Button buttonsendmail;
    String Actname ;
    TextView textname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us_prfl);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.backbar);
        View view =getSupportActionBar().getCustomView();

        ImageButton imageButton= (ImageButton)view.findViewById(R.id.action_bar_back);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        SharedPreferences pref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        Actname=pref.getString("Actvname","");

        textname=(TextView)findViewById(R.id.textname);
        textname.setText(Actname);

        editTextcmpname=(EditText)findViewById(R.id.editTextadmin);
        editTextcmpmail=(EditText)findViewById(R.id.editTextmail);
        editTextcmpphone=(EditText)findViewById(R.id.editTextphone);
        editTextcmpmsg=(EditText)findViewById(R.id.editTextmsg);
        buttonsendmail=(Button)findViewById(R.id.buttonsendmail);

        spinerr = (Spinner) findViewById(R.id.spinner2);
        spinerr.setOnItemSelectedListener(this);
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
        String sp1= String.valueOf(spinerr.getSelectedItem());

        if (sp1.contentEquals("Select reason for sending email"))
        {

            editTextcmpname.setVisibility(View.GONE);
            editTextcmpmail.setVisibility(View.GONE);
            editTextcmpphone.setVisibility(View.GONE);
            editTextcmpmsg.setVisibility(View.GONE);
            buttonsendmail.setVisibility(View.GONE);

        }
        else {
            editTextcmpname.setVisibility(View.VISIBLE);
            editTextcmpmail.setVisibility(View.VISIBLE);
            editTextcmpphone.setVisibility(View.VISIBLE);
            editTextcmpmsg.setVisibility(View.VISIBLE);
            buttonsendmail.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
