package com.kamalan.mobilelocationalarm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
 
//Activity for Splash screen
public class MainActivity extends Activity 
{
  
    private boolean mIsBackButtonPressed;
    private static final int SPLASH_DURATION = 6000; //6 seconds
    private Handler myhandler;
  
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
  
        myhandler = new Handler();
  
        // run a thread to start the home screen
        myhandler.postDelayed(new Runnable()
        {
            @Override
            public void run() 
            {
  
               finish();
                 
               if (!mIsBackButtonPressed)
               {
                    // start the home activity 
                    Intent intent = new Intent(MainActivity.this, AndroidTabLayoutActivity.class);
                    MainActivity.this.startActivity(intent);
               }
                  
            }
  
        }, SPLASH_DURATION); 
    }
     
    
    //handle back button press
    @Override
    public void onBackPressed() 
    {
        mIsBackButtonPressed = true;
        super.onBackPressed();
    }
        
}