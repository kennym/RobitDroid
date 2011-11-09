package com.robitdroid;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.robitdroid.robit.Generator;

public class GameScreen extends Activity {
    private Generator generator;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_screen);

        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new MyAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Toast.makeText(GameScreen.this, "" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void yesButtonClick(View view) {
        // TODO
    }

    public void noButtonClick(View view) {
        // TODO
    }

    public class MyAdapter extends BaseAdapter {

        private Context context;
        private Integer[] texts = generator.generateNumbers(9);

        public MyAdapter(Context context) {
            this.context = context;
        }

        public int getCount() {
            return texts.length;
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            TextView tv;
            if (convertView == null) {
                tv = new TextView(context);
                tv.setLayoutParams(new GridView.LayoutParams(85, 85));
            } else {
                tv = (TextView) convertView;
            }

            tv.setText(Integer.toString(texts[position]));
            return tv;
        }
    }
}
