package com.wust.wusheng.testcustomview;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.Image;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * Created by asus on 2016-06-30.
 */
public class LayoutView extends RelativeLayout{

    private ImageView imageView;

    public LayoutView(Context context) {
        super(context);
        initView(context);
    }

    public LayoutView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public LayoutView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public LayoutView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context);
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.myview,this,true);
        imageView = (ImageView) findViewById(R.id.image);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        int a = imageView.getWidth();
        Log.e("TAG","Layout view width:"+a);
    }
}
