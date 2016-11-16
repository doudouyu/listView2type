package com.example.administrator.listview2type;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/11.
 */
public class MyAdapter extends BaseAdapter {
    private List<String> list = new ArrayList<>();
    public static final int Type1 = 0;
    public static final int Type2 = 1;
    public static final int TypeCount = 2;

    private Context context;

    public MyAdapter(Context context, List<String> list) {
        this.list = list;
        this.context = context;
    }

    //获得listView子条目的种类
    @Override
    public int getViewTypeCount() {
//        return super.getViewTypeCount();
        return TypeCount;
    }

    //获得条目的类型
    @Override
    public int getItemViewType(int position) {
//        return super.getItemViewType(position);
        if (position == 0 || position == 8 || position == 15 || position == 27) {
            return Type1;
        } else {
            return Type2;
        }
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = new ViewHolder();
        //三种写法。。
//        if (getItemViewType(position) == Type2) {
//            if (convertView == null) {
//                convertView = View.inflate(context, R.layout.item_listview, null);
//                holder.textView = (TextView) convertView.findViewById(R.id.tv);
//                convertView.setTag(holder);
//            } else {
//                holder = (ViewHolder) convertView.getTag();
//            }
//            holder.textView.setText(list.get(position) + "");
//        } else {
//            if (convertView == null) {
//                convertView = View.inflate(context, R.layout.item2_listview, null);
//                holder.textView2 = (TextView) convertView.findViewById(R.id.tv_2);
//                convertView.setTag(holder);
//            } else {
//                holder = (ViewHolder) convertView.getTag();
//            }
//            holder.textView2.setText(list.get(position));
//        }
        if (convertView == null) {
            switch (getItemViewType(position)) {
                case  Type2:
                    convertView = View.inflate(context, R.layout.item_listview, null);
                    holder.textView = (TextView) convertView.findViewById(R.id.tv);
                    convertView.setTag(holder);
                    break;
                case Type1:
                    convertView = View.inflate(context, R.layout.item2_listview, null);
                    holder.textView2 = (TextView) convertView.findViewById(R.id.tv_2);
                    convertView.setTag(holder);
                    break;

                default:
                    break;
            }
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
//        if (convertView == null) {
//            //判断给不同的条目设置布局，并且查找控件
//            if (Type2 == getItemViewType(position)) {
//                convertView = View.inflate(context, R.layout.item_listview, null);
//                holder.textView = (TextView) convertView.findViewById(R.id.tv);
//                convertView.setTag(holder);
//            } else {
//                convertView = View.inflate(context, R.layout.item2_listview, null);
//                holder.textView2 = (TextView) convertView.findViewById(R.id.tv_2);
//                convertView.setTag(holder);
//            }
//        } else {
//            holder = (ViewHolder) convertView.getTag();
//        }
        //判断给不同的条目设置数据
        if (Type2 == getItemViewType(position)) {
            holder.textView.setText(list.get(position) + "");
        } else {
                holder.textView2.setText(list.get(position) + "");
        }
        return convertView;
    }

    private class ViewHolder {
        public TextView textView;
        public TextView textView2;
    }
}
