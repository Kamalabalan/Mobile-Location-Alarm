package com.kamalan.mobilelocationalarm;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.widget.TextView;

public class HelpActivity extends Activity {
	 String introduction = "Introduction";
     String description = "Mobile location alarm is a cutting-edge application that reminds to perform tasks based on your current location, rather than time. It will helpful to you alert by vibrate your smart phone & remind text when you reach the destination location.";
	 String home="Home";
	 String homeDescription="In Homepage you can see your current location by clicking current location button. You can add your destination point by clicking Add Destination Button. When you click the button it will show the map. You have to mark the place and click select button. it will show the destination address and ask you to type remind text. Then when you click the ok button it will show alert text in home page.";
     String setting="Setting";
     String settingDescription="In setting page you can set the accuracy for find the destination place by selecting radiation in meter. Similarly you can select vibrate pattern and repeat alarm time.";
	 public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        
	       

	        
	        setContentView(R.layout.help_layout);
	        final TextView textView = (TextView) findViewById(R.id.textView1);
	        textView.setTextSize(15);
	        textView.setText(introduction+"\n\n"+description+"\n\n\n"+home+"\n\n"+homeDescription+"\n\n\n"+setting+"\n\n"+settingDescription);
	    }

}
