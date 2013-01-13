package com.example.speed.reader;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class WordIterator extends Activity {

	String phrase;
	int wordIndex = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		initiate();
		String word=null;  
        int index=phrase.indexOf(" ", wordIndex);  
        
        if (index < 0) {  
            // not found  
            word = phrase.substring(wordIndex);  
        } else {  
            word = phrase.substring(wordIndex, index);  
        } 
        Intent a = new Intent(WordIterator.this, WordsDisplay.class);
		Bundle wordExport = new Bundle();
		wordExport.putString("word", word);
		a.putExtras(wordExport);
		startActivity(a);

	}

	private void initiate() {
		// TODO Auto-generated method stub
		Bundle phraseImport = getIntent().getExtras();
		phrase = phraseImport.getString("phrase");
	}
	
}
