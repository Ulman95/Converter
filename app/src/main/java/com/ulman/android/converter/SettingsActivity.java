package com.ulman.android.converter;

import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.support.annotation.NonNull;
import android.widget.Toast;

public class SettingsActivity extends PreferenceActivity
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings);

        Preference button = findPreference(getString(R.string.write_a_letter_to_the_developer_key));
        button.setOnPreferenceClickListener(preference -> startMessage());

    }

    private boolean startMessage()
    {
        Intent intent = createIntent();

        //TODO add EXTRA_TEXT
        //intent.putExtra(Intent.EXTRA_TEXT, message.getText().toString());

        try
        {
            startActivity(Intent.createChooser(intent, getString(R.string.choose_an_email_client)));
        }
        catch (android.content.ActivityNotFoundException ex)
        {
            Toast.makeText(SettingsActivity.this,
                    R.string.no_email_client, Toast.LENGTH_SHORT).show();
        }

        return true;
    }

    @NonNull
    private Intent createIntent()
    {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("message/rfc822");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{getString(R.string.developer_email)});
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.subject_of_email));

        return intent;
    }
}
