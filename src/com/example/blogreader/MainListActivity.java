package com.example.blogreader;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.app.ListActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

public class MainListActivity extends ListActivity {
	
	protected String[] mBlogPostTitles;
	public static final int NUMBER_OF_POSTS = 20;
	public static final String TAG = MainListActivity.class.getSimpleName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_list);
		
		GetBlogPostsTask getBlogPostsTask = new GetBlogPostsTask();
		getBlogPostsTask.execute();
		
//		Toast.makeText(this, getString(R.string.no_items), Toast.LENGTH_LONG).show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_list, menu);
		return true;
	}
	
	private class GetBlogPostsTask extends AsyncTask<Object, Void, String> {

		@Override
		protected String doInBackground(Object... params) {
			int responseCode = -1;
			try {
				URL blogFeedUrl = new URL("http://blog.teamtreehouse.com/api/get_recent_summary/?count=20");
				HttpURLConnection connection = (HttpURLConnection) blogFeedUrl.openConnection();
				connection.connect();
				
				responseCode = connection.getResponseCode();
				Log.i(TAG, "Code: " + responseCode);
			} catch (MalformedURLException e) {
				Log.e(TAG, "Exception caught: ", e);
			} catch (IOException e) {
				Log.e(TAG, "Exception caught: ", e);
			}
			
			return "Code: " + responseCode;
		}
		
	}

}
