package com.example.speed.reader;

import com.example.speed.reader.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.widget.TextView;


public class WordsDisplay extends Activity {
	TextView wordDisplay;
	String phrase;
	int wordIndex = 0;
	int delay;
	final Handler timerHandler = new Handler();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.words_display);
		initiate();
		timerHandler.postDelayed(nextWordTask, 50);
		
	}
public final Runnable nextWordTask = new Runnable() {
		
		public void run() {
			
	
			String word=null;  
	        int index=phrase.indexOf(" ", wordIndex);  
	        
	        if (index < 0) {  
	            // not found  
	            word=phrase.substring(wordIndex);  
	        } else {  
	            word=phrase.substring(wordIndex, index);  
	        } 
	        
	        
	        wordDisplay.setTextSize(75);
	        wordDisplay.setGravity(Gravity.CENTER);
	        wordDisplay.setText(word);
	        if (index == -1){
	        	wordDisplay.setText(word);
	        	wordIndex = 0;
	        }else{
	        wordIndex =index +1;
	        timerHandler.postDelayed(this, delay);
	        }

			
		}
	};


	private void initiate() {
		// TODO Auto-generated method stub
		wordDisplay = (TextView) findViewById(R.id.tvWordDisplay);
		Bundle Import = getIntent().getExtras();
		phrase = Import.getString("phrase");
		delay = Import.getInt("delay");
		
	}
}
