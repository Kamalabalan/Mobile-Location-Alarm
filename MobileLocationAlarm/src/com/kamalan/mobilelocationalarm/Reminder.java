package com.kamalan.mobilelocationalarm;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;



public class Reminder extends Activity {
	//public static double logitude,latitude; 
	//public static String address;
	public TextView text2;
	Button button1;
	EditText text1;
	public static String reminder_text;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.reminder_layout);
		Bundle extras = getIntent().getExtras();
		text2=(TextView) findViewById(R.id.textView3);
		/*String s1=Double.toString(Destination_Location.latitude);
		String s2=Double.toString(Destination_Location.longitude);
		text2.setText("latitude:"+s1+"\n"+"longitude:"+s2);*/
		
		text2.setText(Destination_Location.address);
	
		addListenerOnButton();
	}
	
	public void addListenerOnButton(){
		final Context context=this;
		button1 = (Button) findViewById(R.id.button1);
		text1=(EditText) findViewById(R.id.editText2);
		 
		button1.setOnClickListener(new OnClickListener() {
 
			public void onClick(View arg0) {
				
				reminder_text=text1.getText().toString();
				
				
				 Intent intent = new Intent(context, AndroidTabLayoutActivity.class);
				
                startActivity(intent);   
			 
			}
 
		});
	
	}

}
