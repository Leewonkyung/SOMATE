package com.example.s.cookcook;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class MainActivity extends Activity {
	/** Called when the activity is first created. */

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		TabHost tabHost = (TabHost)findViewById(R.id.tab_host);
		tabHost.setup();

		// Tab1 Setting
		TabSpec tabSpec1 = tabHost.newTabSpec("Tab1");
		tabSpec1.setIndicator("Main"); // Tab Subject
		tabSpec1.setContent(R.id.tab_view1); // Tab Content
		tabHost.addTab(tabSpec1);

		// Tab2 Setting
		TabSpec tabSpec2 = tabHost.newTabSpec("Tab2");
		tabSpec2.setIndicator("Cate"); // Tab Subject
		tabSpec2.setContent(R.id.tab_view2); // Tab Content
		tabHost.addTab(tabSpec2);

		// Tab3 Setting
		TabSpec tabSpec3 = tabHost.newTabSpec("Tab3");
		tabSpec3.setIndicator("Reci"); // Tab Subject
		tabSpec3.setContent(R.id.tab_view3); // Tab Content
		tabHost.addTab(tabSpec3);

		// Tab4 Setting
		TabSpec tabSpec4 = tabHost.newTabSpec("Tab4");
		tabSpec4.setIndicator("User"); // Tab Subject
		tabSpec4.setContent(R.id.tab_view4); // Tab Content
		tabHost.addTab(tabSpec4);

		// show First Tab Content
		tabHost.setCurrentTab(0);
	}
}