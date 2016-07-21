package com.ulman.android.converter;

import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.widget.Toast;


public class SettingsActivity extends PreferenceActivity {

    private final String WriteALetterToTheDeveloperKEY = "WriteALetterToTheDeveloperKEY";

    private Preference button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings);


        button = findPreference(WriteALetterToTheDeveloperKEY);
        button.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {

                Intent intent = new Intent(Intent.ACTION_SEND);

                intent.setType("message/rfc822");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{getString(R.string.developer_email)});
                intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.subject_of_email));

                //TODO add EXTRA_TEXT
                //intent.putExtra(Intent.EXTRA_TEXT, message.getText().toString());

                try {
                    startActivity(Intent.createChooser(intent, getString(R.string.choose_an_email_client)));


                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(SettingsActivity.this,
                            R.string.no_email_client, Toast.LENGTH_SHORT).show();
                    return true;
                }



                return true;
            }
        });

    }


}
