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

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.nishit.assignment_rishabhshetty.adapter.MyArrayAdapter;
import com.example.nishit.assignment_rishabhshetty.model.MyDataModel;
import com.example.nishit.assignment_rishabhshetty.parser.JSONParser;
import com.example.nishit.assignment_rishabhshetty.util.InternetConnection;
import com.example.nishit.assignment_rishabhshetty.util.Keys;
//import com.facebook.drawee.backends.pipeline.Fresco;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class FragmentGallery extends android.support.v4.app.Fragment{
    GridView gridView;
    //ArrayList<File> list;
    private ListView listView;
    private ArrayList<MyDataModel> list;
    private MyArrayAdapter adapter;

    View view;
    public FragmentGallery() {
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        Toolbar toolbar = (Toolbar) getView().findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        /**
         * Array List for Binding Data from JSON to this List
         */
        list = new ArrayList<>();
        /**
         * Binding that List to Adapter
         */
        adapter = new MyArrayAdapter(getActivity(), list);

        /**
         * Getting List and Setting List Adapter
         */
        listView = (ListView) getView().findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Snackbar.make(getView().findViewById(R.id.parentLayout), list.get(position).getName() + " => " + list.get(position).getCountry(), Snackbar.LENGTH_LONG).show();
            }
        });

        /**
         * Just to know onClick and Printing Hello Toast in Center.
         */
        Toast toast = Toast.makeText(getActivity(), "Click on FloatingActionButton to Load JSON", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();

        FloatingActionButton fab = (FloatingActionButton) getView().findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(@NonNull View view) {

                /**
                 * Checking Internet Connection
                 */
                if (InternetConnection.checkConnection(getActivity())) {
                    new GetDataTask().execute();
                } else {
                    Snackbar.make(view, "Internet Connection Not Available", Snackbar.LENGTH_LONG).show();
                }
            }
        });


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.gallery_fragment,container,false);

        return view;
    }


    /**
     * Creating Get Data Task for Getting Data From Web
     */
    class GetDataTask extends AsyncTask<Void, Void, Void> {

        ProgressDialog dialog;
        int jIndex;
        int x;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            /**
             * Progress Dialog for User Interaction
             */

            x=list.size();

            if(x==0)
                jIndex=0;
            else
                jIndex=x;

            dialog = new ProgressDialog(getActivity());
            dialog.setTitle("Hey Wait Please..."+x);
            dialog.setMessage("I am getting your JSON");
            dialog.show();
        }

        @Nullable
        @Override
        protected Void doInBackground(Void... params) {

            /**
             * Getting JSON Object from Web Using okHttp
             */
            JSONObject jsonObject = JSONParser.getDataFromWeb();

            try {
                /**
                 * Check Whether Its NULL???
                 */
                if (jsonObject != null) {
                    /**
                     * Check Length...
                     */
                    if(jsonObject.length() > 0) {
                        /**
                         * Getting Array named "contacts" From MAIN Json Object
                         */
                        JSONArray array = jsonObject.getJSONArray(Keys.KEY_CONTACTS);

                        /**
                         * Check Length of Array...
                         */


                        int lenArray = array.length();
                        if(lenArray > 0) {
                            for( ; jIndex < lenArray; jIndex++) {

                                /**
                                 * Creating Every time New Object
                                 * and
                                 * Adding into List
                                 */
                                MyDataModel model = new MyDataModel();

                                /**
                                 * Getting Inner Object from contacts array...
                                 * and
                                 * From that We will get Name of that Contact
                                 *
                                 */
                                //STAFF_NO.":216127,"STATION":"BHOPAL","E_MAIL_ID":"bho.sm@airindia.in","TEL_NO.":9826078434
                                JSONObject innerObject = array.getJSONObject(jIndex);
                                String name = innerObject.getString(Keys.KEY_NAME);
                                String country = innerObject.getString(Keys.KEY_COUNTRY);
                                String staff_no = innerObject.getString(Keys.STAFF_NO);
                                String station = innerObject.getString(Keys.STATION);
                                String email = innerObject.getString(Keys.E_MAIL_ID);
                                String tel = innerObject.getString(Keys.TEL_NO);

                                /**
                                 * Getting Object from Object "phone"
                                 */
                                //JSONObject phoneObject = innerObject.getJSONObject(Keys.KEY_PHONE);
                                //String phone = phoneObject.getString(Keys.KEY_MOBILE);

                                model.setName(name);
                                model.setCountry(country);
                                model.setSTAFF_NO(staff_no);
                                model.setSTATION(station);
                                model.setE_MAIL_ID(email);
                                model.setTEL_NO(tel);

                                /**
                                 * Adding name and phone concatenation in List...
                                 */
                                list.add(model);
                            }
                        }
                    }
                } else {

                }
            } catch (JSONException je) {
                Log.i(JSONParser.TAG, "" + je.getLocalizedMessage());
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            dialog.dismiss();
            /**
             * Checking if List size if more than zero then
             * Update ListView
             */
            if(list.size() > 0) {
                adapter.notifyDataSetChanged();
            } else {
                Snackbar.make(getView().findViewById(R.id.parentLayout), "No Data Found", Snackbar.LENGTH_LONG).show();
            }
        }
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
