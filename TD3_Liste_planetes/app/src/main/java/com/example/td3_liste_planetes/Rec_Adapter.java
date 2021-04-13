package com.example.td3_liste_planetes;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class Rec_Adapter extends RecyclerView.Adapter<Rec_Adapter.ViewHolder> {
    private String[] mDataSet;
    private String[] mDistSet;
    private Drawable[] mDrawables;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;
        public TextView mDist;
        public ImageView mImageView;

        public ViewHolder(View v) {
            super(v);
            mTextView = (TextView)v.findViewById(R.id.textView);
            mDist = (TextView)v.findViewById(R.id.dist);
            mImageView = (ImageView)v.findViewById(R.id.imageView);
        }
    }

    public Rec_Adapter(String[] monDataSet, String[] mesDist, Drawable[] mesDrawables) {
        mDataSet = monDataSet;
        mDrawables = mesDrawables;
        mDistSet = mesDist;
    }

    @Override
    public Rec_Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.mTextView.setText(mDataSet[position]);
        holder.mImageView.setImageDrawable(mDrawables[position]);
        String distTxt = "Distance moy : "+mDistSet[position]+" millions kms";
        holder.mDist.setText(distTxt);
    }

    @Override
    public int getItemCount() {
        return mDataSet.length;
    }
}