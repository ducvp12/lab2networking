package com.example.asshoanthien.myapplication;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class POST extends AsyncTask<String, String, String> {
   public static final String duongdan="http://dotplays.com/android/login.php";
    Context context;
    String usesname,password,name1;
    TextView tvname;

    public POST(Context context, String usesname, String password,String name2,TextView tvname) {
        this.context = context;
        this.usesname = usesname;
       this.password=password;
        this.name1= name2;
        this.tvname=tvname;
    }



    @Override
    protected String doInBackground(String... strings) {
        try {
            URL url=new URL(duongdan);
            String param="usesname: "+ URLEncoder.encode(usesname)+"&password: " +URLEncoder.encode(password)+"&name: " +URLEncoder.encode(name1);
            HttpURLConnection urlConnection=(HttpURLConnection)url.openConnection();
            urlConnection.setDoOutput(true);
            urlConnection.setRequestMethod("POST");
            urlConnection.setFixedLengthStreamingMode(param.getBytes().length);
            urlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            PrintWriter printWriter = new PrintWriter(urlConnection.getOutputStream());
            printWriter.print(param);
            printWriter.close();

            String line="";
            BufferedReader bfr=new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            StringBuffer sb=new StringBuffer();
            while ((line= bfr.readLine())!= null){
                sb.append(line);
            }
            name1=sb.toString();
            urlConnection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {

        super.onPostExecute(s);
        Toast.makeText(context, name1, Toast.LENGTH_SHORT).show();
        tvname.setText(name1);
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }
}
