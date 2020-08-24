package com.example.covid19apiinfo;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    TextView dateobj,countryobj,confirmedobj,deathobj,recoveredobj,activeobj;
    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dateobj=findViewById(R.id.date);
        confirmedobj=findViewById(R.id.confirmed);
        countryobj=findViewById(R.id.country);
        deathobj=findViewById(R.id.deaths);
        recoveredobj=findViewById(R.id.recovered);
        activeobj=findViewById(R.id.active);
        dialog=new ProgressDialog(this);
        dialog.setTitle("Data Fetching from Internet");
        dialog.setMessage("Please wait Data Loading...");
        dialog.show();
        EndPointService service=Covid19APIInstance.getInstance().create(EndPointService.class);
        Call<String> c=service.getData();
        c.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                dialog.dismiss();
                //Toast.makeText(MainActivity.this, ""+response.body(), Toast.LENGTH_SHORT).show();
                 try {
                     JSONArray rootArray = new JSONArray(response.body());
                     for(int i=0;i<rootArray.length();i++) {
                         JSONObject rootobj = rootArray.getJSONObject(i);
                         String resultcountry = rootobj.getString("Country");
                         String resultconfirmed = rootobj.getString("Confirmed");
                         String resultrecovery = rootobj.getString("Recovered");
                         String resultdeaths = rootobj.getString("Deaths");
                         String resultactive = rootobj.getString("Active");
                         String resultdate = rootobj.getString("Date");
                         try {
                             dateobj.setText("Date: "+properformat(resultdate));
                         } catch (ParseException e) {
                             e.printStackTrace();
                         }
                         countryobj.setText("Country: "+resultcountry);
                         recoveredobj.setText("Recovered: "+resultrecovery);
                         activeobj.setText("Active: "+resultactive);
                         deathobj.setText("Deaths: "+resultdeaths);
                         confirmedobj.setText("Confirmed: "+resultconfirmed);
                     }

                 }catch (JSONException e){
                     e.printStackTrace();
                 }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
    }
    private String properformat(String resultDate) throws ParseException {
        String inputformat="yy-mm-dd";
        String outformat="dd-mm-yy";
        SimpleDateFormat inputform=new SimpleDateFormat(inputformat);
        SimpleDateFormat outputform=new SimpleDateFormat(outformat);
        Date d;
        String str=null;
        try {
            d = inputform.parse(resultDate);
            str=outputform.format(d);
        }
        catch (ParseException e){
            e.printStackTrace();
        }
        return str;
    }
}
