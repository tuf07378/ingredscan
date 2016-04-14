package edu.sfsu.cs.orange.ocr.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import edu.sfsu.cs.orange.ocr.R;
import edu.sfsu.cs.orange.ocr.model.Food;

/**
 * Created by Rob on 4/12/2016.
 */
public class ListFoodAdapter extends BaseAdapter{

    private Context mContext;
    private List<Food> mFoodList;

    public ListFoodAdapter(Context mContext, List<Food> mFoodList) {
        this.mContext = mContext;
        this.mFoodList = mFoodList;
    }

    @Override
    public int getCount() {
        return mFoodList.size();
    }

    @Override
    public Object getItem(int position) {
        return mFoodList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mFoodList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //View v = View.inflate(mContext, R.layout
       // TextView tvName = {TextView}v.findViewById(R.id.tv_product_name);
        return null;
    }
}
