package com.example.speed.reader;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {

	Button read;
	TextView wordDisplay;
	EditText input;
	EditText WPMuinput;
	String wordList;
	String WPMstring;
	int WPM;
	int wordIndex = 0;
	int delay;
	String phrase;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initiate();
		read.setOnClickListener(this);

	}

	private void initiate() {
		// TODO Auto-generated method stub
		read = (Button) findViewById(R.id.bRead);
		wordDisplay = (TextView) findViewById(R.id.tvText);
		input = (EditText) findViewById(R.id.etInput);
		WPMuinput = (EditText) findViewById(R.id.etWPM);

	}

	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		phrase = input.getText().toString();
		wpmCalculator();
		bundle();
	}

	private void bundle() {
		// TODO Auto-generated method stub
		Intent a = new Intent(MainActivity.this, WordsDisplay.class);
		Bundle Export = new Bundle();
		Export.putString("phrase", phrase);
		Export.putInt("delay", delay);
		a.putExtras(Export);
		startActivity(a);
	}

	private void wpmCalculator() {
		// TODO Auto-generated method stub
		WPMstring = WPMuinput.getText().toString();
		if (WPMstring.matches("")) {
			wordDisplay.setText("Please enter WPM");
		}
		WPM = Integer.parseInt(WPMstring);
		delay = 60000 / WPM;

	}

}
