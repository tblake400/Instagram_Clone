package com.example.myapplication.ui.login;

import android.app.Activity;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.ui.login.LoginViewModel;
import com.example.myapplication.ui.login.LoginViewModelFactory;
import com.example.myapplication.databinding.ActivityLoginBinding;

import java.text.ParseException;

public class LoginActivity extends AppCompatActivity {

    public static final String TAG = "LoginActivity";
    private EditText etUsername = findViewById(R.id.etUsername);
    private EditText etPassword = findViewById(R.id.etPassword);
    private Button btnLogin = findViewById(R.id.btnLogin);


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "onClick login button");
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                loginUser(username, password);
            }

            private void loginUser(String username, String password) {
                Log.i(TAG, "Attempting to login user" + username);
                // TODO: navigate to the main activity if the user has signed in properly
            }
        });
    }

    private void loginUser(String username, String password) {
        Log.i(TAG, "Attempting to login user " + username);
        ParseUser.logInInBackground(username, password, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if (e != null) {
                    // TODO: better error handling
                    Log.e(TAG, "Issue with login",e);
                    Toast.makeText(LoginActivity.this, "Issue with login!", Toast.LENGTH_SHORT).show();
                    return;
                }
                // TODO : initiate successful logged in experience
                goMainActivity();
                Toast.makeText(LoginActivity.this, "Success", Toast.LENGTH_SHORT).show();
            }

        });

    }

    private void goMainActivity() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }
}