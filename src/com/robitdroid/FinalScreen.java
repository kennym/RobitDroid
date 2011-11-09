package com.robitdroid;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import com.robitdroid.robit.Generator;

/**
 * Show Robit with the guessed number.
 * <p/>
 * Author: Kenny Meyer <knny.myer@gmail.com>
 * Date: 11/9/11
 * Time: 5:36 PM
 */
public class FinalScreen extends Activity {
    private Generator generator = Generator.getInstance();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.final_screen);

        Log.d("DEBUG", String.valueOf(generator.getFinal_number()));
        TextView final_number = (TextView) findViewById(R.id.final_number);
        final_number.setText(String.valueOf(generator.getFinal_number()));
    }
}
