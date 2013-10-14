package com.kamalan.mobilelocationalarm;



import java.text.DecimalFormat;

import com.kamalan.mobilelocationalarm.R;
//import com.kamalan.reminder.Alarm;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends Activity {
	Button button1,button2,button3;// button1=current location, button2=destination location, button3=currnet location retrive continuously
	Context context=this;
	String tone;
	Vibrator vibrator;
	private static final long MINIMUM_DISTANCE_CHANGE_FOR_UPDATES = 1; // in Meters
	private static final long MINIMUM_TIME_BETWEEN_UPDATES = 1000; // in Milliseconds
	double current_latitude,current_longitude; 
	double distance=500;// before he put the destination default distance is
	protected LocationManager locationManager;
	
	int dot = 200; // Length of a "dot" in milliseconds
    int dash = 500; // Length of a "dash" in milliseconds
    int short_gap = 200; // Length of Gap Between dots/dashes
    int medium_gap = 500; // Length of Gap Between Letters
    int long_gap = 1000; // Length of Gap Between Words
 
    long[] pattern = { 0, // Start immediately
            dot, short_gap, dot, short_gap, dot, // s
            medium_gap, dash, short_gap, dash, short_gap, dash, // o
            medium_gap, dot, short_gap, dot, short_gap, dot, // s
            long_gap };
	//TextView t;
	String des_address,reminder_text;
	 public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.home_layout);// show the home layout
	       button1 = (Button) findViewById(R.id.currentlocationid); //get the id of button1
	        button2 = (Button) findViewById(R.id.destinationid);//get the id of button2
	        button3=(Button) findViewById(R.id.gpscurrentlocatoinid);// get the id of button3
	        
	        
	        
	        
	        button1.setOnClickListener(new OnClickListener() // listen whether button1 is click or not
	        {
	        public void onClick(View v)
	        {
	        	Intent intent = new Intent(context, Current_Location.class);// if button1 is clicked which operation is performed 
                startActivity(intent); // start the activity of current class
	        
	        }
	                                        });

	        button2.setOnClickListener(new OnClickListener() // listen whether button2 is click or not
	        {
	        public void onClick(View v)
	        {
	        	Intent intent1 = new Intent(context, Destination_Location.class); // if button1 is clicked which operation is performed
                startActivity(intent1); //start the activity of destination location class  
	        
	        }
	                                        });
	        
	        
	        button3.setOnClickListener(new OnClickListener() {// listen whether button3 is click or not
				@Override
				public void onClick(View v) {
					showCurrentLocation();// go to show current location using gps
				}
			});     
			
	        
	        
	        
		
		
		
locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        
        locationManager.requestLocationUpdates(
        		LocationManager.GPS_PROVIDER, 
        		MINIMUM_TIME_BETWEEN_UPDATES, 
        		MINIMUM_DISTANCE_CHANGE_FOR_UPDATES,
        		new MyLocationListener()
        );// update the location  when 1m change or 1 s
        
		
		
		
		
		
	if(Destination_Location.address!=null)	{ // if the user enter the destination address
		
		distance=CalculationByDistance();   //calculate the distance
	check();// call check function to show the alert and vibrate
	
	}
		
		
	 
	        
	    }
	 
	 protected void showCurrentLocation() {

			Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

			if (location != null) {
				String message = String.format(
						"Current Location \n Longitude: %1$s \n Latitude: %2$s",
						location.getLongitude(), location.getLatitude()
				);// show in pop up window the current location
				
				Toast.makeText(HomeActivity.this, message,
						Toast.LENGTH_LONG).show();
				current_latitude=location.getLatitude();//get the current location of latitude
				current_longitude=location.getLongitude(); //get the current location of longitude
			}

		}   
	 
	 private class MyLocationListener implements LocationListener {// inner class

			public void onLocationChanged(Location location) {
				String message = String.format(
						"New Location \n Longitude: %1$s \n Latitude: %2$s",
						location.getLongitude(), location.getLatitude()
				);
				
				current_latitude=location.getLatitude();
				current_longitude=location.getLongitude(); 
				
				Toast.makeText(HomeActivity.this, message, Toast.LENGTH_LONG).show();// show the current location in pop up window
				check();
			}

			public void onStatusChanged(String s, int i, Bundle b) {
				Toast.makeText(HomeActivity.this, "Provider status changed",
						Toast.LENGTH_LONG).show();
			}

			public void onProviderDisabled(String s) {
				Toast.makeText(HomeActivity.this,
						"Provider disabled by the user. GPS turned off",
						Toast.LENGTH_LONG).show();// if gps is off show the message
			}

			public void onProviderEnabled(String s) {
				Toast.makeText(HomeActivity.this,
						"Provider enabled by the user. GPS turned on",
						Toast.LENGTH_LONG).show();// if the user enable the gps then show the message
			}

		}
	 
	 
	 public void onDestroy() {
	        //Cancel vibration when the application is about to close
	        if (vibrator != null)
	            vibrator.cancel();
	        super.onDestroy();
	    }
	 
	 

	 
	 public double CalculationByDistance() {
		
		    int Radius=6371;//radius of earth in Km         
		    double lat1 =Current_Location.latitude;
		    //double lat1=current_latitude;
		    double lat2 =Destination_Location.latitude;
		    double lon1 =Current_Location.longitude;
		    //double lon1=current_longitude;
		    double lon2 =Destination_Location.longitude;
		    double dLat = Math.toRadians(lat2-lat1);
		    double dLon = Math.toRadians(lon2-lon1);
		    double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
		    Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
		    Math.sin(dLon/2) * Math.sin(dLon/2);
		    double c = 2 * Math.asin(Math.sqrt(a));
		    double valueResult= Radius*c;
		    double km=valueResult/1;
		    DecimalFormat newFormat = new DecimalFormat("####");
		    int kmInDec =  Integer.valueOf(newFormat.format(km));
		    double meter = valueResult%1000;
		    Integer meterInDec = Integer.valueOf(newFormat.format(meter));
		    Log.i("Radius Value",""+valueResult+"   KM  "+kmInDec+" Meter   "+meterInDec);

		    return Radius * c;
		 }
	 
	 public void check(){
		 distance=CalculationByDistance();
		 final TextView text = (TextView) findViewById(R.id.alertmessageid);
			if(Destination_Location.latitude==0 && Destination_Location.longitude==0){
				text.setTextSize(40);
				text.setText("nothing has been added");
				
			}
			else
					text.setText("Destination Address:"+"\n\n"+"latitude: "+Destination_Location.latitude+"\n"+"longitude "+Destination_Location.longitude+"\n\n\n"+"Reminder Text:"+"\n"+Reminder.reminder_text);
		 
		 if(distance<100){
			 vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
			if(SettingActivity.tone.equals("VibrateOnce")){
			
			vibrator.vibrate(500);
					AlertDialog.Builder builder = new AlertDialog.Builder(
						      HomeActivity.this);
						    builder.setTitle("Alert Message");
						    builder.setMessage(Reminder.reminder_text+" in"+Destination_Location.address);
						    builder.setPositiveButton("OK",
						    new DialogInterface.OnClickListener() {
						     public void onClick(DialogInterface dialog,
						      int which) {
						      Log.e("info", "OK");
						    	// HomeActivity.this.finish();
						     }
						    });
						    builder.show();
			
			/* Alert Dialog Code Start*/     
           /* AlertDialog.Builder alert = new AlertDialog.Builder(context);
            alert.setTitle("Alert message"); //Set Alert dialog title here
            alert.setMessage(Reminder.reminder_text); //Message here
 
            alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
             // String value = input.getText().toString();
              // Do something with value!
                //You will get input data in this variable.
                finish();
 
              }
            });*/
						    
						  
					}
					else
						if(SettingActivity.tone.equals("VibratePattern")){
							vibrator.vibrate(pattern,-1);
							AlertDialog.Builder builder = new AlertDialog.Builder(
								      HomeActivity.this);
								    builder.setTitle("Alert Message");
								    builder.setMessage(Reminder.reminder_text+" in"+Destination_Location.address);
								    builder.setPositiveButton("OK",
								    new DialogInterface.OnClickListener() {
								     public void onClick(DialogInterface dialog,
								      int which) {
								      Log.e("info", "OK");
								    	// HomeActivity.this.finish(); 
								     }
								    });
								    builder.show();
							
							/* Alert Dialog Code Start*/     
				           /* AlertDialog.Builder alert = new AlertDialog.Builder(context);
				            alert.setTitle("Alert message"); //Set Alert dialog title here
				            alert.setMessage(Reminder.reminder_text); //Message here
				 
				            alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
				            public void onClick(DialogInterface dialog, int whichButton) {
				             // String value = input.getText().toString();
				              // Do something with value!
				                //You will get input data in this variable.
				                finish();
				 
				              }
				            });*/
								  
						}
							
				}
				
				
		 
	 }
	 
	
}
