package com.cookandroid.sdcard_a;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.FileInputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnRead;
        final EditText edtSD;
        btnRead = (Button) findViewById(R.id.btnRead);
        edtSD = (EditText) findViewById(R.id.edtSD);

        ActivityCompat.requestPermissions(this,new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE},MODE_PRIVATE);

        //SD Card에서 읽기 버튼을 눌렀을 경우
        btnRead.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                try{
                    FileInputStream infs = new FileInputStream("/storage/emulated/0/sd_test.txt");
                    byte[] txt = new byte[infs.available()];
                    infs.read(txt);
                    edtSD.setText(new String(txt));
                    infs.close();
                }catch(IOException e){

                }
            }

        });
    }
}
