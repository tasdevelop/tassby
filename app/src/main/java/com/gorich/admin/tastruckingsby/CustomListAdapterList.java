package com.gorich.admin.tastruckingsby;


import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by admin on 12/17/2016.
 */

public class CustomListAdapterList extends BaseAdapter {
    private LayoutInflater mInflater;
    private List<Post> mPosts;
    private ViewHolder mViewHolder;

    private Bitmap mBitmap;
    private Post mPost;
    private Activity mActivity;

    public CustomListAdapterList(Activity activity, List<Post> posts) {
        mInflater = (LayoutInflater) activity.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        mPosts = posts;
        mActivity = activity;
    }

    @Override
    public int getCount() {
        return mPosts.size();
    }

    @Override
    public Object getItem(int position) {
        return mPosts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.layoutlist, parent, false);
            mViewHolder = new ViewHolder();
            mViewHolder.nobukti = (TextView) convertView.findViewById(R.id.post_nobukti);
            mViewHolder.emkl = (TextView) convertView.findViewById(R.id.post_emkl);
            mViewHolder.jenisorderan = (TextView) convertView.findViewById(R.id.post_jenisorderan);
            mViewHolder.tujuantarif = (TextView) convertView.findViewById(R.id.post_tujuantarif);
            mViewHolder.nopol = (TextView) convertView.findViewById(R.id.post_nopol);
            mViewHolder.supir = (TextView) convertView.findViewById(R.id.post_supir);
            mViewHolder.dari = (TextView) convertView.findViewById(R.id.post_dari);
            mViewHolder.sampai = (TextView) convertView.findViewById(R.id.post_sampai);
            mViewHolder.ukurancon = (TextView) convertView.findViewById(R.id.post_ukucont);
            mViewHolder.statuscont = (TextView) convertView.findViewById(R.id.post_statuscont);
            mViewHolder.shipper = (TextView) convertView.findViewById(R.id.post_shipper);

            convertView.setTag(mViewHolder);

        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }


        mPost = mPosts.get(position);

        mViewHolder.nobukti.setText(mPost.nobukti);
        mViewHolder.emkl.setText(mPost.getemkl());
        mViewHolder.jenisorderan.setText(mPost.getjenisorderan());
        mViewHolder.tujuantarif.setText(mPost.gettujuantarif());
        mViewHolder.nopol.setText(mPost.getnopol());
        mViewHolder.supir.setText(mPost.getsupir());
        mViewHolder.dari.setText(mPost.getdari());
        mViewHolder.sampai.setText(mPost.getsampai());
        mViewHolder.ukurancon.setText(mPost.getukurancont());
        mViewHolder.statuscont.setText(mPost.getstatuscont());
        mViewHolder.shipper.setText(mPost.getshipper());


        return convertView;
    }


    private static class ViewHolder {
        TextView nobukti;
        TextView emkl;
        TextView jenisorderan;
        TextView tujuantarif;
        TextView nopol;
        TextView supir;
        TextView dari;
        TextView sampai;
        TextView ukurancon;
        TextView statuscont;
        TextView shipper;
    }
}
