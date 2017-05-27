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

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    private Button mFindRepsButton;
    private EditText mLocationEditText;
    private TextView mArticleOneTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mArticleOneTextView = (TextView) findViewById(R.id.articleOneTextView);
        Typeface cooperHewitt = Typeface.createFromAsset(getAssets(),
                "fonts/cooperhewitt-medium.otf");
        mArticleOneTextView.setTypeface(cooperHewitt);
        mLocationEditText = (EditText) findViewById(R.id.locationEditText);
        mFindRepsButton = (Button) findViewById(R.id.findRepsButton);
        mFindRepsButton.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View v) {

                String location = mLocationEditText.getText().toString();
                Log.d(TAG, location);
                Intent intent = new Intent(MainActivity.this, RepListActivity.class);
                intent.putExtra("location", location);
                startActivity(intent);

                }
            });
    }
}
