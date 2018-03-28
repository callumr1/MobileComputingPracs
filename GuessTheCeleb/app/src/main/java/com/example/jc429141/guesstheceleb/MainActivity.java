package com.example.jc429141.guesstheceleb;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;
    private ArrayAdapter<String> namesAdapter;
    final Random rnd = new Random();
    private int num = rnd.nextInt(4);
    private ImageView celebImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setContentView(R.layout.fragment_main);
        celebImageView = findViewById(R.id.celebImageView);

        final ImageView img = celebImageView;
        // Sets the imageView to a random image
        setRandomImage(img, num);
        // Sets the names in the AdapterArray to the corresponding names_array for that image
        String[] namesArray;
        String arrayName = ("names_" + num);
        if(arrayName.equals("names_0")){
            namesArray = getResources().getStringArray(R.array.names_0);
            namesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
            namesAdapter.addAll(namesArray);
        }
        else if(arrayName.equals("names_1")){
            namesArray = getResources().getStringArray(R.array.names_1);
            namesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
            namesAdapter.addAll(namesArray);
        }
        else if(arrayName.equals("names_2")){
            namesArray = getResources().getStringArray(R.array.names_2);
            namesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
            namesAdapter.addAll(namesArray);
        }
        else if(arrayName.equals("names_3")){
            namesArray = getResources().getStringArray(R.array.names_3);
            namesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
            namesAdapter.addAll(namesArray);
        }
        else if(arrayName.equals("names_4")){
            namesArray = getResources().getStringArray(R.array.names_4);
            namesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
            namesAdapter.addAll(namesArray);
        }
        gridView = findViewById(R.id.gridView);
        gridView.setAdapter(namesAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                String answer = getCorrectName();
                if(selectedItem.equals(answer)){
                    Toast.makeText(MainActivity.this, "You are Correct", Toast.LENGTH_SHORT).show();
                    setRandomImage(img, rnd.nextInt(4));
                    setRandomNames(num);
                }
                else{
                    Toast.makeText(MainActivity.this, "You are Incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private String getCorrectName() {
        // Gets the correct name based on the image that is displayed
        String imageName = String.valueOf(celebImageView.getTag());
        String correctName = null;
        if(imageName.equals("img_0")){
            correctName = "Brad Pitt";
        }
        else if(imageName.equals("img_1")){
            correctName = "Mr Bean";
        }
        else if(imageName.equals("img_2")){
            correctName = "Matt Mercer";
        }
        else if(imageName.equals("img_3")){
            correctName = "Marisha Ray";
        }
        else if(imageName.equals("img_4")){
            correctName = "Travis Willingham";
        }
        return correctName;
    }

    private void setRandomNames(int num) {
        String[] namesArray;
        String arrayName = ("names_" + num);
        if(arrayName.equals("names_0")){
            namesArray = getResources().getStringArray(R.array.names_0);
            namesAdapter.clear();
            namesAdapter.addAll(namesArray);
        }
        else if(arrayName.equals("names_1")){
            namesArray = getResources().getStringArray(R.array.names_1);
            namesAdapter.clear();
            namesAdapter.addAll(namesArray);
        }
        else if(arrayName.equals("names_2")){
            namesArray = getResources().getStringArray(R.array.names_2);
            namesAdapter.clear();
            namesAdapter.addAll(namesArray);
        }
        else if(arrayName.equals("names_3")){
            namesArray = getResources().getStringArray(R.array.names_3);
            namesAdapter.clear();
            namesAdapter.addAll(namesArray);
        }
        else if(arrayName.equals("names_4")){
            namesArray = getResources().getStringArray(R.array.names_4);
            namesAdapter.clear();
            namesAdapter.addAll(namesArray);
        }
        gridView = findViewById(R.id.gridView);
        namesAdapter.notifyDataSetChanged();
        gridView.setAdapter(namesAdapter);
    }

    private void setRandomImage(ImageView img, int num) {
        final String str = "img_" + num;
        img.setImageDrawable(getResources().getDrawable(getResourceID(str, "drawable", getApplicationContext())));
        celebImageView.setTag(str);
    }

    protected final static int getResourceID(final String resName, final String resType, final Context ctx) {
        final int ResourceID = ctx.getResources().getIdentifier(resName, resType, ctx.getApplicationInfo().packageName);
        if(ResourceID == 0){
            throw new IllegalArgumentException("No resource string found with name " + resName);
        }
        else {
            return ResourceID;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_PORTRAIT){
            getMenuInflater().inflate(R.menu.menu_main, menu);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, SecondaryActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
