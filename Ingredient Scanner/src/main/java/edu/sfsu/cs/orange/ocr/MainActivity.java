package edu.sfsu.cs.orange.ocr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    Button cameraActivityButton;
    Button settingsActivityButton;
    Button resultsActivityButton;
    Button allergyPreferencesActivityButton;
    ImageButton helpActivityButton;
    private boolean firstLaunch = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initializes our preferences.
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        if(prefs.getBoolean("first_launch_main_activity", true))
            setDefaultPreferences();
        prefs.edit().putBoolean("first_launch_main_activity", false).apply();

        cameraActivityButton = (Button)findViewById(R.id.capture_activity_button);
        cameraActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), CaptureActivity.class);
                startActivity(i); //will send us there
            }
        });

        settingsActivityButton = (Button)findViewById(R.id.settings_button);
        settingsActivityButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), PreferencesActivity.class);
                startActivity(i); //sends us to options!
            }
        });

        resultsActivityButton = (Button)findViewById(R.id.results_button_test);
        resultsActivityButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ResultsActivity.class);
                startActivity(i); //sends us to results test!
            }
        });

        allergyPreferencesActivityButton = (Button)findViewById(R.id.allergen_button_main);
        allergyPreferencesActivityButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), AllergenPreferencesActivity.class);
                startActivity(i); //sends us to results test!
            }
        });


        helpActivityButton = (ImageButton)findViewById(R.id.help_button);
        helpActivityButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), HelpActivity.class);
                startActivity(i); //sends us to results test!
            }
        });
    }

    private void setDefaultPreferences() {

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        // Continuous preview
        prefs.edit().putBoolean(PreferencesActivity.KEY_CONTINUOUS_PREVIEW, CaptureActivity.DEFAULT_TOGGLE_CONTINUOUS).commit();

        // Recognition language
        prefs.edit().putString(PreferencesActivity.KEY_SOURCE_LANGUAGE_PREFERENCE, CaptureActivity.DEFAULT_SOURCE_LANGUAGE_CODE).commit();

        // Translation
        prefs.edit().putBoolean(PreferencesActivity.KEY_TOGGLE_TRANSLATION, CaptureActivity.DEFAULT_TOGGLE_TRANSLATION).commit();

        // Translation target language
        prefs.edit().putString(PreferencesActivity.KEY_TARGET_LANGUAGE_PREFERENCE, CaptureActivity.DEFAULT_TARGET_LANGUAGE_CODE).commit();

        // Translator
        prefs.edit().putString(PreferencesActivity.KEY_TRANSLATOR, CaptureActivity.DEFAULT_TRANSLATOR).commit();

        // OCR Engine
        prefs.edit().putString(PreferencesActivity.KEY_OCR_ENGINE_MODE, CaptureActivity.DEFAULT_OCR_ENGINE_MODE).commit();

        // Autofocus
        prefs.edit().putBoolean(PreferencesActivity.KEY_AUTO_FOCUS, CaptureActivity.DEFAULT_TOGGLE_AUTO_FOCUS).commit();

        // Disable problematic focus modes
        prefs.edit().putBoolean(PreferencesActivity.KEY_DISABLE_CONTINUOUS_FOCUS, CaptureActivity.DEFAULT_DISABLE_CONTINUOUS_FOCUS).commit();

        // Beep
        prefs.edit().putBoolean(PreferencesActivity.KEY_PLAY_BEEP, CaptureActivity.DEFAULT_TOGGLE_BEEP).commit();

        // Character blacklist
        prefs.edit().putString(PreferencesActivity.KEY_CHARACTER_BLACKLIST,
                OcrCharacterHelper.getDefaultBlacklist(CaptureActivity.DEFAULT_SOURCE_LANGUAGE_CODE)).commit();

        // Character whitelist
        prefs.edit().putString(PreferencesActivity.KEY_CHARACTER_WHITELIST,
                OcrCharacterHelper.getDefaultWhitelist(CaptureActivity.DEFAULT_SOURCE_LANGUAGE_CODE)).commit();

        // Page segmentation mode
        prefs.edit().putString(PreferencesActivity.KEY_PAGE_SEGMENTATION_MODE, CaptureActivity.DEFAULT_PAGE_SEGMENTATION_MODE).commit();

        // Reversed camera image
        prefs.edit().putBoolean(PreferencesActivity.KEY_REVERSE_IMAGE, CaptureActivity.DEFAULT_TOGGLE_REVERSED_IMAGE).commit();

        // Light
        prefs.edit().putBoolean(PreferencesActivity.KEY_TOGGLE_LIGHT, CaptureActivity.DEFAULT_TOGGLE_LIGHT).commit();
    }
}
