package com.kamalan.mobilelocationalarm.test;

import android.content.Intent;
import android.test.suitebuilder.annotation.SmallTest;
import android.widget.TextView;

import com.kamalan.mobilelocationalarm.HelpActivity;

public class HelpActivityTest extends android.test.ActivityUnitTestCase<HelpActivity> {


private int textview1;
private HelpActivity activity;

public HelpActivityTest() {
super(com.kamalan.mobilelocationalarm.HelpActivity.class);
}

@Override
protected void setUp() throws Exception {
super.setUp();
Intent intent = new Intent(getInstrumentation().getTargetContext(),
		HelpActivity.class);
startActivity(intent, null, null);
activity = getActivity();
}

@SmallTest
public void testLayout() {

// test the Alert heading textview layout
textview1 = com.kamalan.mobilelocationalarm.R.id.textView1;
assertNotNull(activity.findViewById(textview1));
TextView view1 = (TextView) activity.findViewById(textview1);
assertEquals("Incorrect label of the button", "Introduction",
		view1.getText());
}


}
