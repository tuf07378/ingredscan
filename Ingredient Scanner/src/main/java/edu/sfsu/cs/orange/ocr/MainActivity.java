package edu.sfsu.cs.orange.ocr;

import android.content.Intent;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final String sendTest = "test from main activity";

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
}
