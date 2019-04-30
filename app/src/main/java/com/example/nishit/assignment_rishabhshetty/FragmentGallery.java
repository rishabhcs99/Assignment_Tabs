package com.example.nishit.assignment_rishabhshetty;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.nishit.assignment_rishabhshetty.R;

import java.io.File;
import java.util.ArrayList;

public class FragmentGallery extends android.support.v4.app.Fragment{
    GridView gridView;
    ArrayList<File> list;

    View view;
    public FragmentGallery() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.gallery_fragment,container,false);

        return view;
    }
/*
    public class gridAdapter extends BaseAdapter{
        private Context mContext;

        public gridAdapter(Context context) {
            mContext=context;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int i) {
            return list.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            View convertView=null;//ghdhdh
            if(convertView==null)
            {
                convertView=getLayoutInflater().inflate(R.layout.row_layout,viewGroup,false);
                ImageView myImage=(ImageView)convertView.findViewById(R.id.my_image);
                myImage.setImageURI(Uri.parse(list.get(i).toString()));
            }
            return convertView;
        }
    }

    private ArrayList<File> imageReader(File externalStorageDirectory) {

        ArrayList<File>b=new ArrayList<>();
        File[] files = externalStorageDirectory.listFiles();

        for(int i =0; i<files.length;i++)
        {
            if ( files[i].isDirectory())
            {
                b.addAll(imageReader(files[i]));

            }else
            {
                if(files[i].getName().endsWith(".jpg"))
                {
                    b.add(files[i]);
                }
            }
        }
        return b;
    }
    */
}
