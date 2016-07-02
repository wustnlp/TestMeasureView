package com.wust.wusheng.testcustomview;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * Created by asus on 2016-06-30.
 */
public class MyView extends RelativeLayout{

    private ImageView imageView;

    public MyView(Context context) {
        super(context);
        initView(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public MyView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context);
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.myview,this,true);
        imageView = (ImageView) findViewById(R.id.image);
        imageView.post(new Runnable() {
            @Override
            public void run() {
                if (imageView.getWidth()>imageView.getHeight()){
                    Log.e("TAG", "subview width:" + imageView.getWidth());
                    Log.e("TAG","subview height:"+imageView.getHeight());
                }else{
                    Log.e("TAG","subview width:"+imageView.getWidth());
                    Log.e("TAG","subview height:"+imageView.getHeight());
                }
            }
        });

    }
}
