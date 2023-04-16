package com.piyush2k24.mdcandroid;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.google.android.material.textview.MaterialTextView;

public class MDCAdapter extends BaseAdapter {
    Context context;
    String[] Widgets;
    LayoutInflater inflater;

    public MDCAdapter(Context context, String[] widgets) {
        this.context = context;
        Widgets = widgets;
        inflater=LayoutInflater.from(context);
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public String[] getWidgets() {
        return Widgets;
    }

    public void setWidgets(String[] widgets) {
        Widgets = widgets;
    }

    @Override
    public int getCount() {
        return Widgets.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView=inflater.inflate(R.layout.lst_widgets,parent,false);
        MaterialTextView mtx=convertView.findViewById(R.id.MDCWidget);
        mtx.setText(Widgets[position]);
        return convertView;
    }
}
