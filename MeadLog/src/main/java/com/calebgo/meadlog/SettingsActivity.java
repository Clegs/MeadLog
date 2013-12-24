package com.calebgo.meadlog;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import org.apache.http.client.protocol.ClientContextConfigurer;

/**
 * Created by caleb on 12/23/13.
 */
public class SettingsActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        EditText serverText = (EditText)findViewById(R.id.serverText);
        serverText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                serverTextChanged(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        // Get the server url.
        SharedPreferences preferences = getSharedPreferences(Configuration.getInstance().globalSharedPrefsName(),
                MODE_PRIVATE);
        serverText.setText(preferences.getString(Configuration.getInstance().serverKey(), ""),
                TextView.BufferType.EDITABLE);
    }

    protected void serverTextChanged(String text) {
        SharedPreferences preferences = getSharedPreferences(Configuration.getInstance().globalSharedPrefsName(),
                MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(Configuration.getInstance().serverKey(), text);
        editor.commit();
    }
}
