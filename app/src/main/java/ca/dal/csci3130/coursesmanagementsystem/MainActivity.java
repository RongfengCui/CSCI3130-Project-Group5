package ca.dal.csci3130.coursesmanagementsystem;

import android.app.ProgressDialog;
import android.icu.util.Freezable;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editTextemail;
    private EditText editTextPassowrd;
    private TextView textViewSignin;
    private Button buttonRegister;

    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    progressDialog = new ProgressDialog(this);
    firebaseAuth = FirebaseAuth.getInstance();


        buttonRegister = (Button) findViewById(R.id.buttonRegister);
    editTextemail = (EditText)findViewById(R.id.editTextEmail);
    editTextPassowrd=(EditText)findViewById(R.id.editTextPassword);
    textViewSignin = (TextView)findViewById(R.id.textViewSignin);
    buttonRegister.setOnClickListener(this);
    textViewSignin.setOnClickListener(this);
    }

    private void registerUser(){
        String email = editTextemail.getText().toString().trim();
        String password= editTextPassowrd.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Please enter email",Toast.LENGTH_SHORT).show();
            return;
        //email is empty, stopping the function execution
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Please enter password",Toast.LENGTH_SHORT).show();
            return;
            //email is empty, stopping the function execution
        }
        progressDialog.setMessage("Registering User...");
        progressDialog.show();
        firebaseAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            //user is successfully reg and logged in
                            Toast.makeText(MainActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                            progressDialog.cancel();
                        }else{
                            Toast.makeText(MainActivity.this, "Registered failed, try again", Toast.LENGTH_SHORT).show();
                            progressDialog.cancel();
                        }
                    }
                });
    }
    @Override
    public void onClick(View view) {
     if(view == buttonRegister) {
         registerUser();
     }
     }
    }

