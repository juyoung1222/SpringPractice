package com.cookandroid.project8_b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class myPictureView extends View {
    String imagePath = null;
    public myPictureView(Context context, @Nullable AttributeSet attrs){
        super(context,attrs);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //myPictureView에보여줄 이미지 파일의 경로 및 파일을 저장
        if(imagePath !=null){
            Bitmap bitmap = BitmapFactory.decodeFile(imagePath);

            canvas.drawBitmap(bitmap,0,0, null);

        }
    }//end -  protected void onDraw
}// end - public class myPictureView
