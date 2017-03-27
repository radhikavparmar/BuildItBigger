package com.example.android.androiddisplayinglibrary;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {
    private TextView mJokeTextview;
    private static final String INTENT_KEY = "JOKE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        mJokeTextview = (TextView)findViewById(R.id.joke_in_android_library);
        String joke = getIntent().getStringExtra(INTENT_KEY);
        if(joke!=null){
            mJokeTextview.setText(joke);
        }
    }
    public void selectFrag(View view) {

        Fragment fr = new DisplayActivityFragment();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.commit();
    }
}
