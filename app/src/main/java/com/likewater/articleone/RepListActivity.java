package com.likewater.articleone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RepListActivity extends AppCompatActivity {
    @Bind(R.id.locationTextView) TextView mLocationTextView;
    @Bind(R.id.repListView) ListView mListView;
    private String[] reps = new String[] {
           "Ron Wyden", "JeffMerkley", "Suzanne Bonamici", "Greg Walden",
            "Earl Blumenaur", "Peter DeFazio", "Kurt Schrader"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rep_list);
        ButterKnife.bind(this);
        //mListView = (ListView) findViewById(R.id.repListView);
        //mLocationTextView = (TextView) findViewById(R.id.locationTextView);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,
                reps);
        mListView.setAdapter(adapter);


        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String rep = ((TextView) view).getText().toString();

                Toast.makeText(RepListActivity.this, rep, Toast.LENGTH_LONG).show();
            }

        });

        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        mLocationTextView.setText("Here are all the reps near: " + location);
    }
}
