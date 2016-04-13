package com.ulman.converter;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;


public class Settings extends PreferenceActivity {



    private final String WriteALetterToTheDeveloperKEY = "WriteALetterToTheDeveloperKEY";
    private final String digitsKey = "digitsKEY";
    private Preference editText;
    private Preference button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings);

        ActionBar actionBar = getActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);




        button = findPreference(WriteALetterToTheDeveloperKEY);
        button.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                Intent intent = new Intent(Settings.this,MailForDeveloper.class);
                startActivity(intent);
                return true;
            }
        });


        editText = findPreference(digitsKey);
        editText.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {


                editText.setSummary(((String) newValue));
                return true;
            }

        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        editText.setSummary(PreferenceManager.getDefaultSharedPreferences(this).getString(digitsKey,"0"));

    }
}