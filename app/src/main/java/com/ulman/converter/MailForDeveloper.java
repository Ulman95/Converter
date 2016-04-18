package com.ulman.converter;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MailForDeveloper extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail_for_developer);

        ActionBar actionBar = getActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_mail_for_developer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id) {
            case R.id.action_send:

                final Intent intent = new Intent(Intent.ACTION_SEND);

                EditText message = (EditText) findViewById(R.id.message);

                intent.setType("message/rfc822");
                intent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{getString(R.string.developer_email)});
                intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.subject_of_email));
                intent.putExtra(Intent.EXTRA_TEXT, message.getText().toString());

                try {
                    startActivity(Intent.createChooser(intent, getString(R.string.choose_an_email_client)));
                    finish();

                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(MailForDeveloper.this,
                            "There is no email client installed.", Toast.LENGTH_SHORT).show();
                    return true;
                }


        }
        return super.onOptionsItemSelected(item);
    }
}
