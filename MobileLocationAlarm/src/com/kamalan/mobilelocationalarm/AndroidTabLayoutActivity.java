package com.kamalan.mobilelocationalarm;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
 
public class AndroidTabLayoutActivity extends TabActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab);
         
        TabHost tabHost = getTabHost();
         
        // Tab for Home
        TabSpec homespec = tabHost.newTabSpec("Home");
        // setting Title and Icon for the Tab
        homespec.setIndicator("Home", getResources().getDrawable(R.drawable.icon_home_tab));
        Intent homeIntent = new Intent(this, HomeActivity.class);
        homespec.setContent(homeIntent);
         
        // Tab for Setting
        TabSpec settingspec = tabHost.newTabSpec("Setting");        
        settingspec.setIndicator("Setting", getResources().getDrawable(R.drawable.icon_setting_tab));
        Intent settingIntent = new Intent(this, SettingActivity.class);
        settingspec.setContent(settingIntent);
         
        // Tab for Help
        TabSpec helpspec = tabHost.newTabSpec("Help");
        helpspec.setIndicator("Help", getResources().getDrawable(R.drawable.icon_help_tab));
        Intent helpIntent = new Intent(this, HelpActivity.class);
        helpspec.setContent(helpIntent);
        
       /* TabSpec alertspec = tabHost.newTabSpec("Alert");
        alertspec.setIndicator("Alert", getResources().getDrawable(R.drawable.icon_alert_tab));
        Intent alertIntent = new Intent(this, AlertActivity.class);
        alertspec.setContent(alertIntent);*/
        
        
         
        // Adding all TabSpec to TabHost
        tabHost.addTab(homespec); // Adding homes tab
        tabHost.addTab(settingspec); // Adding setting tab
        tabHost.addTab(helpspec); // Adding help tab
       // tabHost.addTab(alertspec);
    }
}