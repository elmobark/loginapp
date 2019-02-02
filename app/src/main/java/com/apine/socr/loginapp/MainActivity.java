package com.apine.socr.loginapp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private FloatingActionButton fap;
    private TextInputLayout userLayout,PassLayout;
    private TextView Singup,Recovery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        
super.onCreate(savedInstanceState);        
setContentView(R.layout.activity_main);
        initializ();
int x = sum (2, 3);

        fap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (userLayout.getEditText().getText().toString().equals("")) {
                    userLayout.getEditText().setError("لا يمكن ترك هذا الحقل فارغاً");
                }else if(PassLayout.getEditText().getText().toString().equals("")){
                    PassLayout.getEditText().setError("لا يمكن ترك هذا الحقل فارغاً");
                }else{
                    if(new AppUserControl(MainActivity.this).isRegisterted(userLayout.getEditText().getText().toString(),PassLayout.getEditText().getText().toString())){
                        Intent in = new Intent(MainActivity.this,WelcomeActivity.class);
                        in.putExtra(appSettings.IUN,userLayout.getEditText().getText().toString());
                        startActivity(in);
                        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                        finish();
                    }else{
                        Snackbar.make(view,"تأكد من كلمة السر او اسم المستخدم",Snackbar.LENGTH_LONG).show();
                    }
                }
            }
        });
        Singup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in =new Intent(MainActivity.this,SingupActivity.class);
                startActivity(in);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                finish();
            }
        });
    }
    public void initializ(){
        fap=(FloatingActionButton) findViewById(R.id.loginFAP);
        userLayout=(TextInputLayout)findViewById(R.id.usernameLayout);
        PassLayout=(TextInputLayout)findViewById(R.id.passkeylayout);
        Singup=(TextView)findViewById(R.id.SingupTV);
        Recovery=(TextView)findViewById(R.id.RecoveryTV);
    }

public void sum (int x, int y){
return x + y;
}

}
