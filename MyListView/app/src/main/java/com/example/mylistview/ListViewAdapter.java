package com.example.mylistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {
    private ArrayList<Niniz> ninizs = null;
    private Context context;

    //--- 전달 받은 객체로 ninizs 초기화
    public ListViewAdapter(ArrayList<Niniz> nini) {
        this.ninizs = nini;
    }

    @Override
    public int getCount() {
        return ninizs.size();
    }

    @Override
    public Niniz getItem(int position) {
        return ninizs.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        context = parent.getContext();

        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_list, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.img);
        TextView textView = convertView.findViewById(R.id.name);

        Niniz niniz = ninizs.get(position);

        imageView.setImageResource(niniz.getImg());
        textView.setText(niniz.getName());

        return convertView;
    }
}
