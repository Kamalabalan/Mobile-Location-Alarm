package com.kamalan.mobilelocationalarm;



import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Spinner;

public class SettingActivity extends Activity {
	//Vibrator vibrator;
	Spinner spinner1,spinner2,spinner3;
	public static String tone="VibratePattern";
	public static String snooze="1";
	public static String radious="500";
	
	 public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.setting_layout);
	        addListenerOnSpinnerItemSelection();
	    }
	 
	 public void addListenerOnSpinnerItemSelection(){
		 
		 spinner1 = (Spinner) findViewById(R.id.spinner1);
		 spinner2=(Spinner) findViewById(R.id.spinner2);
		 spinner3=(Spinner) findViewById(R.id.spinner3);
		 tone=String.valueOf(spinner1.getSelectedItem());
		 snooze=String.valueOf(spinner2.getSelectedItem());
		 radious=String.valueOf(spinner3.getSelectedItem());
		 
		 
	 }
	 
	
		
	    
	    
		
		

}
