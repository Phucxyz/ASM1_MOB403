package com.example.usermanager.tool;

import android.content.Context;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.usermanager.R;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.text.DecimalFormat;

public class Tools {

    public static String IP = "192.168.0.103";
    public static String url = "http://"+Tools.IP+":9999/images/products/";


    public static String IntegerToVnd(int so){
        DecimalFormat formatter = new DecimalFormat("###,###,###");
        return formatter.format(so);
    }

    public static void setImage(String link, ImageView iv, Context context){
        Picasso.with(context).load(url+link)
                .placeholder(R.drawable.demo_pro)
                .error(R.drawable.demo_pro)
                .into(iv);
    }


    public static void deleteCache(Context context) {
        try {
            File dir = context.getCacheDir();
            deleteDir(dir);
            Toast.makeText(context.getApplicationContext(), "clear cache success", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(context.getApplicationContext(), "clear cache failed", Toast.LENGTH_SHORT).show();
        }
    }

    public static boolean deleteDir(File dir) {
        if (dir != null && dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
            return dir.delete();
        } else if(dir!= null && dir.isFile()) {
            return dir.delete();
        } else {
            return false;
        }
    }


}
