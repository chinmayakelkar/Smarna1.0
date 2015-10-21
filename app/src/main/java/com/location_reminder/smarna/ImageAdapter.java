package com.location_reminder.smarna;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by ng123 on 10/18/2015.
 */
public class ImageAdapter extends BaseAdapter {

    int layoutResourceId;
    private Context mContext;
    private final String[] task_template;
    private final int[] Imageid;

    public ImageAdapter(Context c,String[] task_template,int[] Imageid ) {
        mContext = c;
        this.Imageid = Imageid;
        this.task_template = task_template;
    }

    public int getCount() {
        return task_template.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {

            grid = new View(mContext);
            grid = inflater.inflate(R.layout.grid_single, null);
            TextView textView = (TextView) grid.findViewById(R.id.grid_text);
            ImageView imageView = (ImageView)grid.findViewById(R.id.grid_image);
            textView.setText(task_template[position]);
            imageView.setImageResource(Imageid[position]);
            if(position== 0){
                imageView.setBackgroundColor(Color.parseColor("#9EE4B5"));
            }
            else if(position== 1){
                imageView.setBackgroundColor(Color.parseColor("#F6BF77"));
            }
            else if(position== 2){
                imageView.setBackgroundColor(Color.parseColor("#8DC3F9"));
            }
            else if(position== 3){
                imageView.setBackgroundColor(Color.parseColor("#EFB9B9"));
            }
            else if(position== 4){
                imageView.setBackgroundColor(Color.parseColor("#E9EF8F"));
            }
            else if(position== 5){
                imageView.setBackgroundColor(Color.parseColor("#B6EFFF"));
            }
            else if(position== 6){
                imageView.setBackgroundColor(Color.parseColor("#E9AFE0"));
            }
            else if(position== 7){
                imageView.setBackgroundColor(Color.parseColor("#BAB371"));
            }
            else if(position== 8){
                imageView.setBackgroundColor(Color.parseColor("#D0CACA"));
            }
        } else {
            grid = (View) convertView;
        }
        return grid;
    }
}

