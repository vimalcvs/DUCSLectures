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

import com.ducslectures.vimal.questionpapers.Question;
import com.ducslectures.vimal.semesterprogram.Semester;

public class NewUpdate extends AppCompatActivity{

    ListView mListView;
    SearchView searchView;
    ArrayAdapter<String> adapter;
    String[] vimal = new String[]{
            "Previous Year Question Papers.",
            "Added All the Question in CSA, DBMS",
            "Implement DFS.",
            "Wap to Determine the LCS of two given Sequence.",
            "Wap to implement Radix Sort",
            "Implement Heap Sort (The program should report the number of comparisons).",
            "Implement Randomized Quick sort (The program should report the number of comparisons)",
            "Write a program to determine the minimum spanning tree of a graph.",
            "Create a Red-Black Tree and perform following operations on it: \n" +
                    "i. Insert a node \n" +
                    "ii. Delete a node \n" +
                    "iii. Search for a number & also report the colour of the node containing this number.\n"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pro__sem4_daa);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mListView = (ListView) findViewById(R.id.list);
        adapter = new ArrayAdapter<String>(this, R.layout.rowview, R.id.textView4, vimal);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int itemPosition = position;
                String itemValue = (String) mListView.getItemAtPosition(position);

                if (position == 0) {
                    Intent i = new Intent(NewUpdate.this, Question.class);
                    startActivity(i);
                }
                if (position == 1) {
                    Intent i = new Intent(NewUpdate.this, Semester.class);

                    startActivity(i);
                }
                if (position == 2) {
                    Intent i = new Intent(NewUpdate.this, Program_Webview.class);
                    i.putExtra("keyHTML", "file:///android_asset/program/DAA/Q3.html");
                    String message = "Implement DFS";
                    i.putExtra("key", message);
                    startActivity(i);
                }
                if (position == 3) {
                    Intent i = new Intent(NewUpdate.this, Program_Webview.class);
                    i.putExtra("keyHTML", "file:///android_asset/program/DAA/Q4.html");
                    String message = "Determine the LCS of two given Sequence";
                    i.putExtra("key", message);
                    startActivity(i);
                }
                if (position == 4) {
                    Intent i = new Intent(NewUpdate.this, Program_Webview.class);
                    i.putExtra("keyHTML", "file:///android_asset/program/DAA/Q5.html");
                    String message = "Radix Sort";
                    i.putExtra("key", message);
                    startActivity(i);
                }
                if (position == 5) {
                    Intent i = new Intent(NewUpdate.this, Program_Webview.class);
                    i.putExtra("keyHTML", "file:///android_asset/program/DAA/Q6.html");
                    String message = "Heap Sort Number of Comparisons";
                    i.putExtra("key", message);
                    startActivity(i);
                }
                if (position == 6) {
                    Intent i = new Intent(NewUpdate.this, Program_Webview.class);
                    i.putExtra("keyHTML", "file:///android_asset/program/DAA/Q7.html");
                    String message = "Randomized Quick sort";
                    i.putExtra("key", message);
                    startActivity(i);
                }
                if (position == 7) {
                    Intent i = new Intent(NewUpdate.this, Program_Webview.class);
                    i.putExtra("keyHTML", "file:///android_asset/program/DAA/Q8.html");
                    String message = "Determine the Minimum Spanning tree of a graph";
                    i.putExtra("key", message);
                    startActivity(i);
                }
                if (position == 8) {
                    Intent i = new Intent(NewUpdate.this, Program_Webview.class);
                    i.putExtra("keyHTML", "file:///android_asset/program/DAA/Q9.html");
                    String message = "Red-Black Tree";
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
            Intent intent = new Intent(NewUpdate .this, MainActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_back) {
            finish();
            return true;
        } else if (id == R.id.action_about) {
            Intent intent = new Intent(NewUpdate.this, AboutMe.class);
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