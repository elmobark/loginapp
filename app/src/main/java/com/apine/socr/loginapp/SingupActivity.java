package com.apine.socr.loginapp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SingupActivity extends AppCompatActivity {
    private TextInputLayout phone,username,email,lastname,firstname,recoverykey,password;
    private FloatingActionButton fap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);
        initilaz();
        fap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isEmpty()){
                    if(!new AppUserControl(SingupActivity.this).checkuser(username.getEditText().getText().toString())){
                        String[] data={
                                username.getEditText().getText().toString(),
                                password.getEditText().getText().toString(),
                                recoverykey.getEditText().getText().toString(),
                                firstname.getEditText().getText().toString(),
                                lastname.getEditText().getText().toString(),
                                email.getEditText().getText().toString(),
                                phone.getEditText().getText().toString()
                        };
                        new AppUserControl(SingupActivity.this).RegistertUser(data);
                        Intent in = new Intent(SingupActivity.this,ProcessActivity.class);
                        in.putExtra(appSettings.IUN,username.getEditText().getText().toString());
                        startActivity(in);
                    }else{
                        username.getEditText().setError("اسم المستخدم غير متاح");
                    }
                }
            }
        });
    }
    private void initilaz(){
        phone=(TextInputLayout)findViewById(R.id.PhoneLayout);
        username=(TextInputLayout)findViewById(R.id.usernameUPlayout);
        email=(TextInputLayout)findViewById(R.id.EmailLayout);
        lastname=(TextInputLayout)findViewById(R.id.lastnameLayout);
        firstname=(TextInputLayout)findViewById(R.id.firstnameLayout);
        recoverykey=(TextInputLayout)findViewById(R.id.recoverykeyLayout);
        password=(TextInputLayout)findViewById(R.id.passkeyUPlayout);
        fap=(FloatingActionButton)findViewById(R.id.singupFAP);
    }
    public boolean isEmpty(){
        if(phone.getEditText().getText().toString().equals("") ||username.getEditText().getText().toString().equals("")
                || email.getEditText().getText().toString().equals("") ||lastname.getEditText().getText().toString().equals("")
                || firstname.getEditText().getText().toString().equals("") ||recoverykey.getEditText().getText().toString().equals("")
                ||password.getEditText().getText().toString().equals("")) {
            if (phone.getEditText().getText().toString().equals(""))
                phone.getEditText().setError("لا يمكنك ترك هذا الحقل فارغاً");
            if (username.getEditText().getText().toString().equals(""))
                username.getEditText().setError("لا يمكنك ترك هذا الحقل فارغاً");
            if (email.getEditText().getText().toString().equals(""))
                email.getEditText().setError("لا يمكنك ترك هذا الحقل فارغاً");
            if (lastname.getEditText().getText().toString().equals(""))
                lastname.getEditText().setError("لا يمكنك ترك هذا الحقل فارغاً");
            if (firstname.getEditText().getText().toString().equals(""))
                firstname.getEditText().setError("لا يمكنك ترك هذا الحقل فارغاً");
            if (recoverykey.getEditText().getText().toString().equals(""))
                recoverykey.getEditText().setError("لا يمكنك ترك هذا الحقل فارغاً");
            if (password.getEditText().getText().toString().equals(""))
                password.getEditText().setError("لا يمكنك ترك هذا الحقل فارغاً");
                return true;
        }else return false;
    }
}
