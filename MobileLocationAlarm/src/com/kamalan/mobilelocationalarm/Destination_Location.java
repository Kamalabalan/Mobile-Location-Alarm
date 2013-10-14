package com.kamalan.mobilelocationalarm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Locale;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
 
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.location.Address;
import android.location.Geocoder;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
 
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;
 
public class Destination_Location extends FragmentActivity {
 
	GoogleMap googleMap;
	public static double latitude=0,longitude=0;
	Button button1;
	Context ctx;
	//Geocoder geocoder;
	public static String address;
	//public static String destination_address;
    
	 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.destination_location_layout);
       // geocoder = new Geocoder(this, Locale.ENGLISH);

        ctx=this;
        buttonOnClickListener();
        
        SupportMapFragment supportMapFragment = (SupportMapFragment)
        getSupportFragmentManager().findFragmentById(R.id.map);
 
        // Getting a reference to the map
        googleMap = supportMapFragment.getMap();
 
        // Setting a click event handler for the map
        googleMap.setOnMapClickListener(new OnMapClickListener() {
 
            @Override
            public void onMapClick(LatLng latLng) {
 
                // Creating a marker
                MarkerOptions markerOptions = new MarkerOptions();
 
                // Setting the position for the marker
                markerOptions.position(latLng);
                
               
                // Setting the title for the marker.
                // This will be displayed on taping the marker
                markerOptions.title(latLng.latitude + " : " + latLng.longitude);
               latitude=latLng.latitude;
               longitude=latLng.longitude;
               
             
               
              
            
              
             //  address=getAddress(ctx,latitude,longitude);  
 
                // Clears the previously touched position
                googleMap.clear();
 
                // Animating to the touched position
                googleMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
 
                // Placing a marker on the touched position
                googleMap.addMarker(markerOptions);
                
               // if(address==null)
                //	address="Difficult to get Address";
                
                //address=getAddress(ctx,latitude,longitude);
                //address=getAddress(ctx,latitude,longitude);
                address=getAddress();
                
            }
        });
        
       
        
    }
    
    public void buttonOnClickListener(){
    	final Context context=this;
		button1 = (Button) findViewById(R.id.button1);
		
		button1.setOnClickListener(new OnClickListener() {
			 
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(context, Reminder.class);
				startActivity(intent);
				
				
				
				
				
			}
 
		});
    }
    
  /* public  String getAddress(Context ctx, double latitude, double longitude) {
        StringBuilder result = new StringBuilder();
       // String add=null;
        try {
            Geocoder geocoder = new Geocoder(ctx, Locale.getDefault());
            List<Address> addresses = geocoder.getFromLocation(latitude, longitude, 1);
            if (addresses.size() > 0) {
                Address address = addresses.get(0);
				
				String locality=address.getLocality();
				String city=address.getCountryName();
				String region_code=address.getCountryCode();
				String zipcode=address.getPostalCode();
				//double lat =address.getLatitude();
				//double lon= address.getLongitude();
				
				//add=locality+city+region_code;
                result.append(locality+" ");
				
                result.append(city+" "+ region_code+" ");
				
				result.append(zipcode);
				
            }
        } catch (IOException e) {
            Log.e("tag", e.getMessage());
        }

        return result.toString();
       // return add;
    }*/
    
    
    /*private String getAddress(double latitude, double longitude) {
        StringBuilder result = new StringBuilder();
        try {
            Geocoder geocoder = new Geocoder(this, Locale.getDefault());
            List<Address> addresses = geocoder.getFromLocation(latitude, longitude, 1);
            if (addresses.size() > 0) {
                Address address = addresses.get(0);
                result.append(address.getLocality()).append("\n");
                result.append(address.getCountryName());
            }
        } catch (IOException e) {
            Log.e("tag", e.getMessage());
        }

        return result.toString();
    }*/
    
    public String getAddress(){
    	Geocoder geocoder = new Geocoder(this, Locale.ENGLISH);
		String ret = "";
		try {
			List<Address> addresses = geocoder.getFromLocation(
					latitude,longitude, 1);
			if (addresses != null) {
				Address returnedAddress = addresses.get(0);
				StringBuilder strReturnedAddress = new StringBuilder(
						"Address:\n");
				for (int i = 0; i < returnedAddress.getMaxAddressLineIndex(); i++) {
					strReturnedAddress
							.append(returnedAddress.getAddressLine(i)).append(
									"\n");
				}
				ret = strReturnedAddress.toString();
			} else {
				ret = "No Address returned!";
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ret = "Can't get Address!";
		}
		return ret;
	}


    
	
    
    
 
   
}