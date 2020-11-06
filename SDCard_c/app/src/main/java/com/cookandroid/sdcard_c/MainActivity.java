package com.cookandroid.sdcard_c;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnFilelist;
        final EditText edtFilelist;
        btnFilelist = (Button) findViewById(R.id.btnFilelist);
        edtFilelist = (EditText) findViewById(R.id.edtFilelist);

        btnFilelist.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                //시스템의 루트 경로를 알아낸다.
                String sysDir = Environment.getRootDirectory().getAbsolutePath();


                File[] sysFiles = (new File(sysDir).listFiles());

                String strFname;
                for(int i=0;i<sysFiles.length;i++){

                    //찾은 값이 디렉토리라면
                    if(sysFiles[i].isDirectory() == true)
                        strFname = "<폴더>" + sysFiles[i].toString();

                    else//찾은 값이 파일이라면
                        strFname = "<파일>" + sysFiles[i].toString();

                    edtFilelist.setText(edtFilelist.getText() + "\n" + strFname);
                }
            }
        });
    }
}
