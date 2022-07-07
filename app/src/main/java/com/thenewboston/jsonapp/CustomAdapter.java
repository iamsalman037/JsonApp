package com.thenewboston.jsonapp;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by SAM on 3/18/2018.
 */

public class CustomAdapter  extends BaseAdapter {
    ArrayList<JSonModel> jSonModelArrayList1;
    Context context;
    private static LayoutInflater inflater=null;


    public CustomAdapter(ArrayList<JSonModel> jSonModelArrayList, JsonApp jsonApp) {
        jSonModelArrayList1=jSonModelArrayList;
        context=jsonApp;
        Activity activity;
        inflater=( LayoutInflater )context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }


    @Override
    public int getCount() {
        return jSonModelArrayList1.size();
    }

    @Override
    public Object getItem(int position) {
        return jSonModelArrayList1.size();
    }

    @Override
    public long getItemId(int position) {
        return jSonModelArrayList1.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView txtrank;
        TextView txtcountry;
        TextView txtpopulation;
        //ImageView imgflag;
        convertView = inflater.inflate(R.layout.slide,null);

        txtrank = (TextView) convertView.findViewById(R.id.name);
        txtcountry = (TextView) convertView.findViewById(R.id.email);
        txtpopulation = (TextView) convertView.findViewById(R.id.mobile);
        JSonModel currentItem = jSonModelArrayList1.get(position);

        txtrank.setText(currentItem.getOffer_names());
        txtcountry.setText(currentItem.getOffer_types());
        txtpopulation.setText(currentItem.getOffers_btns());

        // Locate the ImageView in viewpager_item.xml
        //imgflag = (ImageView) convertView.findViewById(R.id.img_show);
        // Capture position and set to the ImageView
        //new CustomAdapter.MyAsynt(imgflag).execute(currentItem.getImageUrl());


        return convertView;
    }

    private class MyAsynt extends AsyncTask<String,String,Bitmap> {
        ImageView img;
        public MyAsynt(ImageView imageView) {
            this.img=imageView;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Bitmap doInBackground(String... strings) {
            String string= strings[0];
            Bitmap bitmap = null;
            try {
                InputStream in=new URL(string).openStream();
                bitmap= BitmapFactory.decodeStream(in);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            img.setImageBitmap(bitmap);
        }

    }

}
