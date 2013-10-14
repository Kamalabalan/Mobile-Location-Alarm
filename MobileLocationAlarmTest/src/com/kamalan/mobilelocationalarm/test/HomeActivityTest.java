package com.kamalan.mobilelocationalarm.test;

import android.content.Intent;
import android.test.suitebuilder.annotation.SmallTest;
import android.widget.Button;
import android.widget.TextView;

import com.kamalan.mobilelocationalarm.HomeActivity;

public class HomeActivityTest extends android.test.ActivityUnitTestCase<HomeActivity> {

private int current_buttonId1,destination_buttonId2,gps_buttonId3;
private int textview1, textview2;
private HomeActivity activity;

public HomeActivityTest() {
super(com.kamalan.mobilelocationalarm.HomeActivity.class);
}

@Override
protected void setUp() throws Exception {
super.setUp();
Intent intent = new Intent(getInstrumentation().getTargetContext(),
		HomeActivity.class);
startActivity(intent, null, null);
activity = getActivity();
}

@SmallTest
public void testLayout() {

// test the Alert heading textview layout
textview1 = com.kamalan.mobilelocationalarm.R.id.alertid;
assertNotNull(activity.findViewById(textview1));
TextView view1 = (TextView) activity.findViewById(textview1);
assertEquals("Incorrect label of the button", "Nothing has been added",
		view1.getText());

// test the Alert ,essage textview layout
textview2 = com.kamalan.mobilelocationalarm.R.id.alertmessageid;
assertNotNull(activity.findViewById(textview2));
TextView view2 = (TextView) activity.findViewById(textview2);
assertEquals("Incorrect label of the button", "Alert",
		view2.getText());


// test the current location button layout
current_buttonId1 = com.kamalan.mobilelocationalarm.R.id.currentlocationid;
assertNotNull(activity.findViewById(current_buttonId1));
Button view3 = (Button) activity.findViewById(current_buttonId1);
assertEquals("Incorrect label of the button", "Current Location", view3.getText());

//test the destination location button layout
destination_buttonId2 = com.kamalan.mobilelocationalarm.R.id.destinationid;
assertNotNull(activity.findViewById(destination_buttonId2));
Button view4 = (Button) activity.findViewById(destination_buttonId2);
assertEquals("Incorrect label of the button", "Add Destination Place", view4.getText());

//test the gps current location button layout
gps_buttonId3 = com.kamalan.mobilelocationalarm.R.id.gpscurrentlocatoinid;
assertNotNull(activity.findViewById(gps_buttonId3));
Button view5 = (Button) activity.findViewById(gps_buttonId3);
assertEquals("Incorrect label of the button", "ActivateCurrentLocation", view5.getText());

}


@Override
protected void tearDown() throws Exception {

super.tearDown();
}

}
