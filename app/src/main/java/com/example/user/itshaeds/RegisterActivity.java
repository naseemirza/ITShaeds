package com.example.user.itshaeds;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {

    Button button;
    EditText editTextfnm,editTextlnm,editTextpass,editTextconfpass,editTextmail;
    String edtfnm,edtlnm,edtmail,edtps,edtcnfpas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getSupportActionBar().setTitle(" Register Here ");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        editTextfnm=(EditText)findViewById(R.id.editTextfnm);
        editTextlnm=(EditText)findViewById(R.id.editTextlnm);
        editTextmail=(EditText)findViewById(R.id.editTextemail);
        editTextpass=(EditText)findViewById(R.id.editTextps);
        editTextconfpass=(EditText)findViewById(R.id.editTextps1);

        button=(Button)findViewById(R.id.button_regs);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               edtfnm=editTextfnm.getText().toString();
                edtlnm=editTextlnm.getText().toString();
                edtmail=editTextmail.getText().toString();
                edtps=editTextpass.getText().toString();
                edtcnfpas=editTextconfpass.getText().toString();

//                if ((TextUtils.isEmpty(edtfnm))&&(TextUtils.isEmpty(edtlnm))
//                        &&(TextUtils.isEmpty(edtmail)&& Patterns.EMAIL_ADDRESS.matcher(edtmail).matches())
//                        &&(TextUtils.isEmpty(edtps))&&(TextUtils.isEmpty(edtcnfpas)))
//                {
//                    Toast.makeText(RegisterActivity.this,"Please enter details in all fields",Toast.LENGTH_LONG).show();
//                }
//                else {
                    startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                //}
            }
        });

    }
}
