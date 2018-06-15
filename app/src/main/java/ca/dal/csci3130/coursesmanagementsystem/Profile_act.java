package ca.dal.csci3130.coursesmanagementsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Profile_act extends AppCompatActivity implements View.OnClickListener {
    private FirebaseAuth firebaseAuth;
    private TextView textViewUserEmail;
    private Button buttonLogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_act);

        firebaseAuth = firebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser()==null){
            finish();
            startActivity(new Intent(this, Login.class));
        }
        FirebaseUser user = firebaseAuth.getCurrentUser();
        textViewUserEmail= (TextView) findViewById(R.id.textViewUserEmail);

        textViewUserEmail.setText("Welcome to use Courese Management System");
        buttonLogout= (Button)findViewById(R.id.buttonLogout);
        buttonLogout.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
    if(v == buttonLogout){
        firebaseAuth.signOut();
        finish();
        startActivity(new Intent(this, Login.class));
    }
    }
}
