package com.ducslectures.vimal;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tapadoo.alerter.Alerter;


/**
 * Created by VIMALKUMAR on 02-06-2018.
 */

public class AboutMe extends AppCompatActivity {
private TextView verboseAlertBt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);





        verboseAlertBt = (TextView)findViewById(R.id.verboseAlertBtn);
        verboseAlertBt.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick (View v){

                Alerter.create(AboutMe.this)
                        .setTitle("Thanks/ About")
                        .setText("Made by: Vimal K. Vishwakarma " +
                                "\n" +
                                "\nSpecial thanks to:"+
                                 "\n" +
                                "\nEshu.")
                        .setBackgroundColorRes(R.color.colorPrimary)
                        .show();
            }
        });


        String link = "<a href=\"https://ducslecture.blogspot.com\">Visit our Website</a>";
        String facbook = "<a href=\"http://www.facebook.com/vimalcvs\">Like us on Facebook</a>";
        String twitter = "<a href=\"https://twitter.com/vimalvishwakar6\">Follow us on Twitter</a>";
        String whatsapp = "<a href=\"https://chat.whatsapp.com/3WJbPRQyy89AKlltS56lYy\">Join WhatsApp Groups</a>";
        String google = "<a href=\"https://plus.google.com/u/0/+VIMALvimalcvs\">Connect us on Google+</a>";
        String instagram = "<a href=\"https://www.instagram.com/vimal.vkv\">Follow us on Instagram</a>";
        String youtube = "<a href=\"https://www.youtube.com/channel/UC-mogeuYT8Gn6DWvvP4DCnQ\">Subscribe my YouTube Channel</a>";

        TextView text = (TextView) findViewById(R.id.id_link);
        text.setText(Html.fromHtml(link));
        text.setMovementMethod(LinkMovementMethod.getInstance());

        TextView text1 = (TextView) findViewById(R.id.id_facbook);
        text1.setText(Html.fromHtml(facbook));
        text1.setMovementMethod(LinkMovementMethod.getInstance());

        TextView text2 = (TextView) findViewById(R.id.id_twitter);
        text2.setText(Html.fromHtml(twitter));
        text2.setMovementMethod(LinkMovementMethod.getInstance());

        TextView text3 = (TextView) findViewById(R.id.id_whatsapp);
        text3.setText(Html.fromHtml(whatsapp));
        text3.setMovementMethod(LinkMovementMethod.getInstance());

        TextView text4 = (TextView) findViewById(R.id.id_google);
        text4.setText(Html.fromHtml(google));
        text4.setMovementMethod(LinkMovementMethod.getInstance());


        TextView text5 = (TextView) findViewById(R.id.id_instagram);
        text5.setText(Html.fromHtml(instagram));
        text5.setMovementMethod(LinkMovementMethod.getInstance());

        TextView text6 = (TextView) findViewById(R.id.id_youtube);
        text6.setText(Html.fromHtml(youtube));
        text6.setMovementMethod(LinkMovementMethod.getInstance());
    }



    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        int id = item.getItemId();
        if (id == R.id.action_home) {
            Intent intent = new Intent(AboutMe.this, MainActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_back) {
            finish();
            return true;
        } else if (id == R.id.action_about) {
            Intent intent = new Intent(AboutMe.this, AboutMe.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_exit) {
            AlertDialog.Builder builder = new AlertDialog.Builder(AboutMe.this);
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
