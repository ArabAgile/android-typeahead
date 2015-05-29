package com.arabagile.typeahead.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.arabagile.typeahead.R;
import com.squareup.picasso.Picasso;

/**
 * Created by agile on 5/26/15.
 */
public class Image {

    public static void load(Context context, String url, ImageView imageView) {
//        Picasso.with(context).setDebugging(true);
        Picasso.with(context).load(url)
                .resize(64, 64)
                .placeholder(R.drawable.placeholder)
                .into(imageView);
    }
}
