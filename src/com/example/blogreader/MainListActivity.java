package com.example.blogreader;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;

public class MainListActivity extends ListActivity {
	
	protected String[] mAndroidNames = {
			"Android Beta",
			"Android 1.0",
			"Android 1.1",
			"Cupcake",
			"Donut",
			"Eclair",
			"Froyo",
			"Gingerbread",
			"Honeycomb",
			"Ice Cream Sandwich",
			"Jelly Bean",
			"Kitkat"
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_list);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_list, menu);
		return true;
	}

}
