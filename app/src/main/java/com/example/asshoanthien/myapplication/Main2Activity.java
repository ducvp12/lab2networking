package com.example.asshoanthien.myapplication;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Main2Activity extends AppCompatActivity {
TextView tvname,tvmonan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tvname=findViewById(R.id.tvname);
        Intent intent = getIntent();
        String value1 = intent.getStringExtra("a");
        tvname.setText(value1);
        tvmonan=findViewById(R.id.tvmonan);
        MyAsynctask myAsynctask=new MyAsynctask();

        myAsynctask.execute("http://dotplays.com/android/bai1.php?food=today");
    }
    public class MyAsynctask extends AsyncTask<String,Long,String> {

        @Override
        protected String doInBackground(String... strings) {
            try {
                URL url = new URL(strings[0]);
                HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
                InputStream inputStream=httpURLConnection.getInputStream();
                Scanner scanner=new Scanner(inputStream);
                String data="";
                while (scanner.hasNext()){
                    data= scanner.nextLine()+data;
                }

                scanner.close();
                return data;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            tvmonan.setText(s);
        }
        //ket thu thread

    }
}
