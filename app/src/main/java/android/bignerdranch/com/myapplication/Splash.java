package android.bignerdranch.com.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.MonthDisplayHelper;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Space;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Splash extends FragmentActivity {

    private final int SPLASH_DISPLAY_LENGTH = 2000;
    private FirebaseAuth mAuth;
    private FirebaseUser user;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DataBase.getDataBase();
        setContentView(R.layout.splash);

        Button anfitrion = findViewById(R.id.invited);
        Button user = findViewById(R.id.sign_in);


        anfitrion.setEnabled(false);

        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Splash.this, Login.class);
                Splash.this.startActivity(intent);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        DataBase.getDataBase();
        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();

        if(user != null){
            Intent intent = new Intent(Splash.this, MainActivity.class);
            Splash.this.startActivity(intent);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        user = mAuth.getCurrentUser();
        if(user != null){
            Intent intent = new Intent(Splash.this, MainActivity.class);
            Splash.this.startActivity(intent);
        }
    }
}