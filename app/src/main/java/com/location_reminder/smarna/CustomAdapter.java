package com.location_reminder.smarna;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ng123 on 10/8/2015.
 */
public class CustomAdapter extends BaseExpandableListAdapter{

    private Context c;
    private ArrayList<Task> task;
    private LayoutInflater inflator;

    public CustomAdapter(Context c, ArrayList<Task> task){
        this.c=c;
        this.task=task;
        inflator= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getGroupCount() {
        return task.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return task.get(groupPosition).task_option.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return task.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return task.get(groupPosition).task_option.get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView=inflator.inflate(R.layout.tasks, null) ;
        }
        Task t =(Task) getGroup(groupPosition);
        TextView nameTv=(TextView) convertView.findViewById(R.id.textView2);
        String name=t.Name;
        nameTv.setText(name);
        /*ImageView img=(ImageView) convertView.findViewById(R.id.imageView2);

        if(name == "Man") {
            img.setImageResource(R.drawable.button_plus_blue);
        }
        if(name == "Arsenal") {
            img.setImageResource(R.drawable.button_plus_blue);
        }*/
        convertView.setBackgroundColor(Color.LTGRAY);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        if (convertView==null)
        {
            convertView= inflator.inflate(R.layout.task_options, null);
        }
        String child=(String) getChild(groupPosition, childPosition);
        TextView nameTv=(TextView) convertView.findViewById(R.id.textView);
        ImageView img=(ImageView) convertView.findViewById(R.id.imageView);
        nameTv.setText(child);

        if(child=="Edit"){
            img.setImageResource(R.drawable.edit);
        }
        else if(child=="Complete"){
            img.setImageResource(R.drawable.check_mark);
        }
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition)
    {
        return true;
    }
}
