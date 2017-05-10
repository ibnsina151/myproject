package com.example.ibnsina.ashajawa;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DialogFragment;
import android.app.usage.NetworkStats;
import android.app.usage.NetworkStatsManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Popup_srceen extends AppCompatActivity{

    private static int timeout =10000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_srceen);

        ConnectivityManager CM = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = CM.getActiveNetworkInfo();
        boolean isWiFi = networkInfo.getType() == ConnectivityManager.TYPE_WIFI;
        boolean isdata = networkInfo.getType() == CM.TYPE_MOBILE;


        if(!networkInfo.isConnected())
        {
            Toast.makeText(this, "No Internt Connection, PlZ established your internet", Toast.LENGTH_SHORT).show();

            // 1. Instantiate an AlertDialog.Builder with its constructor
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            // 2. Chain together various setter methods to set the dialog characteristics
            builder.setMessage("Connect your internet, Now")
                    .setTitle("No internet connection")
                    .setIcon(R.drawable.ic_warning_black_24dp);
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    // User clicked OK button

                }
            });
            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                     // User clicked no button.
                    timeout = 500;
                }
            });

            // 3. Get the AlertDialog from create()
            AlertDialog dialog = builder.create();


        }

        else
        {

        }


        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {

                Intent intent = new Intent(Popup_srceen.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },timeout);



    }
}
