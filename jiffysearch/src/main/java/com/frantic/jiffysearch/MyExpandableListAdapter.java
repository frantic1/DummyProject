package com.frantic.jiffysearch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Frantic on 4/18/2016.
 */
public class MyExpandableListAdapter extends BaseExpandableListAdapter {
    private Context context;
    private ArrayList<ParentRow> parentRowList;
    private ArrayList<ParentRow> originalList;

    public MyExpandableListAdapter(Context context, ArrayList<ParentRow> originalList) {
        this.context = context;
        this.parentRowList = new ArrayList<>();
        parentRowList.addAll(originalList);
        this.originalList = new ArrayList<>();
        originalList.addAll(originalList);
    }

    @Override
    public int getGroupCount() {
        return parentRowList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return parentRowList.get(groupPosition).getChildRowList().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return parentRowList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return parentRowList.get(groupPosition).getChildRowList().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        ParentRow parentRow = (ParentRow) getGroup(groupPosition);
        if (convertView==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.parent_row, parent,false);
        }
        TextView parentTitle = (TextView) convertView.findViewById(R.id.parent_text);
        parentTitle.setText(parentRow.getTitle());
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildRow childRow = (ChildRow) getChild(groupPosition,childPosition);
        if (convertView==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.child_row, parent,false);
        }
        ImageView imageView = (ImageView) convertView.findViewById(R.id.child_icon);
        final TextView title = (TextView) convertView.findViewById(R.id.child_text);

        final View finalConvertView = convertView;
        imageView.setImageResource(childRow.getIcon());
        title.setText(childRow.getTitle());
        title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(finalConvertView.getContext(),title.getText(),Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    public void filterData(String query){
        query = query.toLowerCase();
        parentRowList.clear();
        if (query.isEmpty()){
            parentRowList.addAll(originalList);
        }else {
            for (ParentRow parentRow: originalList){
                List<ChildRow> childRows = parentRow.getChildRowList();
                List<ChildRow> newList = new ArrayList<>();

                for (ChildRow childRow: childRows){
                    if (childRow.getTitle().toLowerCase().contains(query)){
                        newList.add(childRow);
                    }
                }
                if (newList.size()>0){
                    ParentRow nparent = new ParentRow(parentRow.getTitle(),newList);
                    parentRowList.add(nparent);
                }
            }
        }
        notifyDataSetChanged();
    }
}
