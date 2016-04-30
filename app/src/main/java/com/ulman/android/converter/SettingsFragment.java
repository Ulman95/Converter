package com.ulman.android.converter;

import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;


public class SettingsFragment extends PreferenceFragment {

    private final String WriteALetterToTheDeveloperKEY = "WriteALetterToTheDeveloperKEY";
    private final String digitsKey = "digitsKEY";
    private Preference editText;
    private Preference button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings);


        button = findPreference(WriteALetterToTheDeveloperKEY);
        button.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                Intent intent = new Intent(getActivity(),MailForDeveloperActivity.class);
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
    public void onResume() {
        super.onResume();
        editText.setSummary(PreferenceManager.getDefaultSharedPreferences(getActivity()).getString(digitsKey,"0"));

    }

}
