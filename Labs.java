package com.ducslectures.vimal;
/**
 * Created by VIMALKUMAR on 02-06-2018.
 */
import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
import com.ducslectures.vimal.semesterprogram.List_1_Sem;
import com.ducslectures.vimal.semesterprogram.List_2_Sem;
import com.ducslectures.vimal.semesterprogram.List_3_Sem;
import com.ducslectures.vimal.semesterprogram.List_4_Sem;
import com.ducslectures.vimal.semesterprogram.List_5_Sem;
import com.ducslectures.vimal.semesterprogram.List_6_Sem;


import java.util.HashMap;

public class Labs extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {

    SliderLayout sliderLayout;
    HashMap<String, String> Hash_file_maps;
    private ImageButton imagebutton,  imagebutton1, imagebutton2,imagebutton3,imagebutton4,imagebutton5;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_labs);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);




        imagebutton = (ImageButton) findViewById(R.id.Semester1);
        imagebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myIntent = new Intent(Labs.this, List_1_Sem.class);
                startActivity(myIntent);
            }
        });



        imagebutton1 = (ImageButton) findViewById(R.id.Semester2);
        imagebutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myIntent = new Intent(Labs.this, List_2_Sem.class);
                startActivity(myIntent);
            }
        });
        imagebutton2 = (ImageButton) findViewById(R.id.Semester3);
        imagebutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myIntent = new Intent(Labs.this, List_3_Sem.class);
                startActivity(myIntent);
            }
        });
        imagebutton3 = (ImageButton) findViewById(R.id.Semester4);
        imagebutton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myIntent = new Intent(Labs.this, List_4_Sem.class);
                startActivity(myIntent);
            }
        });
        imagebutton4 = (ImageButton) findViewById(R.id.Semester5);
        imagebutton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myIntent = new Intent(Labs.this, List_5_Sem.class);
                startActivity(myIntent);
            }
        });
        imagebutton5 = (ImageButton) findViewById(R.id.Semester6);
        imagebutton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myIntent = new Intent(Labs.this, List_6_Sem.class);
                startActivity(myIntent);
            }
        });










        Hash_file_maps = new HashMap<String, String>();

        sliderLayout = (SliderLayout) findViewById(R.id.slider);

        Hash_file_maps.put("Developed and Designed By:-Vimal (CVS)", "https://scontent.flko1-1.fna.fbcdn.net/v/t1.0-9/26169593_884580948381575_7445224168235676783_n.png?oh=0f73f64cb10f63cb11ade17d5baa5ed8&oe=5AF433AF");
        Hash_file_maps.put("Developed and Designed By:-Vimal (CVS)", "https://scontent.flko1-1.fna.fbcdn.net/v/t1.0-9/26169593_884580948381575_7445224168235676783_n.png?oh=0f73f64cb10f63cb11ade17d5baa5ed8&oe=5AF433AF");
        Hash_file_maps.put("Developed and Designed By:-Vimal (CVS)", "https://scontent.flko1-1.fna.fbcdn.net/v/t1.0-9/26169593_884580948381575_7445224168235676783_n.png?oh=0f73f64cb10f63cb11ade17d5baa5ed8&oe=5AF433AF");
        Hash_file_maps.put("Developed and Designed By:-Vimal (CVS)", "https://scontent.flko1-1.fna.fbcdn.net/v/t1.0-9/26169593_884580948381575_7445224168235676783_n.png?oh=0f73f64cb10f63cb11ade17d5baa5ed8&oe=5AF433AF");
        Hash_file_maps.put("Developed and Designed By:-Vimal (CVS)", "https://scontent.flko1-1.fna.fbcdn.net/v/t1.0-9/26169593_884580948381575_7445224168235676783_n.png?oh=0f73f64cb10f63cb11ade17d5baa5ed8&oe=5AF433AF");

        for (String name : Hash_file_maps.keySet()) {

            TextSliderView textSliderView = new TextSliderView(Labs.this);
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
        sliderLayout.setPresetTransformer(SliderLayout.Transformer.Accordion);
        sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
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
        Toast.makeText(this, slider.getBundle().get("extra") + "", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {

        Log.d("Slider Demo", "Page Changed: " + position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_home) {
            Intent intent = new Intent(Labs.this, MainActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_back) {
            finish();
            return true;
        } else if (id == R.id.action_about) {
            Intent intent = new Intent(Labs.this, AboutMe.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_exit) {
            finish();
            System.exit(0);

        } else if (id == R.id.action_share) {
            String share = "  DU CS Lectures "+ "Download the app from the play store";
            String shareBody = share + "\nhttps://play.google.com/store/apps/developer?id=Vimal%20CVS&hl=en";
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