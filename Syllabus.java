package com.ducslectures.vimal;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class Syllabus extends AppCompatActivity  {
    ListView mListView;
    SearchView searchView;
    ArrayAdapter<String> adapter;
    String[] vimal = new String[]{
            "1. Programming Fundamentals using C++",
            "2. Computer System Architecture",
            "3. Programming in JAVA",
            "4. Discrete Structures",
            "5. Data Structures",
            "6. Operating Systems",
            "7. Computer Networks",
            "8. Design and Analysis of Algorithms",
            "9. Software Engineering",
            "10. Database Management Systems",
            "11. Internet Technologies",
            "12. Theory of Computation",
            "13. Artificial Intelligence",
            "14. Computer Graphics"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syllabus);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        mListView = (ListView) findViewById(R.id.listview);
        adapter = new ArrayAdapter<String>(this, R.layout.programlist, R.id.textView4, vimal);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int itemPosition = position;
                String itemValue = (String) mListView.getItemAtPosition(position);
                if (position == 0) {

                    Intent i = new Intent(Syllabus.this, Webview.class);
                    i.putExtra("keyHTML", "file:///android_asset/syllabus/Programming_Fundamentals.htm");
                    String message = "Programming Fundamentals";
                    i.putExtra("key", message);
                    startActivity(i);

                }
                if (position == 1) {

                    Intent i = new Intent(Syllabus.this, Webview.class);
                    i.putExtra("keyHTML", "file:///android_asset/syllabus/Book_Computer_System_Architecture.htm");
                    String message = "Computer System Architecture";
                    i.putExtra("key", message);
                    startActivity(i);
                }
                if (position == 2) {

                    Intent i = new Intent(Syllabus.this, Webview.class);
                    i.putExtra("keyHTML", "file:///android_asset/syllabus/Book_Programming_in_Java.htm");
                    String message = "Programming in Java";
                    i.putExtra("key", message);
                    startActivity(i);
                }
                if (position == 3) {

                    Intent i = new Intent(Syllabus.this, Webview.class);
                    i.putExtra("keyHTML", "file:///android_asset/syllabus/Book_Discrete_Structures.htm");
                    String message = "Discrete Structures";
                    i.putExtra("key", message);
                    startActivity(i);


                }
                if (position == 4) {

                    Intent i = new Intent(Syllabus.this, Webview.class);
                    i.putExtra("keyHTML", "file:///android_asset/syllabus/Book_Data_Structures.htm");
                    String message = "Data Structures";
                    i.putExtra("key", message);
                    startActivity(i);
                }

                if (position == 5) {

                    Intent i = new Intent(Syllabus.this, Webview.class);
                    i.putExtra("keyHTML", "file:///android_asset/syllabus/Book_Operating_Systems.htm");
                    String message = "Operating Systems";
                    i.putExtra("key", message);
                    startActivity(i);
                }


                if (position == 6) {

                    Intent i = new Intent(Syllabus.this, Webview.class);
                    i.putExtra("keyHTML", "file:///android_asset/syllabus/Book_Computer_Networks.htm");
                    String message = "Computer Networks";
                    i.putExtra("key", message);
                    startActivity(i);

                }
                if (position == 7) {

                    Intent i = new Intent(Syllabus.this, Webview.class);
                    i.putExtra("keyHTML", "file:///android_asset/syllabus/Book_Designand_Analysis_of_Algorithms.htm");
                    String message = "Designand Analysis of Algorithms";
                    i.putExtra("key", message);
                    startActivity(i);

                }
                if (position == 8) {

                    Intent i = new Intent(Syllabus.this, Webview.class);
                    i.putExtra("keyHTML", "file:///android_asset/syllabus/Book_Software_Engineering_lab.htm");
                    String message = "Software Engineering";
                    i.putExtra("key", message);
                    startActivity(i);

                }
                if (position == 9) {

                    Intent i = new Intent(Syllabus.this, Webview.class);
                    i.putExtra("keyHTML", "file:///android_asset/syllabus/Book_Database_Management_Systems_lab.htm");
                    String message = "Database Management Systems";
                    i.putExtra("key", message);
                    startActivity(i);

                }

                if (position == 10) {

                    Intent i = new Intent(Syllabus.this, Webview.class);
                    i.putExtra("keyHTML", "file:///android_asset/syllabus/Book_Internet_Technologies_lab.htm");
                    String message = "Internet Technologies";
                    i.putExtra("key", message);
                    startActivity(i);

                }


                if (position == 11) {

                    Intent i = new Intent(Syllabus.this, Webview.class);
                    i.putExtra("keyHTML", "file:///android_asset/syllabus/Book_Theory_Computation_lab.htm");
                    String message = "Theory Computation";
                    i.putExtra("key", message);
                    startActivity(i);


                }
                if (position == 12) {

                    Intent i = new Intent(Syllabus.this, Webview.class);
                    i.putExtra("keyHTML", "file:///android_asset/syllabus/Book_Artificial_Intelligence_lab.htm");
                    String message = "Artificial Intelligence";
                    i.putExtra("key", message);
                    startActivity(i);

                }
                if (position == 13) {

                    Intent i = new Intent(Syllabus.this, Webview.class);
                    i.putExtra("keyHTML", "file:///android_asset/syllabus/Book_Computer_Graphics_lab.htm");
                    String message = "Computer Graphics";
                    i.putExtra("key", message);
                    startActivity(i);


                }


            }
        });

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
            Intent intent = new Intent(Syllabus.this, MainActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_back) {
            finish();
            return true;
        } else if (id == R.id.action_about) {
            Intent intent = new Intent(Syllabus.this, AboutMe.class);
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