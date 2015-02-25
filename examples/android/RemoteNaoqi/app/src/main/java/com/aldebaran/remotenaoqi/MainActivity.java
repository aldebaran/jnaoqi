package com.aldebaran.remotenaoqi;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity
		implements NavigationDrawerFragment.NavigationDrawerCallbacks {

	/**
	 * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
	 */
	private NavigationDrawerFragment mNavigationDrawerFragment;

	private CharSequence mTitle;

	private ArrayList<Fragment> fragments;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mNavigationDrawerFragment = (NavigationDrawerFragment)
				getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
		mTitle = getTitle();

		// Set up the drawer.
		fragments = new ArrayList<>();
		fragments.add(ConnectFragment.newInstance());

		mNavigationDrawerFragment.setUp(
				R.id.navigation_drawer,
				(DrawerLayout) findViewById(R.id.drawer_layout));


	}

	@Override
	public void onNavigationDrawerItemSelected(int position) {
		// update the main content by replacing fragments
		Fragment fragment = fragments.get(position) ;
		FragmentManager fragmentManager = getSupportFragmentManager();
		fragmentManager.beginTransaction()
				.replace(R.id.container, fragment)
				.commit();
	}





}
