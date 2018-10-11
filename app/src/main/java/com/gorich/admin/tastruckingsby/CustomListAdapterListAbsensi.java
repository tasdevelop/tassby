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
 * Created by admin on 4/18/2017.
 */

public class CustomListAdapterListAbsensi extends BaseAdapter {
    private LayoutInflater mInflater;
    private List<PostAbsensi> mPostsAbsensi;
    private CustomListAdapterListAbsensi.ViewHolderAbsensi mViewHolderAbsensi;

    private Bitmap mBitmap;
    private PostAbsensi mPostabsensi;
    private Activity mActivity;

    public CustomListAdapterListAbsensi(Activity activity, List<PostAbsensi> postsabsensi) {
        mInflater = (LayoutInflater) activity.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        mPostsAbsensi = postsabsensi;
        mActivity = activity;
    }

    @Override
    public int getCount() {
        return mPostsAbsensi.size();
    }

    @Override
    public Object getItem(int position) {
        return mPostsAbsensi.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.layoutlistabsensi, parent, false);
            mViewHolderAbsensi = new CustomListAdapterListAbsensi.ViewHolderAbsensi();
            mViewHolderAbsensi.nopol = (TextView) convertView.findViewById(R.id.post_nopol);
            mViewHolderAbsensi.status = (TextView) convertView.findViewById(R.id.post_status);
            mViewHolderAbsensi.supir = (TextView) convertView.findViewById(R.id.post_supir);
            mViewHolderAbsensi.keterangan = (TextView) convertView.findViewById(R.id.post_keterangan);
            mViewHolderAbsensi.jam = (TextView) convertView.findViewById(R.id.post_jam);

            convertView.setTag(mViewHolderAbsensi);

        } else {
            mViewHolderAbsensi = (CustomListAdapterListAbsensi.ViewHolderAbsensi) convertView.getTag();
        }


        mPostabsensi = mPostsAbsensi.get(position);

        mViewHolderAbsensi.nopol.setText(mPostabsensi.getnopol());
        mViewHolderAbsensi.status.setText(mPostabsensi.getstatus());
        mViewHolderAbsensi.supir.setText(mPostabsensi.getsupir());
        mViewHolderAbsensi.keterangan.setText(mPostabsensi.getketerangan());
        mViewHolderAbsensi.jam.setText(mPostabsensi.getjam());

        return convertView;
    }


    private static class ViewHolderAbsensi {
        TextView nopol;
        TextView status;
        TextView supir;
        TextView keterangan;
        TextView jam;
    }
}
