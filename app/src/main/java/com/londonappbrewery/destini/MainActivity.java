package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mStoryTextView;
    Button mButtonTop;
    Button mButtonBottom;
    int mStoryIndex = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mStoryTextView = findViewById(R.id.storyTextView);
        mButtonTop = findViewById(R.id.buttonTop);
        mButtonBottom = findViewById(R.id.buttonBottom);

        mButtonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processClick(true);
                updateUI();
            }
        });

        mButtonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processClick(false);
                updateUI();
            }
        });

    }

    protected void processClick(boolean isTopButton) {
        if (isTopButton) {
            if (mStoryIndex == 1 || mStoryIndex == 2)
                mStoryIndex = 3;
            else if (mStoryIndex == 3)
                mStoryIndex = 6;
        } else {
            if (mStoryIndex == 1)
                mStoryIndex = 2;
            else if (mStoryIndex == 2)
                mStoryIndex = 4;
            else if (mStoryIndex == 3)
                mStoryIndex = 5;
        }
    }

    protected void updateUI() {

        if (mStoryIndex == 1) {
            mStoryTextView.setText(R.string.T1_Story);
            mButtonTop.setText(R.string.T1_Ans1);
            mButtonBottom.setText(R.string.T1_Ans2);
        } else if (mStoryIndex == 2) {
            mStoryTextView.setText(R.string.T2_Story);
            mButtonTop.setText(R.string.T2_Ans1);
            mButtonBottom.setText(R.string.T2_Ans2);
        } else if (mStoryIndex == 3) {
            mStoryTextView.setText(R.string.T3_Story);
            mButtonTop.setText(R.string.T3_Ans1);
            mButtonBottom.setText(R.string.T3_Ans2);
        } else if (mStoryIndex == 4) {
            mStoryTextView.setText(R.string.T4_End);
        } else if (mStoryIndex == 5) {
            mStoryTextView.setText(R.string.T5_End);
        } else if (mStoryIndex == 6) {
            mStoryTextView.setText(R.string.T6_End);
        }

        if (mStoryIndex == 4 || mStoryIndex == 5 || mStoryIndex == 6) {
            mButtonTop.setVisibility(View.GONE);
            mButtonBottom.setVisibility(View.GONE);
        }
    }
}
