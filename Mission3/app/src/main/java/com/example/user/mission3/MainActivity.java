package com.example.user.mission3;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView1;
    private ImageView imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enableHorizontalScrollBar(R.id.scroll1);
        enableHorizontalScrollBar(R.id.scroll2);

        imageView1 = (ImageView) this.findViewById(R.id.image1);
        imageView2 = (ImageView) this.findViewById(R.id.image2);

        Resources res = getResources();

        setImageViewWithBitmapDrawable(imageView1, (BitmapDrawable) res.getDrawable(R.drawable.grindelwald));
        setImageViewWithBitmapDrawable(imageView2, (BitmapDrawable) res.getDrawable(R.drawable.railbridge));
    }

    private void enableHorizontalScrollBar(int id){
        ScrollView scrollView = (ScrollView) this.findViewById(id);
        scrollView.setHorizontalScrollBarEnabled(true);
    }

    private void setImageViewWithBitmapDrawable(ImageView imageView, BitmapDrawable bitmap) {
        imageView.setImageDrawable(bitmap);
        imageView.getLayoutParams().width = bitmap.getIntrinsicWidth();
        imageView.getLayoutParams().height = bitmap.getIntrinsicHeight();
    }

    public void switchImages(View view) {
        Drawable imageView1Drawable = imageView1.getDrawable();
        Drawable imageView2Drawable = imageView2.getDrawable();

        setImageViewWithBitmapDrawable(imageView1, (BitmapDrawable) imageView2Drawable);
        setImageViewWithBitmapDrawable(imageView2, (BitmapDrawable) imageView1Drawable);
    }
}
