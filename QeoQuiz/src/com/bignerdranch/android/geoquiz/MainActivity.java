package com.bignerdranch.android.geoquiz;

import android.app.Activity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

public class MainActivity extends Activity
{
    /** Called when theactivity is first created. */
    
	private Button mTrueButton;
	private Button mFalseButton;
	
	@Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
		mTrueButton = (Button)findViewById(R.id.true_button);
		mTrueButton.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){
				Toast.makeText(MainActivity.this,
							   getString(R.string.incorrect_toast),
							   Toast.LENGTH_SHORT).show();
			}
		});
		
		mFalseButton = (Button)findViewById(R.id.false_button);
		mFalseButton.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){
				Toast.makeText(MainActivity.this,
								getString(R.string.correct_toast),
								Toast.LENGTH_SHORT).show();
				
			}
		});
    }
}
