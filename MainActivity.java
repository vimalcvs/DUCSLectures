package com.ducslectures.vimal;


import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.TextView;
import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.ducslectures.vimal.questionpapers.Question;
import com.ducslectures.vimal.semesterprogram.Semester;
import com.tapadoo.alerter.Alerter;
import java.util.HashMap;
import tyrantgit.explosionfield.ExplosionField;



public class MainActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener, NavigationView.OnNavigationItemSelectedListener {
    TextView count;
    SliderLayout sliderLayout;
    HashMap<String,String> Hash_file_maps ;
   public CardView cardView1,cardView2,cardView3,cardView4,cardView5 ;
    private TextView verboseAlertBt;
    private ExplosionField mExplosionField;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mExplosionField = ExplosionField.attach2Window(this);
        addListener(findViewById(R.id.main_short));

        cardView1 = (CardView) findViewById(R.id.main_year);
        cardView2 = (CardView) findViewById(R.id.main_syllabus);
        cardView3 = (CardView) findViewById(R.id.main_que);
        cardView4 = (CardView) findViewById(R.id.main_short);
        cardView5 = (CardView) findViewById(R.id.main_newupdate);

        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myIntent = new Intent(MainActivity.this, Semester.class);
                startActivity(myIntent);
            }
        });

        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myIntent = new Intent(MainActivity.this, Syllabus.class);
                startActivity(myIntent);


            }
        });
        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myIntent = new Intent(MainActivity.this, Question.class);
                startActivity(myIntent);


            }
        });
        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Alerter.create(MainActivity.this)
                        .setTitle("Update Coming Soon")
                        .setText("\nSorry Guys & Big Update Coming Soon..")
                        .setBackgroundColorRes(R.color.main2)
                        .show();
            }
        });



        cardView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myIntent = new Intent(MainActivity.this, NewUpdate.class);
                startActivity(myIntent);


            }
        });
    }



    private void addListener(View root) {
        if (root instanceof ViewGroup) {
            ViewGroup parent = (ViewGroup) root;
            for (int i = 0; i < parent.getChildCount(); i++) {
                addListener(parent.getChildAt(i));
            }
        } else {
            root.setClickable(true);
            root.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mExplosionField.explode(v);
                    v.setOnClickListener(null);
                }
            });
        }



        Hash_file_maps = new HashMap<String, String>();

        sliderLayout = (SliderLayout)findViewById(R.id.slider);

        Hash_file_maps.put("Vimal CVS", "https://3.bp.blogspot.com/-garW3k4w9nE/WxeNRETAvcI/AAAAAAAAOx0/DUQ8h-WhpRslwA1BeydhMwRYeZu3fzJqgCKgBGAs/s1600/POSTER.PNG");
        Hash_file_maps.put("Vimal CVS", "https://3.bp.blogspot.com/-garW3k4w9nE/WxeNRETAvcI/AAAAAAAAOx0/DUQ8h-WhpRslwA1BeydhMwRYeZu3fzJqgCKgBGAs/s1600/POSTER.PNG");

        for(String name : Hash_file_maps.keySet()){

            TextSliderView textSliderView = new TextSliderView(MainActivity.this);
            textSliderView
                    .description(name)
                    .image(Hash_file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);
            sliderLayout.addSlider(textSliderView);
        }

        sliderLayout.setCustomAnimation(new DescriptionAnimation());
        sliderLayout.setDuration(3000);
        sliderLayout.addOnPageChangeListener(this);





        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String share = "  DU CS Lectures "+ "Download the app from the play store";
                String shareBody = share + "\nhttps://play.google.com/store/apps/developer?id=Vimal%20CVS&hl=en";
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Official 2017 DU CS Lectures app");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share via"));
            }
        });




        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.homemain, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

      if (id == R.id.action_about) {
            Intent intent = new Intent(MainActivity.this,AboutMe.class);
            startActivity(intent);
             return true;
        } else if (id == R.id.action_exit) {

          AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
          builder.setTitle(R.string.app_name);
          builder.setIcon(R.mipmap.ic_launcher);
          builder.setMessage("Do you want to exit?")
                  .setCancelable(false)
                  .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                      public void onClick(DialogInterface dialog, int id) {
                          finish();
                      }
                  })
                  .setNegativeButton("No", new DialogInterface.OnClickListener() {
                      public void onClick(DialogInterface dialog, int id) {
                          dialog.cancel();
                      }
                  });
          AlertDialog alert = builder.create();
          alert.show();


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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Intent intent = new Intent(MainActivity.this, MainActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_syllabus) {
            Intent intent = new Intent(MainActivity.this, Syllabus.class);
            startActivity(intent);
        } else if (id == R.id.nav_videolectures) {

            Alerter.create(MainActivity.this)
                    .setTitle("Update Coming Soon")
                    .setText("\nSorry Guys & Big Update Coming Soon..")
                    .setBackgroundColorRes(R.color.main2)
                    .show();


        } else if (id == R.id.nav_shortnotes) {
            Alerter.create(MainActivity.this)
                    .setTitle("Update Coming Soon")
                    .setText("\nSorry Guys & Big Update Coming Soon..")
                    .setBackgroundColorRes(R.color.main2)
                    .show();
        } else if (id == R.id.nav_labprogram) {
            Intent intent = new Intent(MainActivity.this, Semester.class);
            startActivity(intent);
        } else if (id == R.id.nav_questionpaper) {
            Intent intent = new Intent(MainActivity.this, Question.class);
            startActivity(intent);
        } else if (id == R.id.nav_solution) {
            Alerter.create(MainActivity.this)
                    .setTitle("Update Coming Soon")
                    .setText("\nSorry Guys & Big Update Coming Soon..")
                    .setBackgroundColorRes(R.color.main2)
                    .show();
        } else if (id == R.id.nav_send) {

            Intent Email = new Intent(Intent.ACTION_SEND);
            Email.setType("text/email");
            Email.putExtra(Intent.EXTRA_EMAIL, new String[] { "vimalcvs29@gmail.com" });
            Email.putExtra(Intent.EXTRA_SUBJECT, "Feedback");
            Email.putExtra(Intent.EXTRA_TEXT, "Dear ...," + "");
            startActivity(Intent.createChooser(Email, "Send Feedback Email:"));
            return true;

        } else if (id == R.id.nav_about) {
            Intent intent = new Intent(MainActivity.this, AboutMe.class);
            startActivity(intent);

        } else if (id == R.id.nav_rateus) {

            try {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("market://details?id=" + this.getPackageName())));
            } catch (android.content.ActivityNotFoundException e) {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://play.google.com/store/apps/developer?id=Vimal%20CVS&hl=en" + this.getPackageName())));
            }


        } else if (id == R.id.nav_share) {
            String share = "  DU CS Lectures "+ "Download the app from the play store";
            String shareBody = share + "\nhttps://play.google.com/store/apps/developer?id=Vimal%20CVS&hl=en";
            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Official 2017 DU CS Lectures app");
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(sharingIntent, "Share via"));

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }









    @Override
    protected void onStop() {

        sliderLayout.stopAutoCycle();

        super.onStop();
    }
    @Override
    public void onSliderClick(BaseSliderView slider) {
    }
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

    @Override
    public void onPageSelected(int position) {
    }
    @Override
    public void onPageScrollStateChanged(int state) {}
    }

