package com.example.authenticationdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    EditText email,pass;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        email=findViewById(R.id.email);
        pass=findViewById(R.id.password);
        auth=FirebaseAuth.getInstance();
    }

    public void register(View view) {
       String uemail=email.getText().toString();
       String upass=pass.getText().toString();
       if(uemail.isEmpty()||upass.isEmpty())
           Toast.makeText(this, "please fill all details", Toast.LENGTH_SHORT).show();
       else if(upass.length()<6)
           Toast.makeText(this, "passwor must be greater than 5 characters", Toast.LENGTH_SHORT).show();
       else{
           auth.createUserWithEmailAndPassword(uemail,upass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
               @Override
               public void onComplete(@NonNull Task<AuthResult> task) {
                   if(task.isSuccessful())
                       Toast.makeText(RegisterActivity.this, "succesfully registered", Toast.LENGTH_SHORT).show();
                   else
                       Toast.makeText(RegisterActivity.this, "Failed to register", Toast.LENGTH_SHORT).show();
               }
           });
       }
    }
}

