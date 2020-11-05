package com.cookandroid.project7_a;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    //전역변수
    LinearLayout baseLayout;
    Button button1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("배경색 바꾸기");

        //제어할 대상을참조변수에 연결한다.
        baseLayout = (LinearLayout) findViewById(R.id.baseLayout);
        button1 = (Button) findViewById(R.id.button1);
    }//end -protected void onCreate(Bundle savedInstanceState)
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        //xml파일을 이용해서 menu를 구성한다.
        /*
        MenuInflater mInflater = getMenuInflater();
        mInflater.inflate(R.menu.menu1,menu);
         */
        //자바코드로 menu를 구성한다.
        menu.add(0,1,0,"배경색(빨강)");
        menu.add(0,2,0,"배경색(녹색)");
        menu.add(0,3,0,"배경색(파랑)");

        SubMenu subMenu = menu.addSubMenu("버튼변경 >>");
        subMenu.add(0,4,0,"버튼 45도 회전");
        subMenu.add(0,5,0,"버튼2배 확대");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 1:
                baseLayout.setBackgroundColor(Color.RED);
                return true;

            case 2:
                baseLayout.setBackgroundColor(Color.GREEN);
                return true;

            case 3:
                baseLayout.setBackgroundColor(Color.BLUE);
                return true;
            case 4:
                button1.setRotation(45);
                return true;
            case 5:
                button1.setScaleX(2);
                button1.setScaleY(2);
                return true;
        }
        return false;
    }
}//end - public class MainActivity
