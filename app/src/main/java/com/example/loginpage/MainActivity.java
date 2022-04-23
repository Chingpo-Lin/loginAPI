package com.example.loginpage;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.io.InputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private String url = "https://ignis-english-guru.herokuapp.com/authapi/users/login/";
    private EditText mEditUsername;
    private EditText mEditPassword;
    private Button mLoginBtn;
    private String user = "dell3";
    private String pass = "pass123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditUsername= findViewById(R.id.username_enter);
        mEditPassword = findViewById(R.id.password_enter);
        mLoginBtn = findViewById(R.id.login);

        System.out.println("wjw");
        Toast.makeText(this, "hello", Toast.LENGTH_LONG).show();

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = mEditUsername.getText().toString();
                String password = mEditPassword.getText().toString();
                Post(username, password);
            }
        });
    }

    public void Post(String username, String password) {

        Map<String, String> reqParam = new HashMap<>();
        reqParam.put("username", user);
        reqParam.put("password", pass);
        JSONObject param = new JSONObject(reqParam);

        RequestQueue mQueue = Volley.newRequestQueue(MainActivity.this);
        JsonObjectRequest request= new JsonObjectRequest(Request.Method.POST, url, param, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                Log.d("he", response.toString());
                System.out.println(response);
            }


        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("hehe", error.toString());
                error.printStackTrace();
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> header = new HashMap<>();
                header.put("Content-Type", "application/json");
                header.put("Authorization", "secret_key django-insecure-b@$s0n&mw5v$k-)v(" +
                        "nt7u$%f6_s*c*qm8+7g^gbx9utpry$(x6");
                Log.d("hihi", header.values().toString());
                return header;
            }
        };
        mQueue.add(request);
    }
}