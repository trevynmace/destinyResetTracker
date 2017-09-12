package com.trevynmace.destinyresettracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO: have a list of items on the screen with checkboxes next to them.
        // reset button underneath to reset them all to unchecked.
        // save the isChecked to the prefs.
    }
}
