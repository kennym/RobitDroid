package com.robitdroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class RobitDroid extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void selfStart(View view) {
        Log.v("RobitDroid", "In selfStart method");
        // Start new game
        Intent i = new Intent(view.getContext(), GameScreen.class);
        startActivity(i);
    }
}