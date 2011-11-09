package com.robitdroid;

import android.app.Activity;
import android.content.Context;
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

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_screen);

        refreshGrid();
    }

    public void yesButtonClick(View view) {
        Log.v("ROBIT", "Yes button clicked.");
        this.generator.yes();
        refreshGrid();
    }

    public void noButtonClick(View view) {
        Log.v("ROBIT", "No button clicked.");
        this.generator.no();
        refreshGrid();
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
            } else {
                tv = (TextView) convertView;
            }

            tv.setText(String.valueOf(texts.get(position)));
            return tv;
        }
    }
}
