package com.sariHunter.inventory;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Button;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Signing extends AppCompatActivity {

    TextInputEditText email, password;
    Button signing;
    Button signAnyno;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signing);
        //set sign in and registration methods and firebase access after finishing go to All Stores Activity

        mAuth = FirebaseAuth.getInstance();

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        signing = findViewById(R.id.sign);

        signAnyno = findViewById(R.id.signAnynomasly);
                signAnyno.setOnClickListener((v -> {
            mAuth.addAuthStateListener(firebaseAuth -> {

                //no user? sign one
                if(firebaseAuth.getCurrentUser() == null){


                    startActivity(new Intent(getApplication(), SignInAnynomus.class));
                    finish();
                }else{
                    // make welcome back activity;
                    String displayName = firebaseAuth.getCurrentUser().getDisplayName();
                    Toast.makeText(this,"welcome back" + displayName,Toast.LENGTH_LONG).show();
                    startActivity(new Intent(this, AllStores.class));
                }
           });
            // go to sign in and ask few questions like just name;


        }));

        signing.setOnClickListener(v -> {

            String uEmail = email.getText().toString();
            String uPassowrd = password.getText().toString();

            startActivity(new Intent(getApplication(),AllStores.class));

            if (checkFields(uEmail, uPassowrd)) {
                login(uEmail, uPassowrd);
            }

        });


    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//
//        if (mAuth.getCurrentUser() != null) {
//
//            startActivity(new Intent(getApplication(), AllStores.class));
//        }
//
//    }


    private boolean checkFields(String uEmail, String uPassowrd) {
        if (TextUtils.isEmpty(uEmail)) {
            email.setError("please fill the Email address");
            System.out.println("Email: " + uEmail);
            return false;
        } else if (!uEmail.contains("@")) {
            email.setError("please fill the Email address correctly");
            return false;
        } else if (!uEmail.endsWith(".com")) {
            email.setError("please fill the Email address correctly");
            return false;
        } else if (TextUtils.isEmpty(uPassowrd) || uPassowrd.length() < 8) {
            password.setError("please fill the password field with at least 8 characters");
            return false;
        } else {
            email.setError(null);
            password.setError(null);
        }

        return Patterns.EMAIL_ADDRESS.matcher(uEmail).matches();
    }

    public void Register(String email, String password) {
        toggleProgress(true);
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            toggleProgress(false);

                            // FirebaseUser user = mAuth.getCurrentUser();
                            startActivity(new Intent(getApplication(), AllStores.class));
                            //updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.

                            Toast.makeText(Signing.this, "Authentication failed.",
                                    Toast.LENGTH_LONG).show();
                            //updateUI(null);
                        }
                    }
                });
    }

    public void login(String email, String password) {
        toggleProgress(true);
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {

                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        //FirebaseUser user = mAuth.getCurrentUser();

                        startActivity(new Intent(Signing.this, AllStores.class));
                        toggleProgress(false);
                        //updateUI(user);
                    } else {
                        // If sign in fails, display a message to the user.
                        showError("Error while signing in, Trying to make new user");
                        Toast.makeText(Signing.this, "Authentication failed.",
                                Toast.LENGTH_SHORT).show();
                        Toast.makeText(Signing.this, " Trying to make a new user",
                                Toast.LENGTH_LONG).show();

                        Register(email, password);

                        //updateUI(null);
                    }
                });
    }

// design pattern lazy loading

    ProgressDialog pb;

    private void toggleProgress(boolean show) {

        if (pb == null) {
            pb = new ProgressDialog(this);
            pb.setTitle("Logging you in");
            pb.setMessage("please wait");
        }

        if (show)
            pb.show();
        else
            pb.dismiss();

    }

    private void showError(String msg) {
        new AlertDialog.Builder(this)
                .setTitle("Error")
                .setMessage(msg)
                .setPositiveButton("OK", (dialog, which) -> {
                })
                .show();
    }
}
