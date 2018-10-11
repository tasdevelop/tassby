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
 * Created by admin on 4/19/2017.
 */

public class CustomListAdapterListAbsensiList extends BaseAdapter {
    private LayoutInflater mInflater;
    private List<PostAbsensiList> mPostsAbsensiList;
    private CustomListAdapterListAbsensiList.ViewHolderAbsensi mViewHolderAbsensi;

    private Bitmap mBitmap;
    private PostAbsensiList mPostabsensi;
    private Activity mActivity;

    public CustomListAdapterListAbsensiList(Activity activity, List<PostAbsensiList> postsabsensilist) {
        mInflater = (LayoutInflater) activity.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        mPostsAbsensiList = postsabsensilist;
        mActivity = activity;
    }

    @Override
    public int getCount() {
        return mPostsAbsensiList.size();
    }

    @Override
    public Object getItem(int position) {
        return mPostsAbsensiList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.layoutlistabsensilist, parent, false);
            mViewHolderAbsensi = new CustomListAdapterListAbsensiList.ViewHolderAbsensi();
            mViewHolderAbsensi.nobukti = (TextView) convertView.findViewById(R.id.post_nobukti);
            mViewHolderAbsensi.tanggal = (TextView) convertView.findViewById(R.id.post_tgl);

            convertView.setTag(mViewHolderAbsensi);

        } else {
            mViewHolderAbsensi = (CustomListAdapterListAbsensiList.ViewHolderAbsensi) convertView.getTag();
        }


        mPostabsensi = mPostsAbsensiList.get(position);

        mViewHolderAbsensi.nobukti.setText(mPostabsensi.getfntrans());
        mViewHolderAbsensi.tanggal.setText(mPostabsensi.getftgl());

        return convertView;
    }


    private static class ViewHolderAbsensi {
        TextView nobukti;
        TextView tanggal;


    }
}