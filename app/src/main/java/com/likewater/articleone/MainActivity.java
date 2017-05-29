package com.likewater.articleone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.graphics.Typeface;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;

import static android.R.id.input;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.findRepsButton) Button mFindRepsButton;
    @Bind(R.id.locationEditText) EditText mLocationEditText;
    @Bind(R.id.articleOneTextView) TextView mArticleOneTextView;
    @Bind(R.id.articleOneTextView2) TextView mArticleOneTextView2;
    @Bind(R.id.findAboutPageButton) Button mFindAboutPageButton;

    private String[] numbers = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Typeface openSans = Typeface.createFromAsset(getAssets(),
                "fonts/opensans-regular.ttf");
        mArticleOneTextView.setTypeface(openSans);
        mArticleOneTextView2.setTypeface(openSans);
        mFindRepsButton.setOnClickListener(this);
        mFindAboutPageButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v){
        if(v == mFindRepsButton) {
            String location = mLocationEditText.getText().toString();
            char[] userInputNumbers = location.toCharArray();
            int stringLength = location.length();
            if (stringLength == 5) {
                Intent intent = new Intent(MainActivity.this, RepListActivity.class);
                intent.putExtra("location", location);
                startActivity(intent);
            } else {
                Toast.makeText(MainActivity.this, "Please Enter A Five Digit Zip Code", Toast.LENGTH_LONG).show();
            }
        }
        if(v == mFindAboutPageButton){
            Intent intent = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(intent);
        }
    }
}
