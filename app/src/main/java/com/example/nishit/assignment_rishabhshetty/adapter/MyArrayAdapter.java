package com.example.nishit.assignment_rishabhshetty.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.nishit.assignment_rishabhshetty.R;
import com.example.nishit.assignment_rishabhshetty.model.MyDataModel;

import java.util.List;

//import com.facebook.drawee.view.SimpleDraweeView;

public class MyArrayAdapter extends ArrayAdapter<MyDataModel> {

    List<MyDataModel> modelList;
    Context context;
    private LayoutInflater mInflater;

    // Constructors
    public MyArrayAdapter(Context context, List<MyDataModel> objects) {
        super(context, 0, objects);
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
        modelList = objects;
    }

    @Override
    public MyDataModel getItem(int position) {
        return modelList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder vh;
        if (convertView == null) {
            View view = mInflater.inflate(R.layout.layout_row_view, parent, false);
            vh = ViewHolder.create((RelativeLayout) view);
            view.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        MyDataModel item = getItem(position);

        vh.textViewName.setText(item.getName());
        vh.textViewCountry.setText("Designation: "+item.getCountry());
        vh.textViewStaffNo.setText("Staff No: "+item.getSTAFF_NO());
        vh.textViewStation.setText("Station: "+item.getSTATION());
        vh.textViewEmail.setText("E-Mail: "+item.getE_MAIL_ID());
        vh.textViewTel.setText("Tel. : "+item.getTEL_NO());

        return vh.rootView;
    }




    /**
     * ViewHolder class for layout.<br />
     * <br />
     * Auto-created on 2016-01-05 00:50:26 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */

    //STAFF_NO.":216127,"STATION":"BHOPAL","E_MAIL_ID":"bho.sm@airindia.in","TEL_NO.":9826078434

    private static class ViewHolder {
        public final RelativeLayout rootView;

        public final TextView textViewName;
        public final TextView textViewCountry;
        public final TextView textViewStaffNo;
        public final TextView textViewStation;
        public final TextView textViewEmail;
        public final TextView textViewTel;

        private ViewHolder(RelativeLayout rootView, TextView textViewName, TextView textViewCountry, TextView textViewStaffNo, TextView textViewStation, TextView textViewEmail, TextView textViewTel) {
            this.rootView = rootView;
            this.textViewName = textViewName;
            this.textViewCountry = textViewCountry;
            this.textViewStaffNo = textViewStaffNo;
            this.textViewStation = textViewStation;
            this.textViewEmail = textViewEmail;
            this.textViewTel = textViewTel;
        }

        public static ViewHolder create(RelativeLayout rootView) {
            TextView textViewName = (TextView) rootView.findViewById(R.id.textViewName);
            TextView textViewCountry = (TextView) rootView.findViewById(R.id.textViewCountry);
            TextView textViewStaffNo = (TextView) rootView.findViewById(R.id.textViewStaffNo);
            TextView textViewStation = (TextView) rootView.findViewById(R.id.textViewStation);
            TextView textViewEmail = (TextView) rootView.findViewById(R.id.textViewEmail);
            TextView textViewTel = (TextView) rootView.findViewById(R.id.textViewTel);
            return new ViewHolder(rootView, textViewName, textViewCountry,textViewStaffNo,textViewStation,textViewEmail,textViewTel);
        }
    }
}