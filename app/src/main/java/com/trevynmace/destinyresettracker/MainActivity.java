package com.trevynmace.destinyresettracker;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity
{
    private String PREFS = "com.trevynmace.destinyresettracker.main";

    CheckBox clanXpCheckbox;
    CheckBox callToArmsCheckbox;
    CheckBox flashpointCheckbox;
    CheckBox nightfallCheckbox;
    CheckBox treasureMapsCheckbox;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clanXpCheckbox = (CheckBox) findViewById(R.id.clanXpCheckbox);
        callToArmsCheckbox = (CheckBox) findViewById(R.id.callToArmsCheckbox);
        flashpointCheckbox = (CheckBox) findViewById(R.id.flashpointCheckbox);
        nightfallCheckbox = (CheckBox) findViewById(R.id.nightfallCheckbox);
        treasureMapsCheckbox = (CheckBox) findViewById(R.id.treasureMapsCheckbox);

        setCheckboxes();

        Button resetButton = (Button) findViewById(R.id.resetButton);
        resetButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                clanXpCheckbox.setChecked(false);
                callToArmsCheckbox.setChecked(false);
                flashpointCheckbox.setChecked(false);
                nightfallCheckbox.setChecked(false);
                treasureMapsCheckbox.setChecked(false);
            }
        });
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        setCheckboxes();
    }

    private void setCheckboxes()
    {
        SharedPreferences prefs = getSharedPreferences(PREFS, MODE_PRIVATE);
        clanXpCheckbox.setChecked(prefs.getBoolean("clanXpCheckbox", false));
        callToArmsCheckbox.setChecked(prefs.getBoolean("callToArmsCheckbox", false));
        flashpointCheckbox.setChecked(prefs.getBoolean("flashpointCheckbox", false));
        nightfallCheckbox.setChecked(prefs.getBoolean("nightfallCheckbox", false));
        treasureMapsCheckbox.setChecked(prefs.getBoolean("treasureMapsCheckbox", false));
    }

    @Override
    protected void onPause()
    {
        super.onPause();

        SharedPreferences.Editor editor = getSharedPreferences(PREFS, MODE_PRIVATE).edit();
        editor.putBoolean("clanXpCheckbox", clanXpCheckbox.isChecked());
        editor.putBoolean("callToArmsCheckbox", callToArmsCheckbox.isChecked());
        editor.putBoolean("flashpointCheckbox", flashpointCheckbox.isChecked());
        editor.putBoolean("nightfallCheckbox", nightfallCheckbox.isChecked());
        editor.putBoolean("treasureMapsCheckbox", treasureMapsCheckbox.isChecked());
        editor.apply();
    }
}
