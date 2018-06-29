package com.ducslectures.vimal;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Solution extends AppCompatActivity {

    private int dotscount;
    private ImageView[] dots;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solution);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

















    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_home) {
            Intent intent = new Intent(Solution.this, MainActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_back) {
            finish();
            return true;
        } else if (id == R.id.action_about) {
            Intent intent = new Intent(Solution.this, AboutMe.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_exit) {

            finish();
            System.exit(0);
        } else if (id == R.id.action_share) {
            String share = "  DU CS Lectures "+ "Download the app from the play store";
            String shareBody = share + "\n\nhttps://play.google.com/store/apps/details?id=com.ducslectures.vimal";
            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Official 2017 DU CS Lectures app");
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(sharingIntent, "Share via"));
            return true;

        }

        return super.onOptionsItemSelected(item);
    }
}


