package com.example.goods;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class GoodAdapter extends ArrayAdapter<Good> {
    private LayoutInflater inflater;
    private int layout;
    private List<Good> goods;

    public GoodAdapter(Context context, int resource, List<Good> goods){
        super(context, resource, goods);
        this.goods=goods;
        this.layout= resource;
        this.inflater=LayoutInflater.from(context);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(this.layout, parent, false);

        ImageView img=view.findViewById(R.id.img);
        TextView title=view.findViewById(R.id.title);

        Good good=goods.get(position);
        img.setImageResource(good.getImgResource());

        return view;

    }
}
