package com.robitdroid;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.robitdroid.robit.Generator;

import java.util.ArrayList;

public class GameScreen extends Activity {
    private Generator generator = Generator.getInstance();
    private Adapter adapter;

    private int step_number = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_screen);

        refreshGrid();
    }

    public void yesButtonClick(View view) {
        Log.v("ROBIT", "'Yes' button clicked.");
        this.generator.yes();
        step_number++;
        refreshGrid();

        if (step_number >= 4) {
            showFinalScreen(view);
        }
    }

    public void noButtonClick(View view) {
        Log.v("ROBIT", "'No' button clicked.");
        this.generator.no();
        step_number++;
        refreshGrid();
        if (step_number >= 4) {
            showFinalScreen(view);
        }
    }

    private void showFinalScreen(View view) {
        Intent i = new Intent(view.getContext(), FinalScreen.class);
        startActivity(i);
    }

    private void refreshGrid() {
        adapter = new MyAdapter(this);
        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter((ListAdapter) adapter);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Toast.makeText(GameScreen.this, "" + position, Toast.LENGTH_SHORT).show();
            }
        });

    }

    public class MyAdapter extends BaseAdapter {

        private Context context;
        private ArrayList<Integer> texts = new ArrayList();

        public MyAdapter(Context context) {
            this.context = context;
            this.texts = generator.generateNumbers(9);
        }

        public int getCount() {
            return texts.size();
        }

        public Object getItem(int position) {
            return texts.get(position);
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            TextView tv;
            if (convertView == null) {
                tv = new TextView(context);
                tv.setLayoutParams(new GridView.LayoutParams(85, 85));
                tv.setGravity(0x11); // Center
                tv.setTextSize(20);
            } else {
                tv = (TextView) convertView;
            }

            int number = texts.get(position);

            if (number == 0) {
                tv.setText("");
            } else {
                tv.setText(String.valueOf(number));
            }
            return tv;
        }
    }
}
