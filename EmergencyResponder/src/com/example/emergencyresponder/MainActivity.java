package com.example.emergencyresponder;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;

public class MainActivity extends Activity {

	ReentrantLock lock;
	CheckBox locationCheckBox;
	ArrayList<String> requesters;
	ArrayAdapter<String> aa;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		lock = new ReentrantLock();
		requesters = new ArrayList<String>();
		wireUpControls();
	}

	private void wireUpControls() {
		locationCheckBox = (CheckBox) findViewById(R.id.checkboxSendLocation);
		ListView myListView = (ListView) findViewById(R.id.myListView);
		int layoutID = android.R.layout.simple_list_item_1;
		aa = new ArrayAdapter<String>(this, layoutID, requesters);
		myListView.setAdapter(aa);

		Button okButton = (Button) findViewById(R.id.okButton);
		okButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				respond(true, locationCheckBox.isChecked());
			}
		});

		Button notOkButton = (Button) findViewById(R.id.notOkButton);
		okButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				respond(false, locationCheckBox.isChecked());
			}
		});

		Button autoResponderButton = (Button) findViewById(R.id.autoResponder);
		okButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				statAutoResponder();
			}
		});
	}

	private void statAutoResponder() {
		// TODO Auto-generated method stub

	}

	private void respond(boolean b, boolean checked) {
		// TODO Auto-generated method stub

	}

}
