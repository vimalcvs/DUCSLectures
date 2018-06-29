package com.ducslectures.vimal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.util.HashMap;

public class Short extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {
    public CardView cardView1,cardView2,cardView3,cardView4,cardView5,cardView6 ;
    SliderLayout sliderLayout;
    HashMap<String,String> Hash_file_maps ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_short);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        cardView1 = (CardView) findViewById(R.id.Semester1);
        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myIntent = new Intent(Short.this, Updatesoon.class);
                startActivity(myIntent);
            }
        });



        cardView2= (CardView) findViewById(R.id.Semester2);
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myIntent = new Intent(Short.this, Updatesoon.class);
                startActivity(myIntent);
            }
        });
        cardView3 = (CardView) findViewById(R.id.Semester3);
        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myIntent = new Intent(Short.this, Updatesoon.class);
                startActivity(myIntent);
            }
        });
        cardView4= (CardView) findViewById(R.id.Semester4);
        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myIntent = new Intent(Short.this, Updatesoon.class);
                startActivity(myIntent);
            }
        });
        cardView5 = (CardView) findViewById(R.id.Semester5);
        cardView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myIntent = new Intent(Short.this, Updatesoon.class);
                startActivity(myIntent);
            }
        });
        cardView5 = (CardView) findViewById(R.id.Semester6);
        cardView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myIntent = new Intent(Short.this, Updatesoon.class);
                startActivity(myIntent);
            }
        });



        // Inflate the image ;

        Hash_file_maps = new HashMap<String, String>();
        sliderLayout = (SliderLayout) findViewById(R.id.slider);
        Hash_file_maps.put("Vimal CVS", "https://3.bp.blogspot.com/-garW3k4w9nE/WxeNRETAvcI/AAAAAAAAOx0/DUQ8h-WhpRslwA1BeydhMwRYeZu3fzJqgCKgBGAs/s1600/POSTER.PNG");
        Hash_file_maps.put("Vimal CVS", "https://3.bp.blogspot.com/-garW3k4w9nE/WxeNRETAvcI/AAAAAAAAOx0/DUQ8h-WhpRslwA1BeydhMwRYeZu3fzJqgCKgBGAs/s1600/POSTER.PNG");

        for (String name : Hash_file_maps.keySet()) {
            TextSliderView textSliderView = new TextSliderView(Short.this);
            textSliderView
                    .description(name)
                    .image(Hash_file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra", name);
            sliderLayout.addSlider(textSliderView);
        }

        sliderLayout.setCustomAnimation(new DescriptionAnimation());
        sliderLayout.setDuration(3000);
        sliderLayout.addOnPageChangeListener(this);
    }
    @Override
    protected void onStop() {

        sliderLayout.stopAutoCycle();

        super.onStop();
    }
    @Override
    public void onSliderClick(BaseSliderView slider) {
        Toast.makeText(this,slider.getBundle().get("extra") + "",Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

    @Override
    public void onPageSelected(int position) {

        Log.d("Slider Demo", "Page Changed: " + position);
    }
    @Override
    public void onPageScrollStateChanged(int state) {}




    // Inflate the menu;
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
            Intent intent = new Intent(Short .this, MainActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_back) {
            finish();
            return true;
        } else if (id == R.id.action_about) {
            Intent intent = new Intent(Short.this, AboutMe.class);
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