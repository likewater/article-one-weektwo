package com.likewater.articleone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.graphics.Typeface;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    //public static final String TAG = MainActivity.class.getSimpleName();
    @Bind(R.id.findRepsButton) Button mFindRepsButton;
    @Bind(R.id.locationEditText) EditText mLocationEditText;
    @Bind(R.id.articleOneTextView) TextView mArticleOneTextView;
    @Bind(R.id.articleOneTextView2) TextView mArticleOneTextView2;
    @Bind(R.id.findAboutPageButton) Button mFindAboutPageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //mArticleOneTextView = (TextView) findViewById(R.id.articleOneTextView);
        Typeface openSans = Typeface.createFromAsset(getAssets(),
                "fonts/opensans-regular.ttf");
        mArticleOneTextView.setTypeface(openSans);
        mArticleOneTextView2.setTypeface(openSans);
        //mLocationEditText = (EditText) findViewById(R.id.locationEditText);
        //mFindRepsButton = (Button) findViewById(R.id.findRepsButton);
        mFindRepsButton.setOnClickListener(this);
        mFindAboutPageButton.setOnClickListener(this);
//            @Override
//                public void onClick(View v) {
//
//                String location = mLocationEditText.getText().toString();
//                //Log.d(TAG, location);
//                Intent intent = new Intent(MainActivity.this, RepListActivity.class);
//                intent.putExtra("location", location);
//                startActivity(intent);
//
//                }
//            });

    }
        @Override
        public void onClick(View v){
            if(v == mFindRepsButton){
                String location = mLocationEditText.getText().toString();
                Intent intent = new Intent(MainActivity.this, RepListActivity.class);
                intent.putExtra("location", location);
                startActivity(intent);
            }
            if(v == mFindAboutPageButton){
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);
            }
    }
}
