package com.example.loginapi1;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView CNIC,password;
    Button btnlgn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CNIC =findViewById(R.id.CNIC);
        password= findViewById(R.id.password);
        btnlgn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(CNIC.getText().toString()) ||
                        (TextUtils.isEmpty(password.getText().toString()))){
                    Toast.makeText(MainActivity.this, "cnic/password Required", Toast.LENGTH_LONG).show();

                } else{
                    //proceed to login}
                    login();
            }}
        });
    }

    private void login() {
        LoginRequest loginrequest=new LoginRequest();
        loginrequest.setCNIC(CNIC.getText().toString());
        loginrequest.setPassword(password.getText().toString());
            Call<ModelClass> ModelClassCall=APIInterface.userlogin(loginrequest);
            ModelClassCall.enqueue(new Callback<ModelClass>() {
                @Override
                public void onResponse(Call<ModelClass> call, Response<ModelClass> response) {
                    if(response.isSuccessful()){
                        Toast.makeText(MainActivity.this, "login successfull", Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(MainActivity.this, "login failed", Toast.LENGTH_LONG).show();
                    }

                }

                @Override
                public void onFailure(Call<ModelClass> call, Throwable t) {
                    Toast.makeText(MainActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

                }
            });

    }
}