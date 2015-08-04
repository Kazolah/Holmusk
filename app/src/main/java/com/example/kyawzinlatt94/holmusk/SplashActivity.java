package com.example.kyawzinlatt94.holmusk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


/**
 * A full-screen activity that shows at the beginning
 *
 */
public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActionBar().hide();
        setContentView(R.layout.activity_splash);
        Thread welcomeThread = new Thread(){
            @Override
            public void run(){
                try{
                    super.run();
                    sleep(4000);
                }catch(Exception e){
                    e.printStackTrace();
                }finally{
                    Intent i = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(i);
                    overridePendingTransition(R.animator.fade_in, R.animator.fade_out);
                    finish();
                }
            }
        };
        welcomeThread.start();
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

}
