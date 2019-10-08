package com.sariHunter.inventory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class SignInAnynomus extends AppCompatActivity {

    TextInputEditText edName;
    Button btSign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_anynomus);

        edName = findViewById(R.id.nameAnony);

        btSign = findViewById(R.id.signAnynomous);

        btSign.setOnClickListener(v -> {

            singIn();

        });

    }
   private void singIn(){
       //FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
       //should be null;

       FirebaseAuth.getInstance().signInAnonymously()
               .addOnSuccessListener(this, authResult -> {
                   FirebaseUser user = authResult.getUser();

                   String name = edName.getText().toString();

                   //update the user;

                   UserProfileChangeRequest request = new UserProfileChangeRequest.Builder().setDisplayName(name).build();

                   assert user != null;// crash the app if the user is null

                   user.updateProfile(request).addOnSuccessListener(aVoid -> {
                       startActivity(new Intent(this,AllStores.class));
                   });


               });
   }

}
