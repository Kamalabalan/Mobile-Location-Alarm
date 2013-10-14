package com.kamalan.mobilelocationalarm.test;



import android.content.Intent;
import android.test.suitebuilder.annotation.SmallTest;
import android.widget.Button;
import android.widget.TextView;


import com.kamalan.mobilelocationalarm.Reminder;

public class ReminderAcivityTest extends android.test.ActivityUnitTestCase<Reminder> {

public ReminderAcivityTest() {
	super(com.kamalan.mobilelocationalarm.Reminder.class);
		// TODO Auto-generated constructor stub
	}


private int current_buttonId1,destination_buttonId2,gps_buttonId3;
private int textview1, textview2,textview3;
private int buttonId1;
private int editext1;
private Reminder activity;



@Override
protected void setUp() throws Exception {
super.setUp();
Intent intent = new Intent(getInstrumentation().getTargetContext(),
		Reminder.class);
startActivity(intent, null, null);
activity = getActivity();
}

@SmallTest
public void testLayout() {

// test the Destination location heading address textview layout
textview1 = com.kamalan.mobilelocationalarm.R.id.textView1;
assertNotNull(activity.findViewById(textview1));
TextView view1 = (TextView) activity.findViewById(textview1);
assertEquals("Incorrect label of the button", "Destination Place",
		view1.getText());

// test the reminder text heading textview layout
textview2 = com.kamalan.mobilelocationalarm.R.id.textView2;
assertNotNull(activity.findViewById(textview2));
TextView view2 = (TextView) activity.findViewById(textview2);
assertEquals("Incorrect label of the button", "What to do?",
		view2.getText());


//test the destination address textview layout
textview3 = com.kamalan.mobilelocationalarm.R.id.textView3;
assertNotNull(activity.findViewById(textview3));
TextView view6 = (TextView) activity.findViewById(textview3);
assertEquals("Incorrect label of the button", "",
		view6.getText());

// test the current location button layout
buttonId1 = com.kamalan.mobilelocationalarm.R.id.button1;
assertNotNull(activity.findViewById(buttonId1));
Button view3 = (Button) activity.findViewById(buttonId1);
assertEquals("Incorrect label of the button", "OK", view3.getText());



}


@Override
protected void tearDown() throws Exception {

super.tearDown();
}

}
