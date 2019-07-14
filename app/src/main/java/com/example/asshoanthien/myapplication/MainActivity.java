package com.example.asshoanthien.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText edtusesname;
    private EditText edtpassword,edtname;
    private Button button;
    private TextView tvname;
    String usesname,password,name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    public void login(View view) {


               usesname=edtusesname.getText().toString();
               password=edtpassword.getText().toString();
               name=edtname.getText().toString();
               POST post=new POST(this  ,usesname,password,name,tvname);
               post.execute();



    }

    private void initView() {
        edtusesname = (EditText) findViewById(R.id.edtusesname);
        edtpassword = (EditText) findViewById(R.id.edtpassword);
        button = (Button) findViewById(R.id.button);
        tvname=findViewById(R.id.tvname);
        edtname=findViewById(R.id.edtname);
    }
}
