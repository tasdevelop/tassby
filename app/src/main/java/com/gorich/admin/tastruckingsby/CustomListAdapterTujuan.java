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

public class CustomListAdapterTujuan extends BaseAdapter {
    private LayoutInflater mInflater;
    private List<PostTujuanList> poststujuanlist;
    private CustomListAdapterTujuan.ViewHolderTujuan mViewHolderTujuan;

    private Bitmap mBitmap;
    private PostTujuanList mPosttujuan;
    private Activity mActivity;

    public CustomListAdapterTujuan(Activity activity, List<PostTujuanList> poststujuanlist) {
        mInflater = (LayoutInflater) activity.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        poststujuanlist = poststujuanlist;
        mActivity = activity;
    }

    @Override
    public int getCount() {
        return poststujuanlist.size();
    }

    @Override
    public Object getItem(int position) {
        return poststujuanlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.layoutlisttujuanlist, parent, false);
            mViewHolderTujuan = new CustomListAdapterTujuan.ViewHolderTujuan();
            mViewHolderTujuan.fkota = (TextView) convertView.findViewById(R.id.post_tujuan);
            mViewHolderTujuan.fkkota = (TextView) convertView.findViewById(R.id.post_kota);

            convertView.setTag(mViewHolderTujuan);

        } else {
            mViewHolderTujuan = (CustomListAdapterTujuan.ViewHolderTujuan) convertView.getTag();
        }


        mPosttujuan = poststujuanlist.get(position);

        mViewHolderTujuan.fkota.setText(mPosttujuan.getFkota());
        mViewHolderTujuan.fkkota.setText(mPosttujuan.getFkkota());

        return convertView;
    }


    private static class ViewHolderTujuan {
        TextView fkota;
        TextView fkkota;


    }
}
