package com.wust.wusheng.testcustomview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends Activity {

    private MyView myView;
    private LayoutView layoutView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final View view = LayoutInflater.from(getApplication()).inflate(R.layout.activity_main,null);
        setContentView(view);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        Log.e("TAG", "screen width:" + displayMetrics.widthPixels);
        Log.e("TAG", "screen height:" + displayMetrics.heightPixels);

        myView = (MyView) findViewById(R.id.myview);
        myView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MeasureActivity.class));
            }
        });
        layoutView = (LayoutView) findViewById(R.id.layoutview);
        view.post(new Runnable() {
            @Override
            public void run() {
                if (view.getWidth()>view.getHeight()){
                    Log.e("TAG", "width:" + view.getWidth());
                    Log.e("TAG","height:"+view.getHeight());
                }else{
                    Log.e("TAG","width:"+view.getWidth());
                    Log.e("TAG","height:"+view.getHeight());
                }
            }
        });
        int a = this.getResources().getConfiguration().orientation;
        Log.e("screenOrit:","+"+a);
    }

    /**
     * @see #onRestoreInstanceState
     * @see #onRestart
     * @see #onPostResume
     * @see #onPause
     */
    @Override
    protected void onResume() {
        Log.e("TAG","onResume");
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
