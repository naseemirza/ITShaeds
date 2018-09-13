package tbs.thinkbiz.solutions.itshades.ITBytes;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class ITBytDetailsActivity1 extends AppCompatActivity {

    TextView textViewpost,textViewexp;
    String textpost1,textexp1;

    String Actname;
    TextView textname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(tbs.thinkbiz.solutions.itshades.R.layout.activity_itbyt_details1);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(tbs.thinkbiz.solutions.itshades.R.layout.backbar);
        View view =getSupportActionBar().getCustomView();

        ImageButton imageButton= (ImageButton)view.findViewById(tbs.thinkbiz.solutions.itshades.R.id.action_bar_back);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        textViewpost=(TextView)findViewById(tbs.thinkbiz.solutions.itshades.R.id.texthdng);
        textViewexp=(TextView)findViewById(tbs.thinkbiz.solutions.itshades.R.id.desc1);

        SharedPreferences pref = this.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        textpost1=pref.getString("Title","");
        textexp1=pref.getString("Descr","");

        textViewpost.setText(textpost1);
        textViewexp.setText(textexp1);

        Actname=pref.getString("Actvname","");
        textname=(TextView)findViewById(tbs.thinkbiz.solutions.itshades.R.id.textname);
        textname.setText(Actname);
    }
}
