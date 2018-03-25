package com.example.catur.catur_1202152171_studycase5;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Setting extends AppCompatActivity {
    int wrn;
    TextView color;
    AlertDialog.Builder alert;
    SharedPreferences.Editor edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        alert = new AlertDialog.Builder(this);

        SharedPreferences shp = getApplicationContext().getSharedPreferences("shp", 0);
        edit = shp.edit();
        color = findViewById(R.id.warna);
        wrn = shp.getInt("background", R.color.standart);

        color.setText(getWarna(wrn));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() ==android.R.id.home){
            this.onBackPressed();
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(Setting.this, Awal.class));
        finish();
    }

    public String getWarna(int i){
        if (i==R.color.maroon){
            return "Maroon";
        }else if (i==R.color.tosca){
            return "Tosca";
        }else if (i==R.color.navy){
            return "Navy";
        }else{
            return "Standart";
        }
    }
    public int getIntColor(int i){
        if (i==R.color.maroon){
            return R.id.btn_maroon;
        }else if (i==R.color.tosca){
            return R.id.btn_tosca;
        }else if (i==R.color.navy){
            return R.id.btn_navy;
        }else {
            return R.id.btn_standart;
        }
    }

    public void pencet(View view) {
        alert.setTitle("Choose Color");
        View v = getLayoutInflater().inflate(R.layout.pilihwarna,null);
        alert.setView(v);

        final RadioGroup rg = v.findViewById(R.id.rg);
        rg.check(getIntColor(wrn));

        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
              int cek = rg.getCheckedRadioButtonId();
              switch (cek){
                  case R.id.btn_maroon:
                    wrn = R.color.maroon;
                  break;
                  case R.id.btn_navy:
                      wrn = R.color.navy;
                      break;
                  case R.id.btn_tosca:
                      wrn = R.color.tosca;
                      break;
                  case R.id.btn_standart:
                      wrn = R.color.standart;
                      break;
              }
              color.setText(getWarna(wrn));
              edit.putInt("background", wrn);
              edit.commit();
            }
        });
        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });alert.create().show();
    }
}
