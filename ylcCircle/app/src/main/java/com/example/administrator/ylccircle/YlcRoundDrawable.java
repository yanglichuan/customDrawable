package com.example.administrator.ylccircle;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

public class YlcRoundDrawable extends Drawable {

    private Paint mPaint;
    private int mWidth;
    private int mHeight;
    private int r;
    private Bitmap mBitmap ;
    public YlcRoundDrawable(Bitmap bitmap,int r){
        mBitmap = bitmap;
        this.r = r;
        BitmapShader  bitmapShader= new BitmapShader(bitmap, Shader.TileMode.CLAMP,
                Shader.TileMode.CLAMP);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setShader(bitmapShader);
        mWidth = mBitmap.getWidth();
        mHeight = mBitmap.getHeight();
    }

    @Override
    public void draw(Canvas canvas)
    {
       // canvas.drawCircle(mWidth / 2, mWidth / 2, mWidth / 2, mPaint);
        canvas.drawRoundRect(new RectF(0,0,mWidth,mHeight),r,r,mPaint);
    }

    @Override
    public int getIntrinsicWidth()
    {
        return mWidth;
    }

    @Override
    public int getIntrinsicHeight()
    {
        return mHeight;
    }

    @Override
    public void setAlpha(int alpha)
    {
        mPaint.setAlpha(alpha);
    }

    @Override
    public void setColorFilter(ColorFilter cf)
    {
        mPaint.setColorFilter(cf);
    }

    @Override
    public int getOpacity()
    {
        return PixelFormat.TRANSLUCENT;
    }
}
