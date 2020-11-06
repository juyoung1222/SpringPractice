package com.cookandroid.project8_a;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //전역변수
    DatePicker dp;
    EditText edtDiary;
    Button btnWrite;
    String fileName;//일기내용을 저장할 파일을 가리키는 변수

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("간단 일기장");

        dp = (DatePicker) findViewById(R.id.datePicker1);
        edtDiary = (EditText) findViewById(R.id.edtDiary);
        btnWrite = (Button) findViewById(R.id.btnWrite);


        Calendar cal = Calendar.getInstance();
        int cYear = cal.get(Calendar.YEAR);
        int cMonth = cal.get(Calendar.MONTH);
        int cDay = cal.get(Calendar.DAY_OF_MONTH);

        //달력을 초기화한다.
        dp.init(cYear, cMonth, cDay, new DatePicker.OnDateChangedListener() {
            public void onDateChanged(DatePicker view, int year,
                                      int monthOfYear, int dayOfMonth) {
                //저장할 파일 이름 : yyyy-mm-dd.txt
                fileName = Integer.toString(year) + "_"
                        + Integer.toString(monthOfYear + 1) + "_"
                        + Integer.toString(dayOfMonth) + ".txt";
                String str = readDiary(fileName);//파일 이름을 읽어들인다.
                edtDiary.setText(str);
                btnWrite.setEnabled(true);
            }
        });
        //글 작성/수정버튼이 눌렸을 경우
        btnWrite.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    FileOutputStream outFs = openFileOutput(fileName,
                            Context.MODE_PRIVATE);
                   //파일에 기록할 내용을 변수에 저장.
                    String str = edtDiary.getText().toString();
                    //파일에 저장한 변수의 내용을 기록한다.
                    outFs.write(str.getBytes());
                    outFs.close();
                    Toast.makeText(getApplicationContext(),
                            fileName + " 이 저장됨", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                }
            }
        });

    }
    //선택한 날짜에 해당되는 파일의 내용을 읽어들인다.
    String readDiary(String fName) {
        String diaryStr = null;
        FileInputStream inFs;
        try {
            //선택한 날짜에 해당하는 파일이 존재하면 그 내용을 읽어들인다.
            inFs = openFileInput(fName);
            byte[] txt = new byte[500];
            inFs.read(txt);
            inFs.close();

            //파일의 내용을 readDiary()를 요청한 곳에 넘겨줄 변수에 담는다.
            diaryStr = (new String(txt)).trim();
            btnWrite.setText("수정 하기");
        } catch (IOException e) {//입출력이므로 IOException이 발생할수 있다.
            edtDiary.setHint("일기 없음");
            btnWrite.setText("새로 저장");
        }
        return diaryStr;
    }


}