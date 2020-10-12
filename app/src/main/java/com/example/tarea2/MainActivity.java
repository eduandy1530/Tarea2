package com.example.tarea2;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_ASK_PERMISSIONS = 123;

    private Switch Switch1;
    private Switch Switch2;
    private Switch Switch3;
    private Switch Switch4;
    private Switch Switch5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Switch1 = (Switch) findViewById(R.id.switch1);
        Switch2 = (Switch) findViewById(R.id.switch2);
        Switch3 = (Switch) findViewById(R.id.switch3);
        Switch4 = (Switch) findViewById(R.id.switch4);
        Switch5 = (Switch) findViewById(R.id.switch5);

    }


    public void examplePermission(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            checkPermission();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void checkPermission() {

       if (Switch1.isChecked()){
           requestPermissions(new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_CODE_ASK_PERMISSIONS);
       }
        if (Switch2.isChecked()){
            requestPermissions(new String[] {Manifest.permission.ACCESS_BACKGROUND_LOCATION}, REQUEST_CODE_ASK_PERMISSIONS);
        }
        if (Switch3.isChecked()){
            requestPermissions(new String[] {Manifest.permission.CAMERA}, REQUEST_CODE_ASK_PERMISSIONS);
        }
        if (Switch4.isChecked()){
            requestPermissions(new String[] {Manifest.permission.CALL_PHONE}, REQUEST_CODE_ASK_PERMISSIONS);
        }
        if (Switch5.isChecked()){
            requestPermissions(new String[] {Manifest.permission.READ_CONTACTS}, REQUEST_CODE_ASK_PERMISSIONS);
        }

        return;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if(REQUEST_CODE_ASK_PERMISSIONS == requestCode) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "OK Permissions granted ! " + Build.VERSION.SDK_INT, Toast.LENGTH_LONG).show();

            } else {
                Toast.makeText(this, "Permissions are not granted ! " + Build.VERSION.SDK_INT, Toast.LENGTH_LONG).show();
            }
        }
         else{
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }


}