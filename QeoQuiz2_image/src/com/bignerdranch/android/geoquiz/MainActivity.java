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
	private ImageButton mPrevButton;
	private ImageButton mNextButton;
	private TextView mQuestionTextView;
	
	private TrueFalse[] mQuestionBank = new TrueFalse[]
	{
		new TrueFalse(R.string.question_ocean, true),
		new TrueFalse(R.string.question_mideast, false),
		new TrueFalse(R.string.question_africa, false),
		new TrueFalse(R.string.question_americas, true),
		new TrueFalse(R.string.question_asia, true),
	};
	private int mCurrentIndex = 0;
	
	private void updateQuestion()
	{
		int question = mQuestionBank[mCurrentIndex].getQuestion();
		mQuestionTextView.setText(question);
	}
	
	private void checkAnswer(boolean userPressedTrue)
	{
		boolean answerIsTrue = mQuestionBank[mCurrentIndex].isTrueQuestion();
		int messageResId = 0;
		
		if(userPressedTrue == answerIsTrue)
		{
			messageResId = R.string.correct_toast;
		}
		else
		{
			messageResId = R.string.incorrect_toast;
		}
		
		Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();
	}
	
	@Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
		mQuestionTextView = (TextView)findViewById(R.id.question_text_view);
		mQuestionTextView.setOnClickListener(new View.OnClickListener()
			{
				@Override
				public void onClick(View v)
				{
					mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
					updateQuestion();
				}
			});
		
		mTrueButton = (Button)findViewById(R.id.true_button);
		mTrueButton.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){
				checkAnswer(true);
			}
		});
		
		mFalseButton = (Button)findViewById(R.id.false_button);
		mFalseButton.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){
				checkAnswer(false);
			}
		});
		
		mPrevButton = (ImageButton)findViewById(R.id.prev_button);
		mPrevButton.setOnClickListener(new View.OnClickListener()
			{
				@Override
				public void onClick(View v)
				{
					if ((mCurrentIndex - 1) < 0)
					{
						mCurrentIndex = mQuestionBank.length - 1;
					}
					else
					{
					mCurrentIndex = (mCurrentIndex - 1) % mQuestionBank.length;
					}
					updateQuestion();
				}
			});
		
		mNextButton = (ImageButton)findViewById(R.id.next_button);
		mNextButton.setOnClickListener(new View.OnClickListener()
			{
				@Override
				public void onClick(View v)
				{
					mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
					updateQuestion();
				}
			});
		updateQuestion();
    }
}
