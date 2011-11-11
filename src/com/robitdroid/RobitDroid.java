package com.robitdroid;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class RobitDroid extends Activity {
    private ImageView imageview;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        imageview = (ImageView) findViewById(R.id.ImageViewRobit);
        imageview.getLayoutParams().height = 400;
    }

    public void CreateMenu(Menu menu) {
        MenuItem about = menu.add(0, 0, 0, "About");
        {
            about.setAlphabeticShortcut('a');
        }
        MenuItem quit = menu.add(0, 0, 0, "Quit");
        {
            quit.setAlphabeticShortcut('q');
        }
    }

    private boolean MenuChoice(MenuItem item) {
        switch (item.getItemId()) {
            case 0:
                //Intent i = new Intent(null, About.class);
                //startActivity(i);
                return true;
            case 1:
                // TODO
                return true;
        }
        return false;
    }

    public void selfStart(View view) {
        Log.v("RobitDroid", "In selfStart method");
        // Start new game
        Intent i = new Intent(view.getContext(), GameScreen.class);
        startActivity(i);
    }

    public void showInstructions(View view) {
        showDialog(0);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case 0:
                return new AlertDialog.Builder(this)
                        .setIcon(R.drawable.icon)
                        .setTitle("Instructions")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                //Toast.makeText(getBaseContext(), "OK clicked!", Toast.LENGTH_SHORT).show();
                            }
                        }).create();
        }
        return null;
    }
}
