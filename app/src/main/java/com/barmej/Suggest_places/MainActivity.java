package com.barmej.Suggest_places;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String BUNDLE_CURRENT_INDEX = "BUNDLE_CURRENT_INDEX";
    private Random mRandom;

    private ImageView suggestImageView;
    private TextView suggestTextView;
    private TextView suggestTitleView;

    private int [] mSuggestTitles = {
            R.string.bangkok_title,
            R.string.london_title,
            R.string.paris_title,
            R.string.dubai_title,
            R.string.new_york_title,
            R.string.istanbul_title,
            R.string.seoul_title,
            R.string.hong_kong_title,
            R.string.milan_title,
            R.string.barcelona_title
    };

    private int [] mSuggestPictures = {
            R.drawable.bangkok_01,
            R.drawable.london_02,
            R.drawable.paris_03,
            R.drawable.dubai_04,
            R.drawable.new_york_05,
            R.drawable.istanbul_06,
            R.drawable.seoul_07,
            R.drawable.hong_kong_08,
            R.drawable.milan_09,
            R.drawable.barcelona_10
    };

    private int [] mSuggestTexts = {
            R.string.bangkok_description,
            R.string.london_description,
            R.string.paris_description,
            R.string.dubai_description,
            R.string.new_york_description,
            R.string.istanbul_description,
            R.string.seoul_description,
            R.string.hong_kong_description,
            R.string.milan_description,
            R.string.barcelona_description
    };

    private int mCurrentIndex = -1;
    private Log log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        suggestImageView = findViewById(R.id.bangkok_01);
        suggestTextView = findViewById(R.id.bangkok_description);
        suggestTitleView = findViewById(R.id.bangkok_title);
        mRandom = new Random();
        Log.i(TAG,"Created");
    }

    public void display(View view) {
        if(mCurrentIndex < 9){
            Log.d(TAG,"display =" + mCurrentIndex);
            mCurrentIndex = mRandom.nextInt(10);
            showImage();
            showText();
            showTitle();
        }else{
            Toast.makeText(this, "لا يوجد المزيد من المدن لعرضها ", Toast.LENGTH_SHORT).show();
        }
    }

    public void setNext(View view) {
        if (mCurrentIndex < 9){
            mCurrentIndex ++;
            showImage();
            showText();
            showTitle();
        }else{
            Toast.makeText(this, "المرجوا الرجوع إلى الصفحات السابقة ", Toast.LENGTH_SHORT).show();
        }
    }

    public void setPrevious(View view) {
        if(mCurrentIndex > 1){
            mCurrentIndex --;
            showTitle();
            showImage();
            showText();
        }else{
            Toast.makeText(this, "المرجوا الإنتقال إلى الصفحة التالية ", Toast.LENGTH_SHORT).show();
        }
    }


    private void showImage(){
        Drawable suggestDrawable = ContextCompat.getDrawable(this,mSuggestPictures[mCurrentIndex]);
        suggestImageView.setImageDrawable(suggestDrawable);
    }

    private void showText(){
        String text = getResources().getString(mSuggestTexts[mCurrentIndex]);
        suggestTextView.setText(text);
    }

    private void showTitle(){
        String text = getResources().getString(mSuggestTitles[mCurrentIndex]);
        suggestTitleView.setText(text);
    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(BUNDLE_CURRENT_INDEX,mCurrentIndex);
        Log.i(TAG,"onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if(savedInstanceState != null ){
            mCurrentIndex = savedInstanceState.getInt(BUNDLE_CURRENT_INDEX);
            if(mCurrentIndex != -1){
                Log.d(TAG,"display =" + mCurrentIndex);
                showImage();
            }
        }
        Log.i(TAG,"onRestoreInstanceState");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG,"Restarted");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"Started");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"Resumed");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"Paused");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"Stopped");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"Destroyed");
    }

}