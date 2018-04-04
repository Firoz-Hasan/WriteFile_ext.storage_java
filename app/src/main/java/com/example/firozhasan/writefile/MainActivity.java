package com.example.firozhasan.writefile;

import android.content.Context;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    EditText ET;
    Button saveBTN;
    TextView tv;
  //  public String path = Environment.DIRECTORY_DOCUMENTS + "/aaTutorial";
    private static final String FILE_NAME = "example.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ET= findViewById(R.id.ET1);
        saveBTN = findViewById(R.id.saveBTN);
        tv = findViewById(R.id.tv);
        checkExternalMedia();
      //  Toast.makeText(MainActivity.this, path.toString(), Toast.LENGTH_SHORT).show();
        saveBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (FileHelper.saveToFile( ET.getText().toString())){

                    Log.d("path", "saveToFile: "+FileHelper.path );
                    Toast.makeText(MainActivity.this,"Saved to file"+FileHelper.path,Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this,"Error save file!!!",Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
    private void checkExternalMedia() {
        boolean mExternalStorageAvailable = false;
        boolean mExternalStorageWriteable = false;
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            // Can read and write the media
            mExternalStorageAvailable = mExternalStorageWriteable = true;
        } else if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            // Can only read the media
            mExternalStorageAvailable = true;
            mExternalStorageWriteable = false;
        } else {
            // Can't read or write
            mExternalStorageAvailable = mExternalStorageWriteable = false;
        }
       // Toast.makeText(MainActivity.this,,Toast.LENGTH_SHORT).show();
        tv.append("\n\nExternal Media: readable=" + mExternalStorageAvailable
                + " writable=" + mExternalStorageWriteable);
    }

}
